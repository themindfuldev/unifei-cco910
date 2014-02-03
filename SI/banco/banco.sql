CREATE TABLE documento (
  numExame INTEGER NOT NULL,
  digExame INTEGER NOT NULL,
  arquivo BLOB NULL,
  tamanho INTEGER NULL,
  tipo VARCHAR NULL,
  nome VARCHAR NULL,
  PRIMARY KEY(numExame, digExame)
);