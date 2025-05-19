USE la_foresta;

CREATE TABLE investor (
    user_id BIGINT PRIMARY KEY, 

    alpaca_id CHAR(36) UNIQUE NOT NULL,
    account_number VARCHAR(20) UNIQUE NOT NULL,
    alpaca_status VARCHAR(30) NOT NULL,
    crypto_status VARCHAR(30) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    last_equity DECIMAL(18, 2) NOT NULL,
    created_at TIMESTAMP NOT NULL,

    -- Contact info
    street_address TEXT NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,

    -- Identity info
    date_of_birth DATE NOT NULL,
    country_of_citizenship CHAR(3) NOT NULL,
    country_of_birth CHAR(3) NOT NULL,
    party_type VARCHAR(50) NOT NULL,
    tax_id VARCHAR(10) UNIQUE NOT NULL,
    tax_id_type VARCHAR(30) NOT NULL,
    country_of_tax_residence CHAR(3) NOT NULL,

    -- Disclosures
    is_control_person BOOLEAN NOT NULL,
    is_affiliated_exchange_or_finra BOOLEAN NOT NULL,
    is_affiliated_exchange_or_iiroc BOOLEAN NOT NULL,
    is_politically_exposed BOOLEAN NOT NULL,
    immediate_family_exposed BOOLEAN NOT NULL,
    is_discretionary BOOLEAN NOT NULL,

  
    account_type VARCHAR(20) NOT NULL,
    trading_type VARCHAR(20) NOT NULL,

    buying_power DECIMAL(18, 2),
    stocks_of_interest VARCHAR(255),
    is_premium BOOLEAN DEFAULT FALSE,

    CONSTRAINT fk_investor_user FOREIGN KEY (user_id) REFERENCES user(user_id)
);