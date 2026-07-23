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

CREATE TABLE utilisateur (
    id serial primary key,
    login VARCHAR(50) not null,
    password VARCHAR(50) not null,
)

CREATE TABLE etat (
    id serial primary key,
    libelle VARCHAR(50) not null
);

CREATE TABLE type_etat_panne (
    id serial primary key,
    type VARCHAR(50) not null
);

CREATE TABLE historique (
    id serial primary key,
    id_ordinateur INT not null references ordinateur(id),
    id_etat INT not null references etat(id),
    id_type_panne INT not null references type_etat_panne(id),
    date_entre TIMESTAMP not null,
    observation VARCHAR(255) not null
);


INSERT INTO marque (libelle) VALUES ('Dell');
INSERT INTO marque (libelle) VALUES ('HP');
INSERT INTO marque (libelle) VALUES ('Lenovo');
INSERT INTO marque (libelle) VALUES ('Acer');


INSERT INTO modele (libelle, id_marque, reference) VALUES ('Optiplex', 1, 'Intel Corei7');
INSERT INTO modele (libelle, id_marque, reference) VALUES ('Prodesk', 2, 'Intel Corei7');
INSERT INTO modele (libelle, id_marque, reference) VALUES ('ThinkCentre', 3, 'Intel Corei7');
INSERT INTO modele (libelle, id_marque, reference) VALUES ('ProBook', 2, 'Intel Corei7');
INSERT INTO modele (libelle, id_marque, reference) VALUES ('Latitude', 1, 'Intel Corei7');
INSERT INTO modele (libelle, id_marque, reference) VALUES ('Precision', 1, 'Intel Corei7');
INSERT INTO modele (libelle, id_marque, reference) VALUES ('Veriton', 4, 'Intel Corei7');



INSERT INTO utilisateur (login, password, role) VALUES ('admin', 'admin', 'admin');
INSERT INTO utilisateur (login, password, role) VALUES ('user', 'user', 'user');

INSERT INTO etat (libelle) VALUES ('Fonctionnel');
INSERT INTO etat (libelle) VALUES ('Non fonctionnel');

INSERT INTO type_etat_panne (type) VALUES ('Alimentation');
INSERT INTO type_etat_panne (type) VALUES ('Carte mere');
INSERT INTO type_etat_panne (type) VALUES ('Disque Dur');

INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (1, 16, 'intel core i7', 512);
INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (2, 16, 'intel core i7', 512);
INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (3, 16, 'intel core i7', 512);
INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (4, 16, 'intel core i7', 512);
INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (5, 16, 'intel core i7', 512);
INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (6, 16, 'intel core i7', 512);
INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (3, 16, 'intel core i7', 512);
INSERT INTO ordinateur (id_modele, ram, processeur, disque_dur) VALUES (7, 16, 'intel core i7', 512);




INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (1, 1, '2026-07-21', 'Mety tsara', 3);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (1, 2, '2026-07-22', 'tsy nandeha tampoka', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (1, 1, '2026-07-23', 'zay vao nety', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (2, 1, '2026-07-22', 'milamina', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (2, 2, '2026-07-23', 'tsy milamina', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (3, 2, '2026-07-21', 'tsy nandeha', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (3, 1, '2026-07-22', 'nandeha', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (3, 2, '2026-07-23', 'tsy nandeha', 2);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (4, 1, '2026-07-23', 'tsy misy kianina', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (5, 1, '2026-07-21', 'mandeha tsara', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (5, 2, '2026-07-23', 'tsy hay hoe ahoana', 3);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (6, 2, '2026-07-23', 'tsy mety velone mihitsy', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (7, 1, '2026-07-21', 'nandeha', 1);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (7, 2, '2026-07-23', 'maty tampoka', 2);
INSERT INTO historique (id_ordinateur, id_etat, date_entre, observation, id_type_panne) VALUES (8, 1, '2026-07-23', 'milamina tsara', 1);

    Select count(*) from historique group by id_etat;
    select count(*), id_type_panne, typ.type from historique join type_etat_panne typ on historique.id_type_panne = typ.id group by id_type_panne;
    select typ.type, count(h.id_type_panne) from historique h join type_etat_panne typ on h.id_type_panne = typ.id group by typ.type;


    select count(*), id_type_panne from historique group by id_type_panne;

DROP table modele;
DROP table marque;
DROP table historique;
DROP table ordinateur;
DROP table etat;

DELETE FROM marque;
DELETE FROM historique;
DELETE FROM ordinateur;
DELETE FROM etat;