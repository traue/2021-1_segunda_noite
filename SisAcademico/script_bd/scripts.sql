

  -- Durante a aula criamos o banco de dados da aplicação com os seguinte parâmetros:

  -- Nome do banco: SisAcademico_2noite
  -- Usuario: uninove
  -- Senha: Senha123

  -- TABELA DE CURSOS:
  CREATE TABLE "tb_curso"(
    "idCurso" INT NOT NULL PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    "nome_curso" VARCHAR(90) NOT NULL,
    "tipo_curso" VARCHAR(50)
);


-- TABELA DE ALUNOS:
CREATE TABLE "tb_aluno" (
    "idAluno" INT NOT NULL PRIMARY KEY
        GENERATED ALWAYS AS IDENTITY
        (START WITH 1, INCREMENT BY 1),
    "ra" INT NOT NULL,
    "nome" VARCHAR(100),
    "idCurso" INT,
    CONSTRAINT fk_aluno_curso FOREIGN KEY("idCurso")
    REFERENCES "tb_curso"
);
