CREATE TABLE etudiant(
	-- les attributs 
	eno integer ,
	nom text ,
	prenom text ,
	groupe varchar(1) ,
	primary key(eno)
);
CREATE TABLE prof(
	-- les attributs
	pno integer ,
	nom text ,
	prenom text ,
	primary key(pno)
);
CREATE TABLE secretaire(
	-- les attributs
	sno integer ,
	nom text ,
	prenom text ,
	primary key(sno)
);
CREATE TABLE justificatif(
	eno integer ,
	dateDebut timestamp ,
	dateFin timestamp ,
	primary key(eno),
	foreign key(eno) references etudiant(eno)
);

CREATE TABLE abscence (
	-- les attributs 
	ano serial ,
	nom text ,
	prenom text ,
	groupe varchar(1),
	dateDebut timestamp ,
	dateFin timestamp ,
	-- les references :
	primary key(ano) ,
	foreign key(nom) references etudiant(nom) , 
	foreign key(prenom) references etudiant(prenom) ,
	foreign key(groupe) references etudiant(groupe) ,
	foreign key(dateDebut) references justificatif(dateDebut),
	foreign key(dateFin) references justificatif(dateFin)

);