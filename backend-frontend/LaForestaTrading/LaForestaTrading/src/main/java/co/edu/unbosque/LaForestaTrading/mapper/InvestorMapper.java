package co.edu.unbosque.LaForestaTrading.mapper;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AccountDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.ContactDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.DisclosureDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.IdentityDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.response.AccountResponseDTO;
import co.edu.unbosque.LaForestaTrading.entity.Investor;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserStatus;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserType;
import co.edu.unbosque.LaForestaTrading.exception.UserException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class InvestorMapper {

    public static Investor fromAccountResponseDTO(AccountResponseDTO dto, Investor investorBase, String passwordHash, String taxId) {

        ContactDTO contact = dto.getContactDTO();
        IdentityDTO identity = dto.getIdentityDTO();
        DisclosureDTO disclosure = dto.getDisclosureDTO();

        investorBase.setFirstName(identity.getGivenName());
        investorBase.setLastName(identity.getFamilyName());
        investorBase.setEmail(contact.getEmailAddress());
        investorBase.setPasswordHash(passwordHash);
        investorBase.setStatus(UserStatus.ACTIVE);
        investorBase.setUserType(UserType.INVESTOR);
        investorBase.setRegistrationDate(LocalDateTime.now());

        // General info

        investorBase.setAlpacaId(dto.getId());
        investorBase.setAccountNumber(dto.getAccountNumber());
        investorBase.setAlpacaStatus(dto.getStatus());
        investorBase.setCryptoStatus(dto.getCryptoStatus());
        investorBase.setCurrency(dto.getCurrency());
        investorBase.setLastEquity(toBigDecimal(dto.getLastEquity()));
        investorBase.setCreatedAt(toLocalDateTime(dto.getCreatedAt()));

        // Contact
        investorBase.setStreetAddress(joinStreetAddress(contact.getStreetAddress()));
        investorBase.setCity(contact.getCity());
        investorBase.setState(contact.getState());
        investorBase.setPostalCode(contact.getPostalCode());

        // Identity
        investorBase.setDateOfBirth(toLocalDate(identity.getDateOfBirth()));
        investorBase.setCountryOfCitizenship(identity.getCountryOfCitizenship());
        investorBase.setCountryOfBirth(identity.getCountryOfBirth());
        investorBase.setPartyType(identity.getPartyType());
        investorBase.setTaxIdType(identity.getTaxIdType());
        investorBase.setTaxId(taxId);
        investorBase.setCountryOfTaxResidence(identity.getCountryOfTaxResidence());

        // Disclosure
        investorBase.setControlPerson(disclosure.isControlPerson());
        investorBase.setAffiliatedExchangeOrFinra(disclosure.isAffiliatedExchangeOrFinra());
        investorBase.setAffiliatedExchangeOrIiroc(disclosure.isAffiliatedExchangeOrIiroc());
        investorBase.setPoliticallyExposed(disclosure.isPoliticallyExposed());
        investorBase.setImmediateFamilyExposed(disclosure.isImmediateFamilyExposed());
        investorBase.setDiscretionary(disclosure.isDiscretionary());

        // Account Info
        investorBase.setAccountType(dto.getAccountType());
        investorBase.setTradingType(dto.getTradingType());


        investorBase.setBuyingPower(BigDecimal.ZERO);
        investorBase.setStocksOfInterest("");
        investorBase.setPremium(false);

        esSoloNumeros(investorBase.getTaxId());
        esMayorDeEdad(investorBase.getDateOfBirth());

        return investorBase;
    }

    private static boolean esSoloNumeros(String input) {
        if (input != null && input.matches("\\d+")){
            return true;
        }else{
            System.out.println("input = " + input);
            throw new UserException("El número de identificación solo puede contener números");
        }
    }

    private static boolean esMayorDeEdad(LocalDate nacimiento){
        if(Period.between(nacimiento, LocalDate.now()).getYears() >= 18){
            return true;
        }else{
            throw new UserException("Recuerde que debe ser mayor de edad");
        }
    }

    private static BigDecimal toBigDecimal(String value) {
        try {
            return value != null ? new BigDecimal(value) : null;
        } catch (Exception e) {
            return null;
        }
    }

    private static LocalDateTime toLocalDateTime(String value) {
        try {
            return value != null ? LocalDateTime.parse(value.replace("Z", "")) : null;
        } catch (Exception e) {
            return null;
        }
    }

    private static LocalDate toLocalDate(String value) {
        try {
            return value != null ? LocalDate.parse(value) : null;
        } catch (Exception e) {
            return null;
        }
    }

    private static String joinStreetAddress(java.util.List<String> parts) {
        return parts == null ? null : String.join(", ", parts);
    }

    private static String safeJoin(java.util.List<String> list) {
        return list == null ? "" : String.join(",", list);
    }

}
