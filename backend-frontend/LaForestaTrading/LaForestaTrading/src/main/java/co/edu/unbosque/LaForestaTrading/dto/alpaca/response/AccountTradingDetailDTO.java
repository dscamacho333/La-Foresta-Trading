package co.edu.unbosque.LaForestaTrading.dto.alpaca.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountTradingDetailDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("admin_configurations")
    private AdminConfigurationsDTO adminConfigurationsDTO;

    @JsonProperty("user_configurations")
    private Object userConfigurations;

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("status")
    private String status;

    @JsonProperty("crypto_status")
    private String cryptoStatus;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("buying_power")
    private String buyingPower;

    @JsonProperty("regt_buying_power")
    private String regtBuyingPower;

    @JsonProperty("daytrading_buying_power")
    private String daytradingBuyingPower;

    @JsonProperty("effective_buying_power")
    private String effectiveBuyingPower;

    @JsonProperty("non_marginable_buying_power")
    private String nonMarginableBuyingPower;

    @JsonProperty("bod_dtbp")
    private String bodDtbp;

    @JsonProperty("cash")
    private String cash;

    @JsonProperty("cash_withdrawable")
    private String cashWithdrawable;

    @JsonProperty("cash_transferable")
    private String cashTransferable;

    @JsonProperty("accrued_fees")
    private String accruedFees;

    @JsonProperty("pending_transfer_out")
    private String pendingTransferOut;

    @JsonProperty("portfolio_value")
    private String portfolioValue;

    @JsonProperty("pattern_day_trader")
    private Boolean patternDayTrader;

    @JsonProperty("trading_blocked")
    private Boolean tradingBlocked;

    @JsonProperty("transfers_blocked")
    private Boolean transfersBlocked;

    @JsonProperty("account_blocked")
    private Boolean accountBlocked;

    @JsonProperty("trade_suspended_by_user")
    private Boolean tradeSuspendedByUser;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("multiplier")
    private String multiplier;

    @JsonProperty("shorting_enabled")
    private Boolean shortingEnabled;

    @JsonProperty("equity")
    private String equity;

    @JsonProperty("last_equity")
    private String lastEquity;

    @JsonProperty("long_market_value")
    private String longMarketValue;

    @JsonProperty("short_market_value")
    private String shortMarketValue;

    @JsonProperty("position_market_value")
    private String positionMarketValue;

    @JsonProperty("initial_margin")
    private String initialMargin;

    @JsonProperty("maintenance_margin")
    private String maintenanceMargin;

    @JsonProperty("last_maintenance_margin")
    private String lastMaintenanceMargin;

    @JsonProperty("sma")
    private String sma;

    @JsonProperty("daytrade_count")
    private Integer daytradeCount;

    @JsonProperty("balance_asof")
    private String balanceAsof;

    @JsonProperty("previous_close")
    private String previousClose;

    @JsonProperty("last_long_market_value")
    private String lastLongMarketValue;

    @JsonProperty("last_short_market_value")
    private String lastShortMarketValue;

    @JsonProperty("last_cash")
    private String lastCash;

    @JsonProperty("last_initial_margin")
    private String lastInitialMargin;

    @JsonProperty("last_regt_buying_power")
    private String lastRegtBuyingPower;

    @JsonProperty("last_daytrading_buying_power")
    private String lastDaytradingBuyingPower;

    @JsonProperty("last_buying_power")
    private String lastBuyingPower;

    @JsonProperty("last_daytrade_count")
    private Integer lastDaytradeCount;

    @JsonProperty("clearing_broker")
    private String clearingBroker;

    @JsonProperty("intraday_adjustments")
    private String intradayAdjustments;

    @JsonProperty("pending_reg_taf_fees")
    private String pendingRegTafFees;


    public AccountTradingDetailDTO() {
    }

    public AccountTradingDetailDTO(String id, AdminConfigurationsDTO adminConfigurationsDTO, Object userConfigurations, String accountNumber, String status, String cryptoStatus, String currency, String buyingPower, String regtBuyingPower, String daytradingBuyingPower, String effectiveBuyingPower, String nonMarginableBuyingPower, String bodDtbp, String cash, String cashWithdrawable, String cashTransferable, String accruedFees, String pendingTransferOut, String portfolioValue, Boolean patternDayTrader, Boolean tradingBlocked, Boolean transfersBlocked, Boolean accountBlocked, Boolean tradeSuspendedByUser, String createdAt, String multiplier, Boolean shortingEnabled, String equity, String lastEquity, String longMarketValue, String shortMarketValue, String positionMarketValue, String initialMargin, String maintenanceMargin, String lastMaintenanceMargin, String sma, Integer daytradeCount, String balanceAsof, String previousClose, String lastLongMarketValue, String lastShortMarketValue, String lastCash, String lastInitialMargin, String lastRegtBuyingPower, String lastDaytradingBuyingPower, String lastBuyingPower, Integer lastDaytradeCount, String clearingBroker, String intradayAdjustments, String pendingRegTafFees) {
        this.id = id;
        this.adminConfigurationsDTO = adminConfigurationsDTO;
        this.userConfigurations = userConfigurations;
        this.accountNumber = accountNumber;
        this.status = status;
        this.cryptoStatus = cryptoStatus;
        this.currency = currency;
        this.buyingPower = buyingPower;
        this.regtBuyingPower = regtBuyingPower;
        this.daytradingBuyingPower = daytradingBuyingPower;
        this.effectiveBuyingPower = effectiveBuyingPower;
        this.nonMarginableBuyingPower = nonMarginableBuyingPower;
        this.bodDtbp = bodDtbp;
        this.cash = cash;
        this.cashWithdrawable = cashWithdrawable;
        this.cashTransferable = cashTransferable;
        this.accruedFees = accruedFees;
        this.pendingTransferOut = pendingTransferOut;
        this.portfolioValue = portfolioValue;
        this.patternDayTrader = patternDayTrader;
        this.tradingBlocked = tradingBlocked;
        this.transfersBlocked = transfersBlocked;
        this.accountBlocked = accountBlocked;
        this.tradeSuspendedByUser = tradeSuspendedByUser;
        this.createdAt = createdAt;
        this.multiplier = multiplier;
        this.shortingEnabled = shortingEnabled;
        this.equity = equity;
        this.lastEquity = lastEquity;
        this.longMarketValue = longMarketValue;
        this.shortMarketValue = shortMarketValue;
        this.positionMarketValue = positionMarketValue;
        this.initialMargin = initialMargin;
        this.maintenanceMargin = maintenanceMargin;
        this.lastMaintenanceMargin = lastMaintenanceMargin;
        this.sma = sma;
        this.daytradeCount = daytradeCount;
        this.balanceAsof = balanceAsof;
        this.previousClose = previousClose;
        this.lastLongMarketValue = lastLongMarketValue;
        this.lastShortMarketValue = lastShortMarketValue;
        this.lastCash = lastCash;
        this.lastInitialMargin = lastInitialMargin;
        this.lastRegtBuyingPower = lastRegtBuyingPower;
        this.lastDaytradingBuyingPower = lastDaytradingBuyingPower;
        this.lastBuyingPower = lastBuyingPower;
        this.lastDaytradeCount = lastDaytradeCount;
        this.clearingBroker = clearingBroker;
        this.intradayAdjustments = intradayAdjustments;
        this.pendingRegTafFees = pendingRegTafFees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AdminConfigurationsDTO getAdminConfigurationsDTO() {
        return adminConfigurationsDTO;
    }

    public void setAdminConfigurationsDTO(AdminConfigurationsDTO adminConfigurationsDTO) {
        this.adminConfigurationsDTO = adminConfigurationsDTO;
    }

    public Object getUserConfigurations() {
        return userConfigurations;
    }

    public void setUserConfigurations(Object userConfigurations) {
        this.userConfigurations = userConfigurations;
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

    public String getBuyingPower() {
        return buyingPower;
    }

    public void setBuyingPower(String buyingPower) {
        this.buyingPower = buyingPower;
    }

    public String getRegtBuyingPower() {
        return regtBuyingPower;
    }

    public void setRegtBuyingPower(String regtBuyingPower) {
        this.regtBuyingPower = regtBuyingPower;
    }

    public String getDaytradingBuyingPower() {
        return daytradingBuyingPower;
    }

    public void setDaytradingBuyingPower(String daytradingBuyingPower) {
        this.daytradingBuyingPower = daytradingBuyingPower;
    }

    public String getEffectiveBuyingPower() {
        return effectiveBuyingPower;
    }

    public void setEffectiveBuyingPower(String effectiveBuyingPower) {
        this.effectiveBuyingPower = effectiveBuyingPower;
    }

    public String getNonMarginableBuyingPower() {
        return nonMarginableBuyingPower;
    }

    public void setNonMarginableBuyingPower(String nonMarginableBuyingPower) {
        this.nonMarginableBuyingPower = nonMarginableBuyingPower;
    }

    public String getBodDtbp() {
        return bodDtbp;
    }

    public void setBodDtbp(String bodDtbp) {
        this.bodDtbp = bodDtbp;
    }

    public String getCash() {
        return cash;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }

    public String getCashWithdrawable() {
        return cashWithdrawable;
    }

    public void setCashWithdrawable(String cashWithdrawable) {
        this.cashWithdrawable = cashWithdrawable;
    }

    public String getCashTransferable() {
        return cashTransferable;
    }

    public void setCashTransferable(String cashTransferable) {
        this.cashTransferable = cashTransferable;
    }

    public String getAccruedFees() {
        return accruedFees;
    }

    public void setAccruedFees(String accruedFees) {
        this.accruedFees = accruedFees;
    }

    public String getPendingTransferOut() {
        return pendingTransferOut;
    }

    public void setPendingTransferOut(String pendingTransferOut) {
        this.pendingTransferOut = pendingTransferOut;
    }

    public String getPortfolioValue() {
        return portfolioValue;
    }

    public void setPortfolioValue(String portfolioValue) {
        this.portfolioValue = portfolioValue;
    }

    public Boolean getPatternDayTrader() {
        return patternDayTrader;
    }

    public void setPatternDayTrader(Boolean patternDayTrader) {
        this.patternDayTrader = patternDayTrader;
    }

    public Boolean getTradingBlocked() {
        return tradingBlocked;
    }

    public void setTradingBlocked(Boolean tradingBlocked) {
        this.tradingBlocked = tradingBlocked;
    }

    public Boolean getTransfersBlocked() {
        return transfersBlocked;
    }

    public void setTransfersBlocked(Boolean transfersBlocked) {
        this.transfersBlocked = transfersBlocked;
    }

    public Boolean getAccountBlocked() {
        return accountBlocked;
    }

    public void setAccountBlocked(Boolean accountBlocked) {
        this.accountBlocked = accountBlocked;
    }

    public Boolean getTradeSuspendedByUser() {
        return tradeSuspendedByUser;
    }

    public void setTradeSuspendedByUser(Boolean tradeSuspendedByUser) {
        this.tradeSuspendedByUser = tradeSuspendedByUser;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
        this.multiplier = multiplier;
    }

    public Boolean getShortingEnabled() {
        return shortingEnabled;
    }

    public void setShortingEnabled(Boolean shortingEnabled) {
        this.shortingEnabled = shortingEnabled;
    }

    public String getEquity() {
        return equity;
    }

    public void setEquity(String equity) {
        this.equity = equity;
    }

    public String getLastEquity() {
        return lastEquity;
    }

    public void setLastEquity(String lastEquity) {
        this.lastEquity = lastEquity;
    }

    public String getLongMarketValue() {
        return longMarketValue;
    }

    public void setLongMarketValue(String longMarketValue) {
        this.longMarketValue = longMarketValue;
    }

    public String getShortMarketValue() {
        return shortMarketValue;
    }

    public void setShortMarketValue(String shortMarketValue) {
        this.shortMarketValue = shortMarketValue;
    }

    public String getPositionMarketValue() {
        return positionMarketValue;
    }

    public void setPositionMarketValue(String positionMarketValue) {
        this.positionMarketValue = positionMarketValue;
    }

    public String getInitialMargin() {
        return initialMargin;
    }

    public void setInitialMargin(String initialMargin) {
        this.initialMargin = initialMargin;
    }

    public String getMaintenanceMargin() {
        return maintenanceMargin;
    }

    public void setMaintenanceMargin(String maintenanceMargin) {
        this.maintenanceMargin = maintenanceMargin;
    }

    public String getLastMaintenanceMargin() {
        return lastMaintenanceMargin;
    }

    public void setLastMaintenanceMargin(String lastMaintenanceMargin) {
        this.lastMaintenanceMargin = lastMaintenanceMargin;
    }

    public String getSma() {
        return sma;
    }

    public void setSma(String sma) {
        this.sma = sma;
    }

    public Integer getDaytradeCount() {
        return daytradeCount;
    }

    public void setDaytradeCount(Integer daytradeCount) {
        this.daytradeCount = daytradeCount;
    }

    public String getBalanceAsof() {
        return balanceAsof;
    }

    public void setBalanceAsof(String balanceAsof) {
        this.balanceAsof = balanceAsof;
    }

    public String getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(String previousClose) {
        this.previousClose = previousClose;
    }

    public String getLastLongMarketValue() {
        return lastLongMarketValue;
    }

    public void setLastLongMarketValue(String lastLongMarketValue) {
        this.lastLongMarketValue = lastLongMarketValue;
    }

    public String getLastShortMarketValue() {
        return lastShortMarketValue;
    }

    public void setLastShortMarketValue(String lastShortMarketValue) {
        this.lastShortMarketValue = lastShortMarketValue;
    }

    public String getLastCash() {
        return lastCash;
    }

    public void setLastCash(String lastCash) {
        this.lastCash = lastCash;
    }

    public String getLastInitialMargin() {
        return lastInitialMargin;
    }

    public void setLastInitialMargin(String lastInitialMargin) {
        this.lastInitialMargin = lastInitialMargin;
    }

    public String getLastRegtBuyingPower() {
        return lastRegtBuyingPower;
    }

    public void setLastRegtBuyingPower(String lastRegtBuyingPower) {
        this.lastRegtBuyingPower = lastRegtBuyingPower;
    }

    public String getLastDaytradingBuyingPower() {
        return lastDaytradingBuyingPower;
    }

    public void setLastDaytradingBuyingPower(String lastDaytradingBuyingPower) {
        this.lastDaytradingBuyingPower = lastDaytradingBuyingPower;
    }

    public String getLastBuyingPower() {
        return lastBuyingPower;
    }

    public void setLastBuyingPower(String lastBuyingPower) {
        this.lastBuyingPower = lastBuyingPower;
    }

    public Integer getLastDaytradeCount() {
        return lastDaytradeCount;
    }

    public void setLastDaytradeCount(Integer lastDaytradeCount) {
        this.lastDaytradeCount = lastDaytradeCount;
    }

    public String getClearingBroker() {
        return clearingBroker;
    }

    public void setClearingBroker(String clearingBroker) {
        this.clearingBroker = clearingBroker;
    }

    public String getIntradayAdjustments() {
        return intradayAdjustments;
    }

    public void setIntradayAdjustments(String intradayAdjustments) {
        this.intradayAdjustments = intradayAdjustments;
    }

    public String getPendingRegTafFees() {
        return pendingRegTafFees;
    }

    public void setPendingRegTafFees(String pendingRegTafFees) {
        this.pendingRegTafFees = pendingRegTafFees;
    }

    @Override
    public String toString() {
        return "AccountTradingDetailDTO{" +
                "id='" + id + '\'' +
                ", adminConfigurationsDTO=" + adminConfigurationsDTO +
                ", userConfigurations=" + userConfigurations +
                ", accountNumber='" + accountNumber + '\'' +
                ", status='" + status + '\'' +
                ", cryptoStatus='" + cryptoStatus + '\'' +
                ", currency='" + currency + '\'' +
                ", buyingPower='" + buyingPower + '\'' +
                ", regtBuyingPower='" + regtBuyingPower + '\'' +
                ", daytradingBuyingPower='" + daytradingBuyingPower + '\'' +
                ", effectiveBuyingPower='" + effectiveBuyingPower + '\'' +
                ", nonMarginableBuyingPower='" + nonMarginableBuyingPower + '\'' +
                ", bodDtbp='" + bodDtbp + '\'' +
                ", cash='" + cash + '\'' +
                ", cashWithdrawable='" + cashWithdrawable + '\'' +
                ", cashTransferable='" + cashTransferable + '\'' +
                ", accruedFees='" + accruedFees + '\'' +
                ", pendingTransferOut='" + pendingTransferOut + '\'' +
                ", portfolioValue='" + portfolioValue + '\'' +
                ", patternDayTrader=" + patternDayTrader +
                ", tradingBlocked=" + tradingBlocked +
                ", transfersBlocked=" + transfersBlocked +
                ", accountBlocked=" + accountBlocked +
                ", tradeSuspendedByUser=" + tradeSuspendedByUser +
                ", createdAt='" + createdAt + '\'' +
                ", multiplier='" + multiplier + '\'' +
                ", shortingEnabled=" + shortingEnabled +
                ", equity='" + equity + '\'' +
                ", lastEquity='" + lastEquity + '\'' +
                ", longMarketValue='" + longMarketValue + '\'' +
                ", shortMarketValue='" + shortMarketValue + '\'' +
                ", positionMarketValue='" + positionMarketValue + '\'' +
                ", initialMargin='" + initialMargin + '\'' +
                ", maintenanceMargin='" + maintenanceMargin + '\'' +
                ", lastMaintenanceMargin='" + lastMaintenanceMargin + '\'' +
                ", sma='" + sma + '\'' +
                ", daytradeCount=" + daytradeCount +
                ", balanceAsof='" + balanceAsof + '\'' +
                ", previousClose='" + previousClose + '\'' +
                ", lastLongMarketValue='" + lastLongMarketValue + '\'' +
                ", lastShortMarketValue='" + lastShortMarketValue + '\'' +
                ", lastCash='" + lastCash + '\'' +
                ", lastInitialMargin='" + lastInitialMargin + '\'' +
                ", lastRegtBuyingPower='" + lastRegtBuyingPower + '\'' +
                ", lastDaytradingBuyingPower='" + lastDaytradingBuyingPower + '\'' +
                ", lastBuyingPower='" + lastBuyingPower + '\'' +
                ", lastDaytradeCount=" + lastDaytradeCount +
                ", clearingBroker='" + clearingBroker + '\'' +
                ", intradayAdjustments='" + intradayAdjustments + '\'' +
                ", pendingRegTafFees='" + pendingRegTafFees + '\'' +
                '}';
    }
}
