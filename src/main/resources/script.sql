use MusicStoreDB;
CREATE TABLE UTENTE(
                       CF int auto_increment primary key ,
                       Nome varchar(25) not null,
                       Cognome varchar(25) not null,
                       Ruolo varchar(25) not null,
                       dataNascita date not null,
                       via varchar(25),
                       citta varchar(25),
                       nazione varchar(25));


CREATE TABLE TELEFONO(
                         numero varchar(25),
                         UTENTE_FK int primary key ,
                         foreign key (UTENTE_FK) references UTENTE(CF)
);

CREATE TABLE CATEGORIA(
                          IDCategoria int auto_increment not null primary key,
                          NomeCateogoria varchar(25) not null,
                          descrizione varchar(25) not null);



CREATE TABLE STRUMENTO(
                          IDSTRUMENTO int auto_increment primary key,
                          NomeStrumento varchar(25) not null,
                          Prezzo float(5),
                          Offerta float(5),
                          Categoria int,
                          foreign key (Categoria) references CATEGORIA(IDCategoria)
);

CREATE TABLE ORDINE_PASSATO(
                               UTENTE int not null,
                               STRUMENTO int not null,
                               TotaleOrdine float(5),
                               sconto float(5) not null,
                               quantita int(3) not null,
                               dataOrdine date not null,
                               foreign key (UTENTE) references UTENTE(CF),
                               foreign key (STRUMENTO) references STRUMENTO(IDSTRUMENTO));


CREATE TABLE ORDINE(
                       UTENTE int not null,
                       STRUMENTO int not null,
                       TotaleOrdine float(5),
                       sconto float(5) not null,
                       quantita int(3) not null,
                       dataOrdine date not null,
                       foreign key (UTENTE) references UTENTE(CF),
                       foreign key (STRUMENTO) references STRUMENTO(IDSTRUMENTO));







