package co.edu.unbosque.LaForestaTrading.dto.alpaca.response;

public class AdminConfigurationsDTO {

    private Boolean allowInstantAch;
    private Boolean disableShorting;
    private String maxMarginMultiplier;

    public AdminConfigurationsDTO() {
    }

    public AdminConfigurationsDTO(Boolean allowInstantAch, Boolean disableShorting, String maxMarginMultiplier) {
        this.allowInstantAch = allowInstantAch;
        this.disableShorting = disableShorting;
        this.maxMarginMultiplier = maxMarginMultiplier;
    }

    public Boolean getAllowInstantAch() {
        return allowInstantAch;
    }

    public void setAllowInstantAch(Boolean allowInstantAch) {
        this.allowInstantAch = allowInstantAch;
    }

    public Boolean getDisableShorting() {
        return disableShorting;
    }

    public void setDisableShorting(Boolean disableShorting) {
        this.disableShorting = disableShorting;
    }

    public String getMaxMarginMultiplier() {
        return maxMarginMultiplier;
    }

    public void setMaxMarginMultiplier(String maxMarginMultiplier) {
        this.maxMarginMultiplier = maxMarginMultiplier;
    }
}
