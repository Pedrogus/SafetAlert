-- tabelas 
CREATE TABLE AreaDeRisco (
id INT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
coordenadas VARCHAR(100) NOT NULL,
status ENUM('ativa', 'inativa') NOT NULL
);

CREATE TABLE Pessoa (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20),
    localizacao VARCHAR(100) NOT NULL
);

CREATE TABLE Alerta (
    id INT PRIMARY KEY AUTO_INCREMENT,
    mensagem TEXT NOT NULL,
    areaDeRisco_id INT,
    FOREIGN KEY (areaDeRisco_id) REFERENCES AreaDeRisco(id)
);



