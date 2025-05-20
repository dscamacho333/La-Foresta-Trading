package co.edu.unbosque.LaForestaTrading.mapper;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.ContactDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.DisclosureDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.IdentityDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.exception.UserException;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InvestorMapperTest {

    private AccountResponseDTO buildValidDTO(String taxId, String birthDate) {
        ContactDTO contact = new ContactDTO();
        contact.setEmailAddress("test@example.com");
        contact.setCity("New York");
        contact.setState("NY");
        contact.setPostalCode("10001");
        contact.setStreetAddress(List.of("123 Wall St"));

        IdentityDTO identity = new IdentityDTO();
        identity.setGivenName("John");
        identity.setFamilyName("Doe");
        identity.setCountryOfBirth("USA");
        identity.setCountryOfCitizenship("USA");
        identity.setCountryOfTaxResidence("USA");
        identity.setPartyType("individual");
        identity.setTaxIdType("SSN");
        identity.setDateOfBirth(birthDate);

        DisclosureDTO disclosure = new DisclosureDTO();
        disclosure.setAffiliatedExchangeOrFinra(false);
        disclosure.setAffiliatedExchangeOrIiroc(false);
        disclosure.setControlPerson(false);
        disclosure.setDiscretionary(false);
        disclosure.setPoliticallyExposed(false);
        disclosure.setImmediateFamilyExposed(false);

        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setContactDTO(contact);
        dto.setIdentityDTO(identity);
        dto.setDisclosureDTO(disclosure);
        dto.setAccountNumber("ACC-1234");
        dto.setAccountType("individual");
        dto.setCryptoStatus("ENABLED");
        dto.setCurrency("USD");
        dto.setId("alpaca-id-1");
        dto.setLastEquity("10000.00");
        dto.setStatus("SUBMITTED");
        dto.setCreatedAt(LocalDateTime.now().toString());
        dto.setTradingType("cash");

        return dto;
    }

    @Test
    public void testValidMapping() {
        AccountResponseDTO dto = buildValidDTO("123456789", "1990-01-01");
        Investor base = new Investor();

        Investor result = InvestorMapper.fromAccountResponseDTO(dto, base, "hashedPassword", "123456789");

        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        assertEquals("Doe", result.getLastName());
        assertEquals("123456789", result.getTaxId());
        assertEquals("ACC-1234", result.getAccountNumber());
        assertEquals(new BigDecimal("10000.00"), result.getLastEquity());
    }

    @Test
    public void testInvalidTaxIdThrowsException() {
        AccountResponseDTO dto = buildValidDTO("ABC123", "1990-01-01");
        Investor base = new Investor();

        UserException exception = assertThrows(UserException.class, () ->
                InvestorMapper.fromAccountResponseDTO(dto, base, "pass", "ABC123")
        );

        assertEquals("El número de identificación solo puede contener números", exception.getMessage());
    }

    @Test
    public void testUnderageThrowsException() {
        String recentBirth = LocalDate.now().minusYears(17).toString();
        AccountResponseDTO dto = buildValidDTO("123456789", recentBirth);
        Investor base = new Investor();

        UserException exception = assertThrows(UserException.class, () ->
                InvestorMapper.fromAccountResponseDTO(dto, base, "pass", "123456789")
        );

        assertEquals("Recuerde que debe ser mayor de edad", exception.getMessage());
    }

    @Test
    public void testInvalidLastEquityHandledGracefully() {
        AccountResponseDTO dto = buildValidDTO("123456789", "1990-01-01");
        dto.setLastEquity("INVALID");
        Investor base = new Investor();

        Investor result = InvestorMapper.fromAccountResponseDTO(dto, base, "pass", "123456789");
        assertNull(result.getLastEquity());
    }

    @Test
    public void testInvalidCreatedAtHandledGracefully() {
        AccountResponseDTO dto = buildValidDTO("123456789", "1990-01-01");
        dto.setCreatedAt("invalid-date");
        Investor base = new Investor();

        Investor result = InvestorMapper.fromAccountResponseDTO(dto, base, "pass", "123456789");
        assertNull(result.getCreatedAt());
    }
}
