\c transaction_database

CREATE TABLE tb_users (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    userEnum INT,
    cpf_cnpj VARCHAR(14) UNIQUE,
    account_id BIGINT REFERENCES tb_accounts(id)
);

CREATE TABLE tb_accounts (
    id SERIAL PRIMARY KEY,
    accountNumber VARCHAR(255),
    cpf_cnpj_titular VARCHAR(14),
    balance NUMERIC(19, 2),
    openDate VARCHAR(19),
    closingDate VARCHAR(19)
);

CREATE UNIQUE INDEX idx_tb_users_email ON tb_users (email);
CREATE UNIQUE INDEX idx_tb_accounts_cpf_cnpj_titular ON tb_accounts (cpf_cnpj_titular);

