USE asilo;

-- 1. Drop foreign key constraint on responsavel_id
ALTER TABLE atividades DROP FOREIGN KEY fk_atividades_responsavel;

-- 2. Drop index if it exists
ALTER TABLE atividades DROP INDEX idx_ativ_responsavel;

-- 3. Add the new 'responsavel' VARCHAR(255) column
ALTER TABLE atividades ADD COLUMN responsavel VARCHAR(255) NOT NULL DEFAULT 'Não atribuído';

-- 4. Copy existing responsibles' names from the 'usuarios' table to the 'responsavel' column
UPDATE atividades a 
JOIN usuarios u ON a.responsavel_id = u.id 
SET a.responsavel = u.nome;

-- 5. Drop the old 'responsavel_id' column
ALTER TABLE atividades DROP COLUMN responsavel_id;
