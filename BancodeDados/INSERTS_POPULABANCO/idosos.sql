USE asilo;
-- Inserts para a tabela 'idosos'
INSERT INTO idosos (nome, data_nascimento, sexo, estado_saude, observacoes, responsavel_id, criado_em, atualizado_em) 
VALUES  
    ('Antonio Gomes', '1935-04-18', 'M', 'ESTAVEL', 'Nenhuma observação', 3, NOW(), NOW()),
    ('Mariana Pereira', '1948-09-05', 'F', 'OBSERVACAO', 'Consultas periódicas de acompanhamento', 4, NOW(), NOW()),
    ('Ricardo Silva', '1928-12-22', 'M', 'GRAVE', 'Requer cuidados intensivos e monitoramento constante', 5, NOW(), NOW()),
    ('Beatriz Almeida', '1952-02-10', 'F', 'ESTAVEL', 'Cuidados com diabetes e controle de peso', 6, NOW(), NOW()),
    ('Fernando Lima', '1960-07-15', 'M', 'OBSERVACAO', 'Acompanhamento cardiovascular regular', 7, NOW(), NOW()),
    ('Isabel Costa', '1933-11-07', 'F', 'GRAVE', 'Acompanhamento de saúde especializado', 8, NOW(), NOW()),
    ('José Carvalho', '1942-08-28', 'M', 'ESTAVEL', 'Sem observações importantes', 9, NOW(), NOW()),
    ('Helena Ferreira', '1955-03-02', 'F', 'OBSERVACAO', 'Cuidados com a mobilidade', 10, NOW(), NOW()),
    ('Pedro Oliveira', '1947-01-23', 'M', 'ESTAVEL', 'Sem condições de saúde preocupantes', 3, NOW(), NOW()),
    ('Lucia Marques', '1939-05-18', 'F', 'GRAVE', 'Necessita de cuidados médicos contínuos', 4, NOW(), NOW());
