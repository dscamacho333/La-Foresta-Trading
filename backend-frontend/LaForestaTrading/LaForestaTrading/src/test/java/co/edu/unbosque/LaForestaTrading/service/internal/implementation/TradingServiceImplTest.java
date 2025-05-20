package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.*;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import co.edu.unbosque.LaForestaTrading.service.external.interfaces.IAlpacaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TradingServiceImplTest {

    private IUserRepository repo;
    private IAlpacaService alpacaService;
    private TradingServiceImpl service;
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        repo = mock(IUserRepository.class);
        alpacaService = mock(IAlpacaService.class);
        service = new TradingServiceImpl(repo, new ModelMapper(), alpacaService, passwordEncoder);
    }

    @Test
    public void testRegisterSuccess() {
        AccountDTO dto = buildDummyAccountDTO();
        when(repo.findByTaxId(anyString())).thenReturn(null);
        when(alpacaService.createAccount(any(AccountDTO.class)))
                .thenReturn(buildDummyAccountResponseDTO());

        when(repo.save(any(Investor.class))).thenReturn(new Investor());

        boolean result = service.register(dto, "securePass123");

        assertTrue(result);
        verify(repo, times(1)).save(any(Investor.class));
    }


    @Test
    public void testRegisterThrowsUserExceptionWhenDuplicateTaxId() {
        AccountDTO dto = buildDummyAccountDTO();
        when(repo.findByTaxId(anyString())).thenReturn(new Investor());

        UserException exception = assertThrows(UserException.class, () ->
                service.register(dto, "securePass123"));

        assertEquals("Número de identificación duplicado", exception.getMessage());
    }

    @Test
    public void testRegisterThrowsUserExceptionWhenDataIntegrityViolation() {
        AccountDTO dto = buildDummyAccountDTO();
        when(repo.findByTaxId(anyString())).thenReturn(null);
        when(alpacaService.createAccount(any(AccountDTO.class)))
                .thenReturn(buildDummyAccountResponseDTO());

        doThrow(DataIntegrityViolationException.class).when(repo).save(any(Investor.class));

        UserException exception = assertThrows(UserException.class, () ->
                service.register(dto, "securePass123"));

        assertEquals("Los siguientes campos deben ser unicos: Correo electronico y número de identificación", exception.getMessage());
    }


    @Test
    public void testVerificarCuentasPendientesUpdatesStatusToActive() {
        Investor pendingInvestor = new Investor();
        pendingInvestor.setAlpacaId("abc123");
        pendingInvestor.setPasswordHash("hashedPass");
        pendingInvestor.setTaxId("123456789");
        pendingInvestor.setAlpacaStatus("SUBMITTED");

        AccountResponseDTO activeResponse = buildDummyAccountResponseDTO();
        activeResponse.setStatus("ACTIVE");

        when(repo.findByAlpacaStatus("SUBMITTED")).thenReturn(List.of(pendingInvestor));
        when(alpacaService.getAnAccountById("abc123")).thenReturn(activeResponse);

        service.verificarCuentasPendientes();

        verify(repo).save(any(Investor.class));
    }

    @Test
    public void testVerificarCuentasPendientesNoUpdateWhenStillSubmitted() {
        Investor pendingInvestor = new Investor();
        pendingInvestor.setAlpacaId("abc123");
        pendingInvestor.setPasswordHash("hashedPass");
        pendingInvestor.setTaxId("123456789");
        pendingInvestor.setAlpacaStatus("SUBMITTED");

        AccountResponseDTO stillSubmitted = buildDummyAccountResponseDTO();
        stillSubmitted.setStatus("SUBMITTED");

        when(repo.findByAlpacaStatus("SUBMITTED")).thenReturn(List.of(pendingInvestor));
        when(alpacaService.getAnAccountById("abc123")).thenReturn(stillSubmitted);

        service.verificarCuentasPendientes();

        verify(repo, never()).save(any());
    }

    private AccountDTO buildDummyAccountDTO() {
        ContactDTO contact = new ContactDTO("test@email.com", "1234567890", List.of("Street 1"), "City", "State", "12345");
        IdentityDTO identity = new IdentityDTO("John", "Doe", "2000-01-01", "CO", "CO", "individual", "123456789", "national_id", "CO", List.of("savings"));
        DisclosureDTO disclosure = new DisclosureDTO(false, false, false, false, false, false);
        AgreementDTO agreement = new AgreementDTO("customer_agreement", "2024-01-01T00:00:00Z", "127.0.0.1");
        return new AccountDTO(contact, identity, disclosure, List.of(agreement));
    }

    private AccountResponseDTO buildDummyAccountResponseDTO() {
        ContactDTO contact = new ContactDTO("test@email.com", "1234567890", List.of("Street 1"), "City", "State", "12345");
        IdentityDTO identity = new IdentityDTO("John", "Doe", "2000-01-01", "CO", "CO", "individual", "123456789", "national_id", "CO", List.of("salary"));
        DisclosureDTO disclosure = new DisclosureDTO(false, false, false, false, false, false);
        return new AccountResponseDTO("abc123", "acc789", "SUBMITTED", "INACTIVE", "USD", "0.00", "2024-01-01T10:00:00Z",
                contact, identity, disclosure, Collections.emptyList(), "trading", "margin", null, List.of("us_equity"));
    }
}
