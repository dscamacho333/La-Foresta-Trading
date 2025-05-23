USE la_foresta;


CREATE TABLE orders (
    local_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    alpaca_order_id VARCHAR(255),
    client_order_id VARCHAR(255),
    created_at VARCHAR(255),
    updated_at VARCHAR(255),
    submitted_at VARCHAR(255),
    filled_at VARCHAR(255),
    expired_at VARCHAR(255),
    canceled_at VARCHAR(255),
    failed_at VARCHAR(255),
    replaced_at VARCHAR(255),
    replaced_by VARCHAR(255),
    replaces VARCHAR(255),
    asset_id VARCHAR(255),
    symbol VARCHAR(50),
    asset_class VARCHAR(50),
    notional VARCHAR(50),
    qty VARCHAR(50),
    filled_qty VARCHAR(50),
    filled_avg_price VARCHAR(50),
    order_class VARCHAR(50),
    order_type VARCHAR(50),
    type VARCHAR(50),
    side VARCHAR(50),
    position_intent VARCHAR(50),
    time_in_force VARCHAR(50),
    limit_price VARCHAR(50),
    stop_price VARCHAR(50),
    status VARCHAR(50),
    extended_hours VARCHAR(10),
    legs VARCHAR(500),
    trail_percent VARCHAR(50),
    trail_price VARCHAR(50),
    hwm VARCHAR(50),
    commission VARCHAR(50),
    subtag VARCHAR(50),
    source VARCHAR(50),
    expires_at VARCHAR(255),
    local_creation_date TIMESTAMP,
    user_id BIGINT,
    
    CONSTRAINT fk_orders_user FOREIGN KEY (user_id) REFERENCES user(user_id)
);




