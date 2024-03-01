\c transaction_database


CREATE TABLE tb_accounts (
    id SERIAL PRIMARY KEY,
    account_number VARCHAR(255) UNIQUE,
    cpf_cnpj_holder VARCHAR(14) UNIQUE,
    balance NUMERIC(19, 2),
    open_date VARCHAR(19),
    closing_date VARCHAR(19)
);

CREATE TABLE tb_users (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email VARCHAR(255) UNIQUE,
    user_type INT,
    cpf_cnpj VARCHAR(14) UNIQUE,
    account_id BIGINT REFERENCES tb_accounts(id)
);

CREATE UNIQUE INDEX idx_tb_users_email ON tb_users (email);
CREATE UNIQUE INDEX idx_tb_accounts_cpf_cnpj_holder ON tb_accounts (cpf_cnpj_holder);

