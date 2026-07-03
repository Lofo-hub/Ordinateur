-- POSTGRES

CREATE TABLE ordinateur (
    id serial primary key,
    id_modele INT not null,
    ram INT not null,
    processeur VARCHAR(50) not null,
    disque_dur INT not null
);

CREATE TABLE marque (
    id serial primary key,
    libelle VARCHAR(50) not null
);

CREATE TABLE modele (
    id serial primary key,
    libelle VARCHAR(50) not null,
    id_marque INT not null references marque(id),
    reference VARCHAR(50) not null
);

INSERT INTO marque (libelle) VALUES ('Dell');
INSERT INTO marque (libelle) VALUES ('HP');

INSERT INTO modele (libelle, id_marque, reference) VALUES ('Inspiron', 1, 'Inspiron 15');
INSERT INTO modele (libelle, id_marque, reference) VALUES ('Pavilion', 2, 'Pavilion 14');
INSERT INTO modele (libelle, id_marque, reference) VALUES ('XPS', 1, 'XPS 13');