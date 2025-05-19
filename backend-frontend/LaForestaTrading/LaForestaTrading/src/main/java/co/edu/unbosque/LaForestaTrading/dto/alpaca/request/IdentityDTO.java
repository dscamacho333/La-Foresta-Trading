package co.edu.unbosque.LaForestaTrading.dto.alpaca.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IdentityDTO {

    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("family_name")
    private String familyName;
    @JsonProperty("date_of_birth")
    private String dateOfBirth;
    @JsonProperty("country_of_citizenship")
    private String countryOfCitizenship = "COL";
    @JsonProperty("country_of_birth")
    private String countryOfBirth = "COL";
    @JsonProperty("party_type")
    private String partyType = "individual";
    @JsonProperty("tax_id")
    private String taxId = "";
    @JsonProperty("tax_id_type")
    private String taxIdType = "COL_NIT";
    @JsonProperty("country_of_tax_residence")
    private String countryOfTaxResidence = "COL";
    @JsonProperty("funding_source")
    private List<String> fundingSource = List.of("employment_income", "savings");

    public IdentityDTO() {
    }

    public IdentityDTO(String givenName, String familyName, String dateOfBirth, String countryOfCitizenship, String countryOfBirth, String partyType, String taxId, String taxIdType, String countryOfTaxResidence, List<String> fundingSource) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.dateOfBirth = dateOfBirth;
        this.countryOfCitizenship = countryOfCitizenship;
        this.countryOfBirth = countryOfBirth;
        this.partyType = partyType;
        this.taxId = taxId;
        this.taxIdType = taxIdType;
        this.countryOfTaxResidence = countryOfTaxResidence;
        this.fundingSource = fundingSource;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfCitizenship() {
        return countryOfCitizenship;
    }

    public void setCountryOfCitizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getPartyType() {
        return partyType;
    }

    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getTaxIdType() {
        return taxIdType;
    }

    public void setTaxIdType(String taxIdType) {
        this.taxIdType = taxIdType;
    }

    public String getCountryOfTaxResidence() {
        return countryOfTaxResidence;
    }

    public void setCountryOfTaxResidence(String countryOfTaxResidence) {
        this.countryOfTaxResidence = countryOfTaxResidence;
    }

    public List<String> getFundingSource() {
        return fundingSource;
    }

    public void setFundingSource(List<String> fundingSource) {
        this.fundingSource = fundingSource;
    }

    @Override
    public String toString() {
        return "IdentityDTO{" +
                "givenName='" + givenName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", countryOfCitizenship='" + countryOfCitizenship + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", partyType='" + partyType + '\'' +
                ", taxId='" + taxId + '\'' +
                ", taxIdType='" + taxIdType + '\'' +
                ", countryOfTaxResidence='" + countryOfTaxResidence + '\'' +
                ", fundingSource=" + fundingSource +
                '}';
    }

}
