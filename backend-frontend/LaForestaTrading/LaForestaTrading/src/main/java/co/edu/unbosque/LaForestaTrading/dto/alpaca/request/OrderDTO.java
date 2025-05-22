package co.edu.unbosque.LaForestaTrading.dto.alpaca.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class OrderDTO {

    private String localId;

    @JsonProperty("id")
    private String alpacaOrderId;

    @JsonProperty("client_order_id")
    private String clientOrderId;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("submitted_at")
    private String submittedAt;

    @JsonProperty("filled_at")
    private String filledAt;

    @JsonProperty("expired_at")
    private String expiredAt;

    @JsonProperty("canceled_at")
    private String canceledAt;

    @JsonProperty("failed_at")
    private String failedAt;

    @JsonProperty("replaced_at")
    private String replacedAt;

    @JsonProperty("replaced_by")
    private String replacedBy;

    @JsonProperty("replaces")
    private String replaces;

    @JsonProperty("asset_id")
    private String assetId;

    // CAMPOS OBLIGATORIOS (no ignorar nunca)
    @JsonProperty(value = "symbol", required = true)
    private String symbol;

    @JsonProperty("asset_class")
    private String assetClass;

    @JsonProperty("notional")
    private String notional;

    @JsonProperty(value = "qty", required = true)
    private String qty;

    @JsonProperty("filled_qty")
    private String filledQty;

    @JsonProperty("filled_avg_price")
    private String filledAvgPrice;

    @JsonProperty("order_class")
    private String orderClass;

    @JsonProperty("order_type")
    private String orderType;

    @JsonProperty(value = "type", required = true)
    private String type;

    @JsonProperty(value = "side", required = true)
    private String side;

    @JsonProperty("position_intent")
    private String positionIntent;

    @JsonProperty(value = "time_in_force", required = true)
    private String timeInForce;

    @JsonProperty("limit_price")
    private String limitPrice;

    @JsonProperty("stop_price")
    private String stopPrice;

    @JsonProperty("status")
    private String status;

    @JsonProperty("extended_hours")
    private String extendedHours;

    @JsonProperty("legs")
    private String legs;

    @JsonProperty("trail_percent")
    private String trailPercent;

    @JsonProperty("trail_price")
    private String trailPrice;

    @JsonProperty("hwm")
    private String hwm;

    @JsonProperty("commission")
    private String commission;

    @JsonProperty("subtag")
    private String subtag;

    @JsonProperty("source")
    private String source;

    @JsonProperty("expires_at")
    private String expiresAt;

    private LocalDateTime localCreationDate;

    public OrderDTO() {
    }

    public OrderDTO(String alpacaOrderId, String clientOrderId, String createdAt, String updatedAt, String submittedAt, String filledAt, String expiredAt, String canceledAt, String failedAt, String replacedAt, String replacedBy, String replaces, String assetId, String symbol, String assetClass, String notional, String qty, String filledQty, String filledAvgPrice, String orderClass, String orderType, String type, String side, String positionIntent, String timeInForce, String limitPrice, String stopPrice, String status, String extendedHours, String legs, String trailPercent, String trailPrice, String hwm, String commission, String subtag, String source, String expiresAt, LocalDateTime localCreationDate) {
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
    }

    public OrderDTO(String localId, String alpacaOrderId, String clientOrderId, String createdAt, String updatedAt, String submittedAt, String filledAt, String expiredAt, String canceledAt, String failedAt, String replacedAt, String replacedBy, String replaces, String assetId, String symbol, String assetClass, String notional, String qty, String filledQty, String filledAvgPrice, String orderClass, String orderType, String type, String side, String positionIntent, String timeInForce, String limitPrice, String stopPrice, String status, String extendedHours, String legs, String trailPercent, String trailPrice, String hwm, String commission, String subtag, String source, String expiresAt, LocalDateTime localCreationDate) {
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
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                "localId='" + localId + '\'' +
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
                '}';
    }
}
