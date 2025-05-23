package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.Order;
import co.edu.unbosque.LaForestaTrading.exception.EmailException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmailServiceImplTest {

    private JavaMailSender mailSender;
    private EmailServiceImpl emailService;

    @BeforeEach
    void setUp() {
        mailSender = mock(JavaMailSender.class);
        emailService = new EmailServiceImpl(mailSender);
    }

    @Test
    void testSendEmail_Success() {
        emailService.sendEmail("test@mail.com", "Test Subject", "Test Body");

        ArgumentCaptor<SimpleMailMessage> captor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender).send(captor.capture());

        SimpleMailMessage sent = captor.getValue();
        assertEquals("test@mail.com", sent.getTo()[0]);
        assertEquals("Test Subject", sent.getSubject());
        assertEquals("Test Body", sent.getText());
    }

    @Test
    void testSendConfirmationEmail_Success() {
        Order order = new Order();
        order.setStatus("pending");
        order.setSide("buy");
        order.setType("market");
        order.setSymbol("AAPL");
        order.setFilledAvgPrice("150.25");
        order.setLocalCreationDate(LocalDateTime.of(2025, 5, 22, 10, 30));

        Investor investor = new Investor();
        investor.setEmail("investor@mail.com");

        emailService.sendConfirmationEmail(order, investor);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void testSendConfirmationEmail_ThrowsExceptionIfOrderIsNull() {
        Investor investor = new Investor();
        investor.setEmail("investor@mail.com");

        assertThrows(EmailException.class, () -> emailService.sendConfirmationEmail(null, investor));
    }

    @Test
    void testSendConfirmationEmail_ThrowsExceptionIfInvestorIsNull() {
        Order order = new Order();
        assertThrows(EmailException.class, () -> emailService.sendConfirmationEmail(order, null));
    }

    @Test
    void testSendConfirmationEmail_ThrowsExceptionIfEmailIsNull() {
        Order order = new Order();
        Investor investor = new Investor(); // email is null
        assertThrows(EmailException.class, () -> emailService.sendConfirmationEmail(order, investor));
    }
}
