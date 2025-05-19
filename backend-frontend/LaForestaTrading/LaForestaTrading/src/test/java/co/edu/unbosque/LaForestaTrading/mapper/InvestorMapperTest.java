package co.edu.unbosque.LaForestaTrading.mapper;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.ContactDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.DisclosureDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.IdentityDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InvestorMapperTest {

    @Test
    public void testFromAccountResponseDTOValidDataShouldMapCorrectly() {
        AccountResponseDTO dto = buildDummyAccountResponseDTO();
        Investor baseInvestor = new Investor();
        Investor result = InvestorMapper.fromAccountResponseDTO(dto, baseInvestor, "hashedPassword");

        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("test@email.com", result.getEmail());
        assertEquals("hashedPassword", result.getPasswordHash());
        assertEquals("123456789", result.getTaxId());
    }

    @Test
    public void testFromAccountResponseDTOInvalidTaxIdShouldThrowException() {
        AccountResponseDTO dto = buildDummyAccountResponseDTO();
        dto.getIdentityDTO().setTaxId("abc123");
        assertThrows(UserException.class, () -> InvestorMapper.fromAccountResponseDTO(dto, new Investor(), "pass"));
    }

    @Test
    public void testFromAccountResponseDTOUnderageShouldThrowException() {
        AccountResponseDTO dto = buildDummyAccountResponseDTO();
        dto.getIdentityDTO().setDateOfBirth("2010-01-01");
        assertThrows(UserException.class, () -> InvestorMapper.fromAccountResponseDTO(dto, new Investor(), "pass"));
    }

    private AccountResponseDTO buildDummyAccountResponseDTO() {
        ContactDTO contact = new ContactDTO("test@email.com", "1234567890", List.of("Street 1"), "City", "State", "12345");
        IdentityDTO identity = new IdentityDTO("John", "Doe", "2000-01-01", "CO", "CO", "individual", "123456789", "national_id", "CO", List.of("salary"));
        DisclosureDTO disclosure = new DisclosureDTO(false, false, false, false, false, false);
        return new AccountResponseDTO(
                "abc", "acc123", "ACTIVE", "INACTIVE", "USD", "100.00", "2024-01-01T10:00:00Z",
                contact, identity, disclosure, List.of(), "trading", "margin", null, List.of("us_equity"));
    }
}
