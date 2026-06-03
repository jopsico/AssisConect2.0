USE asilo;
-- Inserts para a tabela 'atividades'
INSERT INTO atividades (nome, data, horario_inicio, horario_fim, responsavel, observacoes, criado_em, atualizado_em) 
VALUES  
    ('Atividade de Fisioterapia', '2025-10-10', '09:00:00', '10:00:00', 'Gabriela Souza', 'Fisioterapia para melhorar a mobilidade dos idosos.', NOW(), NOW()),
    ('Atividade Recreativa', '2025-10-11', '14:00:00', '15:00:00', 'Marta Ribeiro', 'Jogos e dinâmicas para estímulo cognitivo.', NOW(), NOW()),
    ('Acompanhamento Médico', '2025-10-12', '08:00:00', '09:00:00', 'Eduardo Silva', 'Consulta com médico geriatra.', NOW(), NOW()),
    ('Oficina de Artes', '2025-10-13', '13:00:00', '14:30:00', 'Luciana Oliveira', 'Atividades de pintura e artesanato para estimulação cognitiva e motora.', NOW(), NOW()),
    ('Yoga e Relaxamento', '2025-10-14', '16:00:00', '17:00:00', 'Pedro Gomes', 'Sessão de yoga para idosos, com foco em alongamento e relaxamento.', NOW(), NOW()),
    ('Aula de Dança', '2025-10-15', '10:00:00', '11:00:00', 'Fernanda Alves', 'Aula de dança para promover a socialização e a atividade física.', NOW(), NOW()),
    ('Leitura e Discussão de Livros', '2025-10-16', '11:00:00', '12:00:00', 'Lucas Martins', 'Discussão sobre livros e temas de interesse para estimular o intelecto.', NOW(), NOW()),
    ('Caminhada ao Ar Livre', '2025-10-17', '07:00:00', '08:00:00', 'Gabriela Souza', 'Caminhada leve no jardim para estimular a circulação e bem-estar.', NOW(), NOW()),
    ('Terapia Ocupacional', '2025-10-18', '15:00:00', '16:00:00', 'Marta Ribeiro', 'Sessão de terapia ocupacional para melhorar a função motora.', NOW(), NOW()),
    ('Sessão de Música Terapêutica', '2025-10-19', '14:00:00', '15:00:00', 'Eduardo Silva', 'Música terapêutica para relaxamento e melhoria do humor dos idosos.', NOW(), NOW());
