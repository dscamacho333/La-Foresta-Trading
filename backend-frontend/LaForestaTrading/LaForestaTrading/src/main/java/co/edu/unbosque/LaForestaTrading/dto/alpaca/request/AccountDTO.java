package co.edu.unbosque.LaForestaTrading.dto.alpaca.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AccountDTO {

    @JsonProperty("contact")
    private ContactDTO contactDTO;
    @JsonProperty("identity")
    private IdentityDTO identityDTO;
    @JsonProperty("disclosures")
    private DisclosureDTO disclosureDTO;
    @JsonProperty("agreements")
    private List<AgreementDTO> agreementsDTO;

    public AccountDTO() {
    }

    public AccountDTO(ContactDTO contactDTO, IdentityDTO identityDTO, DisclosureDTO disclosureDTO, List<AgreementDTO> agreementsDTO) {
        this.contactDTO = contactDTO;
        this.identityDTO = identityDTO;
        this.disclosureDTO = disclosureDTO;
        this.agreementsDTO = agreementsDTO;
    }

    public ContactDTO getContactDTO() {
        return contactDTO;
    }

    public void setContactDTO(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }

    public IdentityDTO getIdentityDTO() {
        return identityDTO;
    }

    public void setIdentityDTO(IdentityDTO identityDTO) {
        this.identityDTO = identityDTO;
    }

    public DisclosureDTO getDisclosureDTO() {
        return disclosureDTO;
    }

    public void setDisclosureDTO(DisclosureDTO disclosureDTO) {
        this.disclosureDTO = disclosureDTO;
    }

    public List<AgreementDTO> getAgreementsDTO() {
        return agreementsDTO;
    }

    public void setAgreementsDTO(List<AgreementDTO> agreementsDTO) {
        this.agreementsDTO = agreementsDTO;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "contactDTO=" + contactDTO +
                ", identityDTO=" + identityDTO +
                ", disclosureDTO=" + disclosureDTO +
                ", agreementsDTO=" + agreementsDTO +
                '}';
    }

}
