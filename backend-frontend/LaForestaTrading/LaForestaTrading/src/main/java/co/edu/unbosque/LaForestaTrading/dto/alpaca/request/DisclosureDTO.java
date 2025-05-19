package co.edu.unbosque.LaForestaTrading.dto.alpaca.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DisclosureDTO {

    @JsonProperty("is_control_person")
    private boolean isControlPerson;

    @JsonProperty("is_affiliated_exchange_or_finra")
    private boolean isAffiliatedExchangeOrFinra;

    @JsonProperty("is_affiliated_exchange_or_iiroc")
    private boolean isAffiliatedExchangeOrIiroc;

    @JsonProperty("is_politically_exposed")
    private boolean isPoliticallyExposed;

    @JsonProperty("immediate_family_exposed")
    private boolean immediateFamilyExposed;

    @JsonProperty("is_discretionary")
    private boolean isDiscretionary;

    public DisclosureDTO() {
    }

    public DisclosureDTO(boolean isControlPerson, boolean isAffiliatedExchangeOrFinra, boolean isAffiliatedExchangeOrIiroc, boolean isPoliticallyExposed, boolean immediateFamilyExposed, boolean isDiscretionary) {
        this.isControlPerson = isControlPerson;
        this.isAffiliatedExchangeOrFinra = isAffiliatedExchangeOrFinra;
        this.isAffiliatedExchangeOrIiroc = isAffiliatedExchangeOrIiroc;
        this.isPoliticallyExposed = isPoliticallyExposed;
        this.immediateFamilyExposed = immediateFamilyExposed;
        this.isDiscretionary = isDiscretionary;
    }

    public boolean isControlPerson() {
        return isControlPerson;
    }

    public void setControlPerson(boolean controlPerson) {
        isControlPerson = controlPerson;
    }

    public boolean isAffiliatedExchangeOrFinra() {
        return isAffiliatedExchangeOrFinra;
    }

    public void setAffiliatedExchangeOrFinra(boolean affiliatedExchangeOrFinra) {
        isAffiliatedExchangeOrFinra = affiliatedExchangeOrFinra;
    }

    public boolean isAffiliatedExchangeOrIiroc() {
        return isAffiliatedExchangeOrIiroc;
    }

    public void setAffiliatedExchangeOrIiroc(boolean affiliatedExchangeOrIiroc) {
        isAffiliatedExchangeOrIiroc = affiliatedExchangeOrIiroc;
    }

    public boolean isPoliticallyExposed() {
        return isPoliticallyExposed;
    }

    public void setPoliticallyExposed(boolean politicallyExposed) {
        isPoliticallyExposed = politicallyExposed;
    }

    public boolean isImmediateFamilyExposed() {
        return immediateFamilyExposed;
    }

    public void setImmediateFamilyExposed(boolean immediateFamilyExposed) {
        this.immediateFamilyExposed = immediateFamilyExposed;
    }

    public boolean isDiscretionary() {
        return isDiscretionary;
    }

    public void setDiscretionary(boolean discretionary) {
        isDiscretionary = discretionary;
    }

    @Override
    public String toString() {
        return "DisclosureDTO{" +
                "isControlPerson=" + isControlPerson +
                ", isAffiliatedExchangeOrFinra=" + isAffiliatedExchangeOrFinra +
                ", isAffiliatedExchangeOrIiroc=" + isAffiliatedExchangeOrIiroc +
                ", isPoliticallyExposed=" + isPoliticallyExposed +
                ", immediateFamilyExposed=" + immediateFamilyExposed +
                ", isDiscretionary=" + isDiscretionary +
                '}';
    }

}
