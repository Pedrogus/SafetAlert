-- Inserindo áreas de risco
INSERT INTO AreaDeRisco (nome, coordenadas, status) VALUES
('Bairro Central', 'LAT:-23.5505, LONG:-46.6333', 'ativa'),
('Vila Nova', 'LAT:-23.5550, LONG:-46.6300', 'inativa');

-- Inserindo pessoas
INSERT INTO Pessoa (nome, telefone, localizacao) VALUES
('Ana Silva', '11999998888', 'LAT:-23.5505, LONG:-46.6333'),
('Carlos Souza', '11988887777', 'LAT:-23.5550, LONG:-46.6300'),
('Mariana Oliveira', '11977776666', 'LAT:-23.5600, LONG:-46.6400');

-- Inserindo alertas
INSERT INTO alerta (mensagem, areaDeRisco_id) VALUES
('Enchente iminente! Evacuar imediatamente.', 1),
('Área em monitoramento, fiquem atentos.', 2);

-- Alterar status da área para ativa
UPDATE AreaDeRisco
SET status = 'inativa'
WHERE id = 2 ;

-- Atualizar localização de uma pessoa
UPDATE Pessoa
SET localizacao = 'LAT:-23.5510, LONG:-46.6340'
WHERE id = 1;
