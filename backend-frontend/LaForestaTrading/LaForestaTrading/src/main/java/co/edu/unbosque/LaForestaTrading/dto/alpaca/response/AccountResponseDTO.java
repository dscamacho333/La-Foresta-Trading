package co.edu.unbosque.LaForestaTrading.dto.alpaca.response;

import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.AgreementDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.ContactDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.DisclosureDTO;
import co.edu.unbosque.LaForestaTrading.dto.alpaca.request.IdentityDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AccountResponseDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("status")
    private String status;

    @JsonProperty("crypto_status")
    private String cryptoStatus;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("last_equity")
    private String lastEquity;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("contact")
    private ContactDTO contactDTO;

    @JsonProperty("identity")
    private IdentityDTO identityDTO;

    @JsonProperty("disclosures")
    private DisclosureDTO disclosureDTO;

    @JsonProperty("agreements")
    private List<AgreementDTO> agreementsDTO;

    @JsonProperty("account_type")
    private String accountType;

    @JsonProperty("trading_type")
    private String tradingType;

    @JsonProperty("trading_configurations")
    private String tradingConfiguration;

    @JsonProperty("enabled_assets")
    private List<String> enabledAssets;

    public AccountResponseDTO() {
    }

    public AccountResponseDTO(String id, String accountNumber, String status, String cryptoStatus, String currency, String lastEquity, String createdAt, ContactDTO contactDTO, IdentityDTO identityDTO, DisclosureDTO disclosureDTO, List<AgreementDTO> agreementsDTO, String accountType, String tradingType, String tradingConfiguration, List<String> enabledAssets) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.status = status;
        this.cryptoStatus = cryptoStatus;
        this.currency = currency;
        this.lastEquity = lastEquity;
        this.createdAt = createdAt;
        this.contactDTO = contactDTO;
        this.identityDTO = identityDTO;
        this.disclosureDTO = disclosureDTO;
        this.agreementsDTO = agreementsDTO;
        this.accountType = accountType;
        this.tradingType = tradingType;
        this.tradingConfiguration = tradingConfiguration;
        this.enabledAssets = enabledAssets;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCryptoStatus() {
        return cryptoStatus;
    }

    public void setCryptoStatus(String cryptoStatus) {
        this.cryptoStatus = cryptoStatus;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLastEquity() {
        return lastEquity;
    }

    public void setLastEquity(String lastEquity) {
        this.lastEquity = lastEquity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getTradingType() {
        return tradingType;
    }

    public void setTradingType(String tradingType) {
        this.tradingType = tradingType;
    }

    public String getTradingConfiguration() {
        return tradingConfiguration;
    }

    public void setTradingConfiguration(String tradingConfiguration) {
        this.tradingConfiguration = tradingConfiguration;
    }

    public List<String> getEnabledAssets() {
        return enabledAssets;
    }

    public void setEnabledAssets(List<String> enabledAssets) {
        this.enabledAssets = enabledAssets;
    }

    @Override
    public String toString() {
        return "AccountResponseDTO{" +
                "id='" + id + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", status='" + status + '\'' +
                ", cryptoStatus='" + cryptoStatus + '\'' +
                ", currency='" + currency + '\'' +
                ", lastEquity='" + lastEquity + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", contactDTO=" + contactDTO +
                ", identityDTO=" + identityDTO +
                ", disclosureDTO=" + disclosureDTO +
                ", agreementsDTO=" + agreementsDTO +
                ", accountType='" + accountType + '\'' +
                ", tradingType='" + tradingType + '\'' +
                ", tradingConfiguration='" + tradingConfiguration + '\'' +
                ", enabledAssets=" + enabledAssets +
                '}';
    }


}
