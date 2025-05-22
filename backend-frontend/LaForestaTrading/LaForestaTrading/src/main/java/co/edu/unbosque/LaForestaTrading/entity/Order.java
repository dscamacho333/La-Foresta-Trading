package co.edu.unbosque.LaForestaTrading.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "local_id")
    private Long localId;

    @Column(name = "alpaca_order_id", length = 255)
    private String alpacaOrderId;

    @Column(name = "client_order_id", length = 255)
    private String clientOrderId;

    @Column(name = "created_at", length = 255)
    private String createdAt;

    @Column(name = "updated_at", length = 255)
    private String updatedAt;

    @Column(name = "submitted_at", length = 255)
    private String submittedAt;

    @Column(name = "filled_at", length = 255)
    private String filledAt;

    @Column(name = "expired_at", length = 255)
    private String expiredAt;

    @Column(name = "canceled_at", length = 255)
    private String canceledAt;

    @Column(name = "failed_at", length = 255)
    private String failedAt;

    @Column(name = "replaced_at", length = 255)
    private String replacedAt;

    @Column(name = "replaced_by", length = 255)
    private String replacedBy;

    @Column(name = "replaces", length = 255)
    private String replaces;

    @Column(name = "asset_id", length = 255)
    private String assetId;

    @Column(name = "symbol", length = 50)
    private String symbol;

    @Column(name = "asset_class", length = 50)
    private String assetClass;

    @Column(name = "notional", length = 50)
    private String notional;

    @Column(name = "qty", length = 50)
    private String qty;

    @Column(name = "filled_qty", length = 50)
    private String filledQty;

    @Column(name = "filled_avg_price", length = 50)
    private String filledAvgPrice;

    @Column(name = "order_class", length = 50)
    private String orderClass;

    @Column(name = "order_type", length = 50)
    private String orderType;

    @Column(name = "type", length = 50)
    private String type;

    @Column(name = "side", length = 50)
    private String side;

    @Column(name = "position_intent", length = 50)
    private String positionIntent;

    @Column(name = "time_in_force", length = 50)
    private String timeInForce;

    @Column(name = "limit_price", length = 50)
    private String limitPrice;

    @Column(name = "stop_price", length = 50)
    private String stopPrice;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "extended_hours", length = 10)
    private String extendedHours;

    @Column(name = "legs", length = 500)
    private String legs;

    @Column(name = "trail_percent", length = 50)
    private String trailPercent;

    @Column(name = "trail_price", length = 50)
    private String trailPrice;

    @Column(name = "hwm", length = 50)
    private String hwm;

    @Column(name = "commission", length = 50)
    private String commission;

    @Column(name = "subtag", length = 50)
    private String subtag;

    @Column(name = "source", length = 50)
    private String source;

    @Column(name = "expires_at", length = 255)
    private String expiresAt;

    @Column(name = "local_creation_date")
    private LocalDateTime localCreationDate;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Investor investor;


    public Order() {
    }


    public Order(String alpacaOrderId, String clientOrderId, String createdAt, String updatedAt, String submittedAt, String filledAt, String expiredAt, String canceledAt, String failedAt, String replacedAt, String replacedBy, String replaces, String assetId, String symbol, String assetClass, String notional, String qty, String filledQty, String filledAvgPrice, String orderClass, String orderType, String type, String side, String positionIntent, String timeInForce, String limitPrice, String stopPrice, String status, String extendedHours, String legs, String trailPercent, String trailPrice, String hwm, String commission, String subtag, String source, String expiresAt, LocalDateTime localCreationDate, Investor investor) {
        this.alpacaOrderId = alpacaOrderId;
        this.clientOrderId = clientOrderId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.submittedAt = submittedAt;
        this.filledAt = filledAt;
        this.expiredAt = expiredAt;
        this.canceledAt = canceledAt;
        this.failedAt = failedAt;
        this.replacedAt = replacedAt;
        this.replacedBy = replacedBy;
        this.replaces = replaces;
        this.assetId = assetId;
        this.symbol = symbol;
        this.assetClass = assetClass;
        this.notional = notional;
        this.qty = qty;
        this.filledQty = filledQty;
        this.filledAvgPrice = filledAvgPrice;
        this.orderClass = orderClass;
        this.orderType = orderType;
        this.type = type;
        this.side = side;
        this.positionIntent = positionIntent;
        this.timeInForce = timeInForce;
        this.limitPrice = limitPrice;
        this.stopPrice = stopPrice;
        this.status = status;
        this.extendedHours = extendedHours;
        this.legs = legs;
        this.trailPercent = trailPercent;
        this.trailPrice = trailPrice;
        this.hwm = hwm;
        this.commission = commission;
        this.subtag = subtag;
        this.source = source;
        this.expiresAt = expiresAt;
        this.localCreationDate = localCreationDate;
        this.investor = investor;
    }

    public Order(Long localId, String alpacaOrderId, String clientOrderId, String createdAt, String updatedAt, String submittedAt, String filledAt, String expiredAt, String canceledAt, String failedAt, String replacedAt, String replacedBy, String replaces, String assetId, String symbol, String assetClass, String notional, String qty, String filledQty, String filledAvgPrice, String orderClass, String orderType, String type, String side, String positionIntent, String timeInForce, String limitPrice, String stopPrice, String status, String extendedHours, String legs, String trailPercent, String trailPrice, String hwm, String commission, String subtag, String source, String expiresAt, LocalDateTime localCreationDate, Investor investor) {
        this.localId = localId;
        this.alpacaOrderId = alpacaOrderId;
        this.clientOrderId = clientOrderId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.submittedAt = submittedAt;
        this.filledAt = filledAt;
        this.expiredAt = expiredAt;
        this.canceledAt = canceledAt;
        this.failedAt = failedAt;
        this.replacedAt = replacedAt;
        this.replacedBy = replacedBy;
        this.replaces = replaces;
        this.assetId = assetId;
        this.symbol = symbol;
        this.assetClass = assetClass;
        this.notional = notional;
        this.qty = qty;
        this.filledQty = filledQty;
        this.filledAvgPrice = filledAvgPrice;
        this.orderClass = orderClass;
        this.orderType = orderType;
        this.type = type;
        this.side = side;
        this.positionIntent = positionIntent;
        this.timeInForce = timeInForce;
        this.limitPrice = limitPrice;
        this.stopPrice = stopPrice;
        this.status = status;
        this.extendedHours = extendedHours;
        this.legs = legs;
        this.trailPercent = trailPercent;
        this.trailPrice = trailPrice;
        this.hwm = hwm;
        this.commission = commission;
        this.subtag = subtag;
        this.source = source;
        this.expiresAt = expiresAt;
        this.localCreationDate = localCreationDate;
        this.investor = investor;
    }

    public Long getLocalId() {
        return localId;
    }

    public void setLocalId(Long localId) {
        this.localId = localId;
    }

    public String getAlpacaOrderId() {
        return alpacaOrderId;
    }

    public void setAlpacaOrderId(String alpacaOrderId) {
        this.alpacaOrderId = alpacaOrderId;
    }

    public String getClientOrderId() {
        return clientOrderId;
    }

    public void setClientOrderId(String clientOrderId) {
        this.clientOrderId = clientOrderId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(String submittedAt) {
        this.submittedAt = submittedAt;
    }

    public String getFilledAt() {
        return filledAt;
    }

    public void setFilledAt(String filledAt) {
        this.filledAt = filledAt;
    }

    public String getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(String expiredAt) {
        this.expiredAt = expiredAt;
    }

    public String getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(String canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getFailedAt() {
        return failedAt;
    }

    public void setFailedAt(String failedAt) {
        this.failedAt = failedAt;
    }

    public String getReplacedAt() {
        return replacedAt;
    }

    public void setReplacedAt(String replacedAt) {
        this.replacedAt = replacedAt;
    }

    public String getReplacedBy() {
        return replacedBy;
    }

    public void setReplacedBy(String replacedBy) {
        this.replacedBy = replacedBy;
    }

    public String getReplaces() {
        return replaces;
    }

    public void setReplaces(String replaces) {
        this.replaces = replaces;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }

    public String getNotional() {
        return notional;
    }

    public void setNotional(String notional) {
        this.notional = notional;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getFilledQty() {
        return filledQty;
    }

    public void setFilledQty(String filledQty) {
        this.filledQty = filledQty;
    }

    public String getFilledAvgPrice() {
        return filledAvgPrice;
    }

    public void setFilledAvgPrice(String filledAvgPrice) {
        this.filledAvgPrice = filledAvgPrice;
    }

    public String getOrderClass() {
        return orderClass;
    }

    public void setOrderClass(String orderClass) {
        this.orderClass = orderClass;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getPositionIntent() {
        return positionIntent;
    }

    public void setPositionIntent(String positionIntent) {
        this.positionIntent = positionIntent;
    }

    public String getTimeInForce() {
        return timeInForce;
    }

    public void setTimeInForce(String timeInForce) {
        this.timeInForce = timeInForce;
    }

    public String getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(String limitPrice) {
        this.limitPrice = limitPrice;
    }

    public String getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(String stopPrice) {
        this.stopPrice = stopPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExtendedHours() {
        return extendedHours;
    }

    public void setExtendedHours(String extendedHours) {
        this.extendedHours = extendedHours;
    }

    public String getLegs() {
        return legs;
    }

    public void setLegs(String legs) {
        this.legs = legs;
    }

    public String getTrailPercent() {
        return trailPercent;
    }

    public void setTrailPercent(String trailPercent) {
        this.trailPercent = trailPercent;
    }

    public String getTrailPrice() {
        return trailPrice;
    }

    public void setTrailPrice(String trailPrice) {
        this.trailPrice = trailPrice;
    }

    public String getHwm() {
        return hwm;
    }

    public void setHwm(String hwm) {
        this.hwm = hwm;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public String getSubtag() {
        return subtag;
    }

    public void setSubtag(String subtag) {
        this.subtag = subtag;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LocalDateTime getLocalCreationDate() {
        return localCreationDate;
    }

    public void setLocalCreationDate(LocalDateTime localCreationDate) {
        this.localCreationDate = localCreationDate;
    }

    public Investor getInvestor() {
        return investor;
    }

    public void setInvestor(Investor investor) {
        this.investor = investor;
    }

    @Override
    public String toString() {
        return "Order{" +
                "localId=" + localId +
                ", alpacaOrderId='" + alpacaOrderId + '\'' +
                ", clientOrderId='" + clientOrderId + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", submittedAt='" + submittedAt + '\'' +
                ", filledAt='" + filledAt + '\'' +
                ", expiredAt='" + expiredAt + '\'' +
                ", canceledAt='" + canceledAt + '\'' +
                ", failedAt='" + failedAt + '\'' +
                ", replacedAt='" + replacedAt + '\'' +
                ", replacedBy='" + replacedBy + '\'' +
                ", replaces='" + replaces + '\'' +
                ", assetId='" + assetId + '\'' +
                ", symbol='" + symbol + '\'' +
                ", assetClass='" + assetClass + '\'' +
                ", notional='" + notional + '\'' +
                ", qty='" + qty + '\'' +
                ", filledQty='" + filledQty + '\'' +
                ", filledAvgPrice='" + filledAvgPrice + '\'' +
                ", orderClass='" + orderClass + '\'' +
                ", orderType='" + orderType + '\'' +
                ", type='" + type + '\'' +
                ", side='" + side + '\'' +
                ", positionIntent='" + positionIntent + '\'' +
                ", timeInForce='" + timeInForce + '\'' +
                ", limitPrice='" + limitPrice + '\'' +
                ", stopPrice='" + stopPrice + '\'' +
                ", status='" + status + '\'' +
                ", extendedHours='" + extendedHours + '\'' +
                ", legs='" + legs + '\'' +
                ", trailPercent='" + trailPercent + '\'' +
                ", trailPrice='" + trailPrice + '\'' +
                ", hwm='" + hwm + '\'' +
                ", commission='" + commission + '\'' +
                ", subtag='" + subtag + '\'' +
                ", source='" + source + '\'' +
                ", expiresAt='" + expiresAt + '\'' +
                ", localCreationDate=" + localCreationDate +
                ", investor=" + investor +
                '}';
    }
}
