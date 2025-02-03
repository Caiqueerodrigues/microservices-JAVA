CREATE TABLE pagamentos(
    id BIGINT AUTO_INCREMENT,
    valor DECIMAL(19, 2) NOT NULL,
    nome VARCHAR(100) NOT NULL,
    numero VARCHAR(19) NOT NULL,
    expiracao VARCHAR(7) NOT NULL,
    codigo VARCHAR(3) NOT NULL,
    status VARCHAR(255) NOT NULL,
    pedido_id BIGINT(20) NOT NULL,
    forma_de_pagamento_id BIGINT(20) NOT NULL,
    PRIMARY KEY (id)
);