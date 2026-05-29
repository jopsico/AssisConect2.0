-- Inserts para a tabela 'usuarios'
INSERT INTO usuarios (nome, email, senha, role, data_criacao) 
VALUES  
    ('Carlos Almeida', 'carlos.almeida@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'admin', NOW()),
    ('Juliana Costa', 'juliana.costa@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'funcionario', NOW()),
    ('Renato Pereira', 'renato.pereira@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'familiar', NOW()),
    ('Gabriela Souza', 'gabriela.souza@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'funcionario', NOW()),
    ('Marta Ribeiro', 'marta.ribeiro@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'familiar', NOW()),
    ('Eduardo Silva', 'eduardo.silva@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'admin', NOW()),
    ('Luciana Oliveira', 'luciana.oliveira@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'familiar', NOW()),
    ('Pedro Gomes', 'pedro.gomes@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'funcionario', NOW()),
    ('Fernanda Alves', 'fernanda.alves@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'familiar', NOW()),
    ('Lucas Martins', 'lucas.martins@exemplo.com', '$2a$10$8.t7yS5d9i2W3Xp9yH1uGuW4.b1Lp2Jc7H4FwS1N3j5K6o8p9qR2y', 'funcionario', NOW());
