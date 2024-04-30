--liquibase formatted sql

--changeset 20240428_skavysh_ilya:1
CREATE TABLE IF NOT EXISTS person
(
    id SERIAL PRIMARY KEY,
    email VARCHAR(64) NOT NULL UNIQUE,
    document_number VARCHAR(64) NOT NULL UNIQUE,
    document_type VARCHAR(64) NOT NULL,
    active boolean DEFAULT TRUE
    );

--changeset 20240428_skavysh_ilya:2
CREATE TABLE IF NOT EXISTS account
(
    id SERIAL PRIMARY KEY,
    balance NUMERIC NOT NULL DEFAULT 0.00,
    currency VARCHAR(16) NOT NULL,
    number VARCHAR(64) NOT NULL,
    person_id INT
);

--changeset 20240428_skavysh_ilya:3
CREATE TABLE IF NOT EXISTS operation
(
    id SERIAL PRIMARY KEY,
    opertype VARCHAR(16) NOT NULL,
    amount NUMERIC NOT NULL DEFAULT 0.00,
    currency VARCHAR(16) NOT NULL,
    account_id INT,
    date_of_creation TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);