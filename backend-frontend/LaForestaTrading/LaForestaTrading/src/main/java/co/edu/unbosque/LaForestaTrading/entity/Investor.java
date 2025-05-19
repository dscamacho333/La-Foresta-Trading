package co.edu.unbosque.LaForestaTrading.entity;

import co.edu.unbosque.LaForestaTrading.entity.enums.UserStatus;
import co.edu.unbosque.LaForestaTrading.entity.enums.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "investor")
@DiscriminatorValue("INVESTOR")
public class Investor extends User{

    @Column(name = "alpaca_id", nullable = false, unique = true, length = 36)
    private String alpacaId;

    @Column(name = "account_number", nullable = false, unique = true, length = 20)
    private String accountNumber;

    @Column(name = "alpaca_status", nullable = false, length = 30)
    private String alpacaStatus;

    @Column(name = "crypto_status", nullable = false, length = 30)
    private String cryptoStatus;

    @Column(name = "currency", nullable = false, length = 10)
    private String currency;

    @Column(name = "last_equity", nullable = false, precision = 18, scale = 2)
    private BigDecimal lastEquity;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Contact
    @Column(name = "street_address", nullable = false, columnDefinition = "TEXT")
    private String streetAddress;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String state;

    @Column(name = "postal_code", nullable = false, length = 20)
    private String postalCode;

    // Identity

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "country_of_citizenship", nullable = false, length = 3)
    private String countryOfCitizenship;

    @Column(name = "country_of_birth", nullable = false, length = 3)
    private String countryOfBirth;

    @Column(name = "party_type", nullable = false, length = 50)
    private String partyType;

    @Column(name = "tax_id", nullable = false, length = 50)
    private String taxId;

    @Column(name = "tax_id_type", nullable = false, length = 30)
    private String taxIdType;

    @Column(name = "country_of_tax_residence", nullable = false, length = 3)
    private String countryOfTaxResidence;

    // Disclosure
    @Column(name = "is_control_person", nullable = false)
    private Boolean isControlPerson;

    @Column(name = "is_affiliated_exchange_or_finra", nullable = false)
    private Boolean isAffiliatedExchangeOrFinra;

    @Column(name = "is_affiliated_exchange_or_iiroc", nullable = false)
    private Boolean isAffiliatedExchangeOrIiroc;

    @Column(name = "is_politically_exposed", nullable = false)
    private Boolean isPoliticallyExposed;

    @Column(name = "immediate_family_exposed", nullable = false)
    private Boolean immediateFamilyExposed;

    @Column(name = "is_discretionary", nullable = false)
    private Boolean isDiscretionary;

    // Account Info
    @Column(name = "account_type", nullable = false, length = 20)
    private String accountType;

    @Column(name = "trading_type", nullable = false, length = 20)
    private String tradingType;

    // Nuevos campos extra
    @Column(name = "buying_power", precision = 18, scale = 2)
    private BigDecimal buyingPower;

    @Column(name = "stocks_of_interest", length = 255)
    private String stocksOfInterest;

    @Column(name = "is_premium")
    private Boolean isPremium;

    public Investor() {

    }

    public Investor(String firstName, String lastName, String email, String passwordHash, UserStatus status, UserType userType, LocalDateTime registrationDate, String alpacaId, String accountNumber, String alpacaStatus, String cryptoStatus, String currency, BigDecimal lastEquity, LocalDateTime createdAt, String streetAddress, String city, String state, String postalCode, LocalDate dateOfBirth, String countryOfCitizenship, String countryOfBirth, String partyType, String taxIdType, String countryOfTaxResidence, Boolean isControlPerson, Boolean isAffiliatedExchangeOrFinra, Boolean isAffiliatedExchangeOrIiroc, Boolean isPoliticallyExposed, Boolean immediateFamilyExposed, Boolean isDiscretionary, String accountType, String tradingType, BigDecimal buyingPower, String stocksOfInterest, Boolean isPremium) {
        super(firstName, lastName, email, passwordHash, status, userType, registrationDate);
        this.alpacaId = alpacaId;
        this.accountNumber = accountNumber;
        this.alpacaStatus = alpacaStatus;
        this.cryptoStatus = cryptoStatus;
        this.currency = currency;
        this.lastEquity = lastEquity;
        this.createdAt = createdAt;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.countryOfCitizenship = countryOfCitizenship;
        this.countryOfBirth = countryOfBirth;
        this.partyType = partyType;
        this.taxIdType = taxIdType;
        this.countryOfTaxResidence = countryOfTaxResidence;
        this.isControlPerson = isControlPerson;
        this.isAffiliatedExchangeOrFinra = isAffiliatedExchangeOrFinra;
        this.isAffiliatedExchangeOrIiroc = isAffiliatedExchangeOrIiroc;
        this.isPoliticallyExposed = isPoliticallyExposed;
        this.immediateFamilyExposed = immediateFamilyExposed;
        this.isDiscretionary = isDiscretionary;
        this.accountType = accountType;
        this.tradingType = tradingType;
        this.buyingPower = buyingPower;
        this.stocksOfInterest = stocksOfInterest;
        this.isPremium = isPremium;
    }

    public Investor(Long id, String firstName, String lastName, String email, String passwordHash, UserStatus status, UserType userType, LocalDateTime registrationDate, String alpacaId, String accountNumber, String alpacaStatus, String cryptoStatus, String currency, BigDecimal lastEquity, LocalDateTime createdAt, String streetAddress, String city, String state, String postalCode, LocalDate dateOfBirth, String countryOfCitizenship, String countryOfBirth, String partyType, String taxIdType, String countryOfTaxResidence, Boolean isControlPerson, Boolean isAffiliatedExchangeOrFinra, Boolean isAffiliatedExchangeOrIiroc, Boolean isPoliticallyExposed, Boolean immediateFamilyExposed, Boolean isDiscretionary, String accountType, String tradingType, BigDecimal buyingPower, String stocksOfInterest, Boolean isPremium) {
        super(id, firstName, lastName, email, passwordHash, status, userType, registrationDate);
        this.alpacaId = alpacaId;
        this.accountNumber = accountNumber;
        this.alpacaStatus = alpacaStatus;
        this.cryptoStatus = cryptoStatus;
        this.currency = currency;
        this.lastEquity = lastEquity;
        this.createdAt = createdAt;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.dateOfBirth = dateOfBirth;
        this.countryOfCitizenship = countryOfCitizenship;
        this.countryOfBirth = countryOfBirth;
        this.partyType = partyType;
        this.taxIdType = taxIdType;
        this.countryOfTaxResidence = countryOfTaxResidence;
        this.isControlPerson = isControlPerson;
        this.isAffiliatedExchangeOrFinra = isAffiliatedExchangeOrFinra;
        this.isAffiliatedExchangeOrIiroc = isAffiliatedExchangeOrIiroc;
        this.isPoliticallyExposed = isPoliticallyExposed;
        this.immediateFamilyExposed = immediateFamilyExposed;
        this.isDiscretionary = isDiscretionary;
        this.accountType = accountType;
        this.tradingType = tradingType;
        this.buyingPower = buyingPower;
        this.stocksOfInterest = stocksOfInterest;
        this.isPremium = isPremium;
    }

    public String getAlpacaId() {
        return alpacaId;
    }

    public void setAlpacaId(String alpacaId) {
        this.alpacaId = alpacaId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAlpacaStatus() {
        return alpacaStatus;
    }

    public void setAlpacaStatus(String alpacaStatus) {
        this.alpacaStatus = alpacaStatus;
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

    public BigDecimal getLastEquity() {
        return lastEquity;
    }

    public void setLastEquity(BigDecimal lastEquity) {
        this.lastEquity = lastEquity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    public Boolean getControlPerson() {
        return isControlPerson;
    }

    public void setControlPerson(Boolean controlPerson) {
        isControlPerson = controlPerson;
    }

    public Boolean getAffiliatedExchangeOrFinra() {
        return isAffiliatedExchangeOrFinra;
    }

    public void setAffiliatedExchangeOrFinra(Boolean affiliatedExchangeOrFinra) {
        isAffiliatedExchangeOrFinra = affiliatedExchangeOrFinra;
    }

    public Boolean getAffiliatedExchangeOrIiroc() {
        return isAffiliatedExchangeOrIiroc;
    }

    public void setAffiliatedExchangeOrIiroc(Boolean affiliatedExchangeOrIiroc) {
        isAffiliatedExchangeOrIiroc = affiliatedExchangeOrIiroc;
    }

    public Boolean getPoliticallyExposed() {
        return isPoliticallyExposed;
    }

    public void setPoliticallyExposed(Boolean politicallyExposed) {
        isPoliticallyExposed = politicallyExposed;
    }

    public Boolean getImmediateFamilyExposed() {
        return immediateFamilyExposed;
    }

    public void setImmediateFamilyExposed(Boolean immediateFamilyExposed) {
        this.immediateFamilyExposed = immediateFamilyExposed;
    }

    public Boolean getDiscretionary() {
        return isDiscretionary;
    }

    public void setDiscretionary(Boolean discretionary) {
        isDiscretionary = discretionary;
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

    public BigDecimal getBuyingPower() {
        return buyingPower;
    }

    public void setBuyingPower(BigDecimal buyingPower) {
        this.buyingPower = buyingPower;
    }

    public String getStocksOfInterest() {
        return stocksOfInterest;
    }

    public void setStocksOfInterest(String stocksOfInterest) {
        this.stocksOfInterest = stocksOfInterest;
    }

    public Boolean getPremium() {
        return isPremium;
    }

    public void setPremium(Boolean premium) {
        isPremium = premium;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Override
    public String toString() {
        return "Investor{" +
                "alpacaId='" + alpacaId + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", alpacaStatus='" + alpacaStatus + '\'' +
                ", cryptoStatus='" + cryptoStatus + '\'' +
                ", currency='" + currency + '\'' +
                ", lastEquity=" + lastEquity +
                ", createdAt=" + createdAt +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", countryOfCitizenship='" + countryOfCitizenship + '\'' +
                ", countryOfBirth='" + countryOfBirth + '\'' +
                ", partyType='" + partyType + '\'' +
                ", taxIdType='" + taxIdType + '\'' +
                ", countryOfTaxResidence='" + countryOfTaxResidence + '\'' +
                ", isControlPerson=" + isControlPerson +
                ", isAffiliatedExchangeOrFinra=" + isAffiliatedExchangeOrFinra +
                ", isAffiliatedExchangeOrIiroc=" + isAffiliatedExchangeOrIiroc +
                ", isPoliticallyExposed=" + isPoliticallyExposed +
                ", immediateFamilyExposed=" + immediateFamilyExposed +
                ", isDiscretionary=" + isDiscretionary +
                ", accountType='" + accountType + '\'' +
                ", tradingType='" + tradingType + '\'' +
                ", buyingPower=" + buyingPower +
                ", stocksOfInterest='" + stocksOfInterest + '\'' +
                ", isPremium=" + isPremium +
                '}';
    }


}
