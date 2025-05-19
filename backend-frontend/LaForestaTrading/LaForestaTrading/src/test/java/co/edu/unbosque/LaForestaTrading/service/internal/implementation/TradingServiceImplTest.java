package co.edu.unbosque.LaForestaTrading.service.internal.implementation;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.*;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import co.edu.unbosque.LaForestaTrading.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TradingServiceImplTest {

    private IUserRepository repo;
    private TradingServiceImpl service;

    @BeforeEach
    public void setUp() {
        repo = mock(IUserRepository.class);
        service = new TradingServiceImpl(repo, new ModelMapper());
    }

    @Test
    public void testRegisterSuccess() {
        AccountDTO dto = buildDummyAccountDTO();
        boolean result = service.register(dto, "securePass123");
        assertTrue(result);
        verify(repo, times(1)).save(any(Investor.class));
    }

    @Test
    public void testRegisterThrowsUserExceptionWhenDuplicate() {
        AccountDTO dto = buildDummyAccountDTO();
        doThrow(DataIntegrityViolationException.class).when(repo).save(any(Investor.class));
        UserException exception = assertThrows(UserException.class, () -> {
            service.register(dto, "securePass123");
        });
        assertEquals("Los siguientes campos deben ser unicos: Correo electronico y número de identificación", exception.getMessage());
    }

    private AccountDTO buildDummyAccountDTO() {
        ContactDTO contact = new ContactDTO("test@email.com", "1234567890", List.of("Street 1"), "City", "State", "12345");
        IdentityDTO identity = new IdentityDTO("John", "Doe", "2000-01-01", "CO", "CO", "individual", "123456789", "national_id", "CO", List.of("savings"));
        DisclosureDTO disclosure = new DisclosureDTO(false, false, false, false, false, false);
        AgreementDTO agreement = new AgreementDTO("customer_agreement", "2024-01-01T00:00:00Z", "127.0.0.1");
        return new AccountDTO(contact, identity, disclosure, List.of(agreement));
    }
}
