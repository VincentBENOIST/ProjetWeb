drop table justificatif;
drop table absence;
drop table personne;



CREATE TABLE personne(
	-- les attributs 
	login text,
	nom text ,
	prenom text ,
	mdp text,
	groupe text ,
	primary key(login)
);

CREATE TABLE justificatif(
	jno integer,
	libelle text,
	dateDebut date ,
	dateFin date ,
	loginsecretaire text,
	loginetudiant text,
	primary key(jno),
	foreign key(loginsecretaire) references personne(login),
	foreign key(loginetudiant) references personne(login)
);

CREATE TABLE absence (
	-- les attributs 
	ano integer,
	login text,
	dateDebut date ,
	dateFin date ,
	-- les references :
	primary key(ano) ,
	foreign key(login) references personne(login)
	
);

insert into personne values ('brisseta','brisset','adrien','brad','etudiant');
insert into personne values ('benoistv','benoist','vincent','bevi','etudiant');
insert into personne values ('vanderar','vanderaspoilden','rodolphe','varo','etudiant');
insert into personne values ('dillese','dillies','elodie','diel','secretaire');
insert into personne values ('beaufilb','beaufil','bruno','bebr','prof');
insert into justificatif values (1,'malade','2016-12-27','2016-12-28','dillese','vanderar');
insert into justificatif values (2,'retard','2017-02-20','2017-02-21','dillese','vanderar');
insert into justificatif values (3,'panne','2016-12-20','2016-12-22','dillese','benoistv');
insert into absence values (1,'vanderar','2016-12-27','2016-12-28');
insert into absence values (2,'vanderar','2017-02-20','2017-02-21');
insert into absence values (3,'vanderar','2016-12-25','2016-12-26');
insert into absence values (4,'benoistv','2016-12-20','2016-12-22');