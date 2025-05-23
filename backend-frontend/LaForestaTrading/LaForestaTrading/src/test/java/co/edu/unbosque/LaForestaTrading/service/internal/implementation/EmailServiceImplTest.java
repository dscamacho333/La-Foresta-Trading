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
    void testSendEmailSuccess() {
        emailService.sendEmail("test@example.com", "Asunto", "Mensaje");

        ArgumentCaptor<SimpleMailMessage> captor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(mailSender).send(captor.capture());

        SimpleMailMessage sent = captor.getValue();
        assertEquals("test@example.com", sent.getTo()[0]);
        assertEquals("Asunto", sent.getSubject());
        assertEquals("Mensaje", sent.getText());
    }

    @Test
    void testSendConfirmationEmailSuccess() {
        Investor investor = new Investor();
        investor.setEmail("cliente@test.com");

        Order order = new Order();
        order.setStatus("pending");
        order.setSide("buy");
        order.setType("market");
        order.setSymbol("AAPL");
        order.setFilledAvgPrice("190.00");
        order.setLocalCreationDate(LocalDateTime.of(2025, 5, 23, 10, 30));

        emailService.sendConfirmationEmail(order, investor);

        verify(mailSender, times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void testSendConfirmationEmailFailsWithNullOrder() {
        Investor investor = new Investor();
        investor.setEmail("test@example.com");

        assertThrows(EmailException.class, () -> {
            emailService.sendConfirmationEmail(null, investor);
        });
    }

    @Test
    void testSendConfirmationEmailFailsWithNullInvestor() {
        Order order = new Order();
        order.setSymbol("AAPL");

        assertThrows(EmailException.class, () -> {
            emailService.sendConfirmationEmail(order, null);
        });
    }

    @Test
    void testSendConfirmationForExecutedOrderSuccess() {
        Investor investor = new Investor();
        investor.setEmail("ejecutado@test.com");

        Order order = new Order();
        order.setStatus("filled");
        order.setSide("sell");
        order.setType("limit");
        order.setSymbol("MSFT");
        order.setFilledAvgPrice("250.50");
        order.setLocalCreationDate(LocalDateTime.of(2025, 5, 23, 12, 0));

        emailService.sendConfirmationForExcutedOrder(order, investor);

        verify(mailSender).send(any(SimpleMailMessage.class));
    }

    @Test
    void testSendConfirmationForExecutedOrderFailsWithNullInvestorEmail() {
        Investor investor = new Investor();
        investor.setEmail(null);

        Order order = new Order();
        order.setSymbol("TSLA");

        assertThrows(EmailException.class, () -> {
            emailService.sendConfirmationForExcutedOrder(order, investor);
        });
    }
}
