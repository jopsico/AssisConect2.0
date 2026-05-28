USE asilo;
-- Inserts para a tabela 'usuarios' com senhas criptografadas em BCrypt (todas com a senha: senhaPadrao123)
INSERT INTO usuarios (nome, email, senha, role, data_criacao) 
VALUES  
    ('Carlos Almeida', 'carlos.almeida@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'admin', NOW()),
    ('Juliana Costa', 'juliana.costa@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'funcionario', NOW()),
    ('Renato Pereira', 'renato.pereira@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'familiar', NOW()),
    ('Gabriela Souza', 'gabriela.souza@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'funcionario', NOW()),
    ('Marta Ribeiro', 'marta.ribeiro@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'familiar', NOW()),
    ('Eduardo Silva', 'eduardo.silva@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'admin', NOW()),
    ('Luciana Oliveira', 'luciana.oliveira@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'familiar', NOW()),
    ('Pedro Gomes', 'pedro.gomes@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'funcionario', NOW()),
    ('Fernanda Alves', 'fernanda.alves@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'familiar', NOW()),
    ('Lucas Martins', 'lucas.martins@exemplo.com', '$2a$10$w8LpyCqEwTjKjQjTpe748.vE1.k3W.W.N2c5/g4N43.o99LpyCqEw', 'funcionario', NOW());

