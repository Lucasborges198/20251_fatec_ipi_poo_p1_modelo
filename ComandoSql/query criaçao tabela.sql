create table TB_PERSONAGEM (
    ID int NOT NULL PRIMARY KEY,
    Nome VARCHAR(100) NOT NULL,
    Prob_Construir NUMERIC(3, 2) NOT NULL,
    Prob_Madeira NUMERIC(3, 2) NOT NULL,
    Prob_Mineirar NUMERIC(3, 2) NOT NULL,
    Nr_Vitorias int,
    Nr_Derrotas int
);

select * from tb_personagem;