USE asilo;
-- Inserts para a tabela 'atividade_idoso'
-- Observação: os IDs de atividade e idoso assumem que as tabelas usam IDs numéricos já existentes.
INSERT INTO atividade_idoso (atividade_id, idoso_id, criado_em) 
VALUES  
    (1, 1, NOW()),  -- Atividade 1 (Fisioterapia) para o Idoso 1
    (2, 2, NOW()),  -- Atividade 2 (Recreativa) para o Idoso 2
    (3, 3, NOW()),  -- Atividade 3 (Acompanhamento Médico) para o Idoso 3
    (4, 4, NOW()),  -- Atividade 4 (Oficina de Artes) para o Idoso 4
    (5, 5, NOW()),  -- Atividade 5 (Yoga e Relaxamento) para o Idoso 5
    (6, 6, NOW()),  -- Atividade 6 (Aula de Dança) para o Idoso 6
    (7, 7, NOW()),  -- Atividade 7 (Leitura e Discussão) para o Idoso 7
    (8, 8, NOW()),  -- Atividade 8 (Caminhada ao Ar Livre) para o Idoso 8
    (9, 9, NOW()),  -- Atividade 9 (Terapia Ocupacional) para o Idoso 9
    (10, 10, NOW()); -- Atividade 10 (Música Terapêutica) para o Idoso 10
