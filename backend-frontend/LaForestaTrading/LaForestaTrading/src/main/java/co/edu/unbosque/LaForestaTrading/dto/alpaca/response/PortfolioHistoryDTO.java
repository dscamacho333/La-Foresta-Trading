package co.edu.unbosque.LaForestaTrading.dto.alpaca.response;

import java.util.List;

public class PortfolioHistoryDTO {

    private List<Long> timestamp;
    private List<Double> equity;
    private List<Double> profitLoss;
    private List<Double> profitLossPct;
    private Double baseValue;
    private String baseValueAsof;
    private String timeframe;

    public PortfolioHistoryDTO() {
    }

    public PortfolioHistoryDTO(List<Long> timestamp, List<Double> equity, List<Double> profitLoss, List<Double> profitLossPct, Double baseValue, String baseValueAsof, String timeframe) {
        this.timestamp = timestamp;
        this.equity = equity;
        this.profitLoss = profitLoss;
        this.profitLossPct = profitLossPct;
        this.baseValue = baseValue;
        this.baseValueAsof = baseValueAsof;
        this.timeframe = timeframe;
    }

    public List<Long> getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(List<Long> timestamp) {
        this.timestamp = timestamp;
    }

    public List<Double> getEquity() {
        return equity;
    }

    public void setEquity(List<Double> equity) {
        this.equity = equity;
    }

    public List<Double> getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(List<Double> profitLoss) {
        this.profitLoss = profitLoss;
    }

    public List<Double> getProfitLossPct() {
        return profitLossPct;
    }

    public void setProfitLossPct(List<Double> profitLossPct) {
        this.profitLossPct = profitLossPct;
    }

    public Double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(Double baseValue) {
        this.baseValue = baseValue;
    }

    public String getBaseValueAsof() {
        return baseValueAsof;
    }

    public void setBaseValueAsof(String baseValueAsof) {
        this.baseValueAsof = baseValueAsof;
    }

    public String getTimeframe() {
        return timeframe;
    }

    public void setTimeframe(String timeframe) {
        this.timeframe = timeframe;
    }

    @Override
    public String toString() {
        return "PortfolioHistoryDTO{" +
                "timestamp=" + timestamp +
                ", equity=" + equity +
                ", profitLoss=" + profitLoss +
                ", profitLossPct=" + profitLossPct +
                ", baseValue=" + baseValue +
                ", baseValueAsof='" + baseValueAsof + '\'' +
                ", timeframe='" + timeframe + '\'' +
                '}';
    }
}
