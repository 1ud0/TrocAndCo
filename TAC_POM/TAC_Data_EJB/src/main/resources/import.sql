/*============================*/
/*		TABLE VALEUR		  */
/*============================*/

INSERT INTO `valeur` (`id_valeur`, `intitule`, `valeur`) VALUES (1,'De 0 à 5 €',1);
INSERT INTO `valeur` (`id_valeur`, `intitule`, `valeur`) VALUES (2,'De 5 à 10 €',2);
INSERT INTO `valeur` (`id_valeur`, `intitule`, `valeur`) VALUES (3,'De 10 à 15 €',3);
INSERT INTO `valeur` (`id_valeur`, `intitule`, `valeur`) VALUES (4,'De 15 à 25 €',4);
INSERT INTO `valeur` (`id_valeur`, `intitule`, `valeur`) VALUES (5,'De 25 à 50 €',5);

/*============================*/
/*		TABLE ETAT 			  */
/*============================*/

INSERT INTO `etat` (`id_etat`, `intitule`) VALUES (1,'Neuf');
INSERT INTO `etat` (`id_etat`, `intitule`) VALUES (2,'Bon etat');
INSERT INTO `etat` (`id_etat`, `intitule`) VALUES (3,'Usé');
INSERT INTO `etat` (`id_etat`, `intitule`) VALUES (4,'Occasion');

/*============================*/
/*		TABLE COMPTE		  */
/*============================*/

INSERT INTO `compte` (`id_compte`, `type_compte`) VALUES (1,'admin');
INSERT INTO `compte` (`id_compte`, `type_compte`) VALUES (2,'membre');

/*============================*/
/*		TABLE CATEGORIE		  */
/*============================*/

INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (1,'Livre, BD',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (2,'Musique, CD',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (3,'DVD, Blu-Ray, VOD',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (4,'Jeux vidéo, Consoles',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (5,'Téléphonie, Tablette',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (6,'Informatique, Logiciel',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (7,'Images, Son',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (8,'Maison, électro, Déco',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (9,'Brico, Jardin, Animalerie',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (10,'Sport, Loisirs',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (11,'Mode, Breauté',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (12,'Jouets, Enfants',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (13,'Auto, Moto',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (14,'Art et Collection',NULL);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (15,'BD, Humour et Jeunesse',1);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (16,'Littérature et Fiction',1);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (17,'Culture, Société',1);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (18,'Scolaire, Universitaire',1);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (19,'Vie pratique, Loisir',1);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (20,'Autres',1);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (21,'CD',2);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (22,'Vyniles',2);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (23,'Instruments de musique',2);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (24,'Autres',2);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (25,'DVD',3);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (26,'Blu-Ray',3);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (27,'VOD',3);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (28,'Autres',3);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (29,'Consoles',4);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (30,'Jeux vidéo',4);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (31,'Accessoires',4);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (32,'Autres',4);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (33,'Téléphonie',5);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (34,'Tablettes, Liseuses',5);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (35,'Accesoires mobiles',5);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (36,'Objets Connectés',5);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (37,'Autres',5);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (38,'Ordinateur portable',6);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (39,'Tablettes',6);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (40,'Ordinateurs de bureau',6);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (41,'Stockage et périphérique',6);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (42,'Autres',6);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (43,'Appareil photos',7);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (44,'Hifi, Son',7);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (45,'TV, Home cinema',7);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (46,'MP3, casques',7);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (47,'Autres',7);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (48,'Gros électro',8);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (49,'Petit électro',8);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (50,'Cuisine',8);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (51,'Bien être',8);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (52,'Mobilier',8);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (53,'Déco',8);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (54,'Vin, épicerie',8);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (55,'Autres',8);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (56,'Brico',9);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (57,'Mobilier de jardin',9);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (58,'Outilages de jardin',9);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (59,'Animalerie',9);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (60,'Autres',9);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (61,'Matériel de sport',10);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (62,'Objets Connectés',10);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (63,'Chaussures',10);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (64,'Vêtements',10);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (65,'Autres',10);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (66,'Femmes',11);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (67,'Hommes',11);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (68,'Beauté, Santé',11);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (69,'Accessoires',11);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (70,'Autres',11);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (71,'Puériculture',12);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (72,'Jouets',12);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (73,'Modélisme',12);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (74,'Jeux de plein air',12);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (75,'Autres',12);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (76,'Equipement auto',13);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (77,'Entretien auto moto',13);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (78,'Pneus, Pièces',13);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (79,'Tunning',13);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (80,'Univers 2 roues',13);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (81,'Autres',13);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (82,'Timbres et monnaies',14);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (83,'Art et Photos',14);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (84,'Carte postales',14);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (85,'Objets à collectionner',14);
INSERT INTO `categorie` (`id_categorie`, `intitule`, `id_categorie_mere`) VALUES (86,'Autres',14);

/*============================*/
/*		TABLE MEMBRE		  */
/*============================*/

INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (1,'LECLER','Buzz','1990-12-12','2017-03-01 00:00:00','img/imgAvatar/avatar15.jpg','buzz@toc.com',NULL,NULL,NULL,NULL,'Buzzy','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (2,'LEPONGE','Bob','1995-10-01','2017-03-01 00:00:00','img/imgAvatar/avatar14.jpg','bob@eponge.com',NULL,NULL,NULL,NULL,'Bob','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (3,'Admin','admin','1985-07-04','2016-04-01 00:00:00','img/imgAvatar/avatar7.jpg','admin@trocandco.com',NULL,NULL,NULL,NULL,'admin','pass',1);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (4,'Durant','Maurice','1966-06-06','2017-04-25 00:00:00','img/imgAvatar/avatar15.jpg','maurice.durant@gmail.com','0612345678',NULL,NULL,NULL,'Momo','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (5,'Lussac','Raphael','1985-03-04','2017-04-12 00:00:00','img/imgAvatar/avatar6.jpg','raph.lulu@gmail.com','0214569875',NULL,NULL,NULL,'raph','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (6,'Bob','Toto','1963-02-24','2017-03-01 00:00:00','img/imgAvatar/Toto.jpg','bob.toto@toto.com','0236547895',NULL,NULL,NULL,'TotoBob','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (7,'Dodo','Lulu','1975-07-15','2016-12-12 00:00:00','img/imgAvatar/avatar1.png','lulu.dodo@dotnet.fr','0312121212',NULL,NULL,NULL,'Ludo','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (8,'Outant','Laurent','1984-08-15','2016-11-03 00:00:00','img/imgAvatar/avatar4.png','lolo@lolo.fr','0456565656',NULL,NULL,NULL,'Lolo','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (9,'De Bourbon','Louis','1953-04-06','2016-02-03 00:00:00','img/imgAvatar/avatar13.jpg','Loulou14@france.fr','0101010101',NULL,NULL,NULL,'Kingsun','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (10,'D autriche','Marie-Thérèse','1954-09-10','2016-05-09 00:00:00','img/imgAvatar/avatar8.jpg','marieT@france.fr','0202020202',NULL,NULL,NULL,'QueenMT','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (11,'France','Galle','1966-11-30','2017-03-25 00:00:00','img/imgAvatar/avatar12.jpg','fg@france.fr','0303030303',NULL,NULL,NULL,'FranceG','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (12,'Michel','Brian','1956-05-06','2017-04-02','img/imgAvatar/avatar5.png','Michel.Brian@gmail.com','0254695762',NULL,NULL,NULL,'Michel','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (13,'Miguel','Jozette','1957-04-17','2017-04-03','img/imgAvatar/avatar3.png','Miguel.Jozette@gmail.com','0124965345',NULL,NULL,NULL,'Miguel','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (14,'Travis','Ed','1956-12-25','2017-04-04','img/imgAvatar/avatar1.png','Travis.Ed@gmail.com','0234589566',NULL,NULL,NULL,'Travis','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (15,'Doe','John','1976-04-26','2017-04-05','img/imgAvatar/avatar1.png','Doe.John@gmail.com','0324565464',NULL,NULL,NULL,'Doe','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (16,'Sparrow','Jack','1992-03-25','2017-04-06','img/imgAvatar/avatar13.jpg','Sparrow.Jack@gmail.com','0165465462',NULL,NULL,NULL,'Sparrow','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (17,'Lama','Serge','1966-06-06','2017-04-07','img/imgAvatar/avatar13.jpg','Lama.Serge@gmail.com','0324598466',NULL,NULL,NULL,'Lama','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (18,'Mondor','Henri','1945-07-14','2017-04-08','img/imgAvatar/avatar10.jpg','Mondor.Henri@gmail.com','0694643233',NULL,NULL,NULL,'Mondor','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (19,'Freeman','Morgan','1953-04-18','2017-04-09','img/imgAvatar/avatar6.jpg','Freeman.Morgan@gmail.com','0654795332',NULL,'2017-04-29','Abuse','Freeman','pass',2);
INSERT INTO `membre` (`id_membre`, `nom`, `prenom`, `date_naissance`, `date_inscription`, `avatar`, `mail`, `telephone`, `date_desinscription`, `date_radiation`, `motif_radiation`, `pseudo`, `password`, `compte_id`) VALUES (20,'Smith','Black','1967-08-18','2017-04-10','img/imgAvatar/avatar1.png','Smith.Black@gmail.com','0694645541','2017-04-15',NULL,NULL,'Smith','pass',2);


/*============================*/
/*		TABLE PROPOSITION	  */
/*============================*/

INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (1,'Pot',1,1,1,5,35,'Pot pour faire popo ','2017-04-01 00:02:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (2,'Truc',2,1,1,6,41,'Truc bine inutile','2017-04-01 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (3,'Bidulle',3,1,2,8,52,'bidule servant à faire des truc','2017-05-01 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (5,'Chaussures',4,2,6,11,69,'Chaussures taille 92','2017-03-01 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (6,'Chaton',1,1,6,9,59,'Chatnoir','2017-03-01 12:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (7,'Rummikub',1,1,5,12,72,'En bon etat','2017-04-12 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (8,'Canard en plastique',2,2,4,12,71,'Tres peu utilisé couine trop! pratique pour les bains!','2017-04-25 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (9,'Vélo compétition',4,4,7,10,61,'Je prefère les trotinettes','2016-12-12 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (10,'Ordinateur portable',2,4,2,6,38,'Asus Rog','2017-04-01 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (11,'Bol vert',3,1,5,8,50,'Fait par mon fils!','2017-04-12 11:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (12,'Manteau en hermine Lisse',2,5,10,11,67,'Pas piqué des verres','2017-05-09 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (13,'Cadenas',3,2,9,14,85,'Du pont des arts','2017-02-03 10:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (14,'Peluche',1,2,2,12,71,'Bob léponge','2017-04-01 12:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (15,'Ballon',1,2,6,10,61,NULL,'2017-03-01 10:02:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (16,'Timbres',4,3,8,14,82,'Grosse collection','2017-03-03 20:00:00');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (17,'Casserole',1,1,12,8,50,'En cuivre','2017-04-04');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (18,'vélo',2,2,12,10,61,'Rockrider blanc','2017-04-05');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (19,'roue de vélo',3,3,12,10,61,'Roue rousse','2017-04-06');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (20,'trottinette',4,4,12,10,61,'pliable','2017-04-07');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (21,'Casque de moto',1,1,12,13,80,'Avec des cornes de diable','2017-04-08');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (22,'Poupée',2,2,13,12,72,'en chiffon','2017-04-09');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (23,'Bougie',3,3,13,8,53,'Senteur des îles','2017-04-10');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (24,'Pièces de lego',4,4,13,12,72,'Moité de TIE fighter','2017-04-11');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (25,'Peluche',1,1,14,12,71,'Ours gris','2017-04-12');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (26,'Verre à bière',2,2,14,8,52,'Grim','2017-04-13');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (27,'Sac en osier',3,3,14,11,69,'fait main','2017-04-14');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (28,'Gant pilote',4,4,15,13,80,'Petite taille','2017-04-15');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (29,'Porte bébé',1,1,15,12,71,'en kit','2017-04-16');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (30,'Cable alimentation pc',2,2,15,6,42,'Asus','2017-04-17');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (31,'Ecran pc Asus',3,3,16,6,40,'17 pouces','2017-04-18');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (32,'Manche de pioche',4,4,16,9,58,'En plastique vert','2017-04-19');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (33,'Tête de rateau',1,1,16,9,58,'32 dents','2017-04-20');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (34,'Mug',2,2,17,8,50,'Keep Calm','2017-04-21');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (35,'Parapluie',3,3,17,11,69,'Européen','2017-04-22');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (36,'Collection de timbre',4,4,17,14,82,'300 timbres 1950-200','2017-04-23');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (37,'Livre dont vous êtes le héros',1,1,18,1,16,'Qui est tu?','2017-04-24');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (38,'CD RadioHead',2,2,18,2,21,'1985','2017-04-25');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (39,'Vinyl Freddy',3,3,18,2,22,'Queen','2017-04-26');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (40,'VHS des nulls',4,4,19,3,28,'c est null','2017-04-27');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (41,'Affiche manger des pommes',1,1,19,14,85,'JC','2017-04-28');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (42,'Marteau',2,2,19,9,58,'Provenance URSS','2017-04-29');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (43,'Faucille',3,3,19,9,58,'Provenance URSS','2017-04-30');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (44,'Faucille1',3,3,5,9,58,'Provenance URSS','2017-03-01');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (45,'Faucille2',3,3,5,9,58,'Provenance URSS','2017-03-01');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (46,'Faucille3',3,3,5,9,58,'Provenance URSS','2017-03-01');
INSERT INTO `proposition` (`id_proposition`, `intitule`, `etat_id`, `valeur_id`, `membre_id`, `categorie_id`, `sous_categorie_id`, `description`, `date_ajout`) VALUES (47,'Faucille4',3,3,5,9,58,'Provenance URSS','2017-03-01');

/*============================*/
/*		TABLE TAG			  */
/*============================*/

INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (4,'Jeunesse',15);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (5,'Manga',15);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (6,'Comics',15);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (7,'Bouquin',16);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (8,'Roman',16);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (9,'Policier',16);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (10,'Art',17);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (11,'Cinéma',17);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (12,'Musique',17);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (13,'Manuel',18);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (14,'école',18);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (15,'université',18);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (16,'Hobby',19);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (17,'voyage',19);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (18,'yoga',19);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (19,'Rock',21);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (20,'Jazz',21);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (21,'Blues',21);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (22,'33',22);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (23,'45',22);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (24,'Vieux',22);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (25,'Guitare',23);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (26,'Violon',23);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (27,'Flute',23);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (28,'Film',25);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (29,'Comédie',25);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (30,'Série',25);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (31,'Film',26);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (32,'Comédie',26);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (33,'Série',26);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (34,'Film',27);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (35,'Comédie',27);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (36,'Série',27);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (37,'PS',29);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (38,'Nintendo',29);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (39,'Xbox',29);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (40,'PS',30);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (41,'Xbox',30);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (42,'DS',30);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (43,'Manette',31);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (44,'Souris',31);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (45,'Casque',31);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (46,'Iphone',33);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (47,'Samsung',33);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (48,'Nokia',33);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (49,'Ipad',34);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (50,'Samsung',34);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (51,'Kindle',34);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (52,'PC',35);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (53,'Mac',35);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (54,'Fixe',35);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (55,'Disque',36);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (56,'USB',36);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (57,'Ecran',36);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (58,'PC',38);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (59,'mac',38);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (60,'Imac',38);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (61,'Ipad',39);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (62,'Kindle',39);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (63,'Asus',39);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (64,'Dell',40);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (65,'Tour',40);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (66,'Pc',40);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (67,'Disque',41);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (68,'Dur',41);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (69,'Clef',41);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (70,'Reflex',43);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (71,'Polaroïd',43);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (72,'Compact',43);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (73,'Chaîne',44);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (74,'Enceinte',44);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (75,'Sono',44);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (76,'LED',45);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (77,'Ecran',45);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (78,'Projecteur',45);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (79,'Ipod',46);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (80,'Ecouteur',46);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (81,'Oreille',46);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (82,'Frigo',48);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (83,'Four',48);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (84,'Aspirateur',48);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (85,'café',49);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (86,'blender',49);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (87,'robot',49);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (88,'Couteau',50);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (89,'Fourchette',50);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (90,'cuillère',50);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (91,'épilateur',51);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (92,'radiateur',51);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (93,'chauffage',51);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (94,'canapé',52);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (95,'matelas',52);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (96,'lit',52);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (97,'Lampe',53);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (98,'tableau',53);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (99,'rideau',53);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (100,'alcool',54);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (101,'liqueur',54);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (102,'nourri',54);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (103,'Outil',56);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (104,'Sécu',56);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (105,'Travaux',56);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (106,'Serre',57);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (107,'Abri',57);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (108,'Plante',57);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (109,'Tronçonneuse',58);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (110,'Nettoyeur',58);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (111,'pelle',58);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (112,'chien',59);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (113,'chat',59);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (114,'poisson',59);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (115,'vélo',61);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (116,'running',61);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (117,'muscu',61);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (118,'montre',62);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (119,'bracelet',62);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (120,'fit',62);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (121,'running',63);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (122,'course',63);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (123,'tennis',63);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (124,'jogging',64);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (125,'t-shirt',64);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (126,'dossard',64);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (127,'robe',66);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (128,'jupe',66);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (129,'chemisier',66);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (130,'jean',67);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (131,'boxer',67);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (132,'veste',67);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (133,'maquillage',68);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (134,'gemey',68);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (135,'levre',68);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (136,'montre',69);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (137,'bijoux',69);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (138,'bague',69);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (139,'bébé',71);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (140,'éveil',71);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (141,'biberon',71);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (142,'lego',72);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (143,'jeu',72);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (144,'société',72);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (145,'maquette',73);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (146,'drone',73);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (147,'miniature',73);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (148,'ballon',74);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (149,'raquette',74);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (150,'trampoline',74);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (151,'siège',76);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (152,'retro',76);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (153,'volant',76);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (154,'huile',77);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (155,'moteur',77);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (156,'lave',77);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (157,'jante',78);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (158,'michelin',78);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (159,'amortisseur',78);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (160,'jacki',79);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (161,'nord',79);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (162,'sticker',79);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (163,'casque',80);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (164,'moto',80);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (165,'pilote',80);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (166,'numismatique',82);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (167,'philatélie',82);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (168,'pièce',82);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (169,'tableau',83);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (170,'gravure',83);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (171,'peinture',83);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (172,'France',84);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (173,'maroc',84);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (174,'état',84);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (175,'figurine',85);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (176,'carte',85);
INSERT INTO `tag` (`id_tag`, `intitule`, `categorie_id`) VALUES (177,'pins',85);

/*============================*/
/*		TABLE MESSAGE		  */
/*============================*/

INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (1,'2017-04-15 00:00:00',1,'PdDSf dsqlkfhkldhf d;qksfjhfksdf',6,11,5);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (2,'2017-04-15 02:00:00',0,'sdqfq dslkfhjldj dsflkhdksf qsldkhfdsq ',6,11,5);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (3,'2017-04-24 13:00:00',1,'Salut',11,17,12);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (4,'2017-04-24 13:10:00',1,'Salut',12,17,11);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (5,'2017-04-24 13:15:00',1,'Cava',11,17,12);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (6,'2017-04-24 13:20:00',1,'oui et toi',12,17,11);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (7,'2017-04-24 13:25:00',1,'bien et toi?',11,17,12);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (8,'2017-04-24 13:30:00',0,'Lobjet…',12,17,11);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (9,'2017-04-24 13:00:00',1,'Lobjet est il dispo ?',16,22,13);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (10,'2017-04-24 13:10:00',0,'Oui bien sur il est disponible à lechange',13,22,16);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (11,'2017-04-24 13:00:00',1,'Bonjour comment ca va ?',16,37,18);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (12,'2017-04-24 13:10:00',1,'yep toujours ok pour la piscine?',18,37,16);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (13,'2017-04-24 13:15:00',0,'oui!! Demain à 13h!',16,37,18);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (14,'2017-04-24 13:00:00',1,'Salut morue',16,25,14);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (15,'2017-04-24 13:10:00',1,'Tu réponds?',16,25,14);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (16,'2017-04-24 13:15:00',1,'non',14,25,16);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (17,'2017-04-24 13:20:00',0,'Ok',16,25,14);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (18,'2017-04-24 13:00:00',1,'Bonjour pourriez me donner plus de précision sur lobjet ?',15,12,10);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (19,'2017-04-24 13:10:00',1,'Bonsoir avez-vous bien recu mon message?',15,12,10);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (20,'2017-04-24 13:15:00',1,'Oui dsl jetais en vacance. Lobjet est cassé!',10,12,15);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (21,'2017-04-24 13:20:00',1,'je vais vous faire une proposition',15,12,10);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (22,'2017-04-24 13:25:00',1,'Ok',10,12,15);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (23,'2017-04-24 13:30:00',1,'Jattend toujours',10,12,15);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (24,'2017-04-24 13:00:00',1,'Salut cava ma belle?',17,28,15);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (25,'2017-04-24 13:10:00',1,'Désolé je suis un homme ! Mon mignon',15,28,17);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (26,'2017-04-24 13:00:00',1,'Bonjour, jaurais voullu avoir plus de précision sur lobjet ….',13,10,2);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (27,'2017-04-24 13:10:00',1,'Biensur, alors il a ces caractèristiques et cettehistoire!',2,10,13);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (28,'2017-04-24 13:15:00',1,'euh! Ok je vais réflechir',13,10,2);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (29,'2017-04-24 13:20:00',1,'Alors?',2,10,13);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (30,'2017-04-24 13:25:00',1,'Alors? Vous le voulez?',2,10,13);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (31,'2017-04-24 13:30:00',1,'OUI!!! Je vous soumets une proposition!',13,10,2);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (32,'2017-04-24 13:35:00',0,'Ok jattends!',2,10,13);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (33,'2017-04-24 13:00:00',1,'Je suis au max!',10,5,6);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (34,'2017-04-24 13:10:00',1,'Ok jattends!',6,5,10);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (35,'2017-04-24 13:15:00',1,'Kamoulox',10,5,6);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (36,'2017-04-24 13:20:00',1,'Scrabble',6,5,10);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (37,'2017-04-24 13:25:00',1,'Poulet',10,5,6);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (38,'2017-04-24 13:30:00',1,'Cailloux',6,5,10);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (39,'2017-04-08',0,'Test pour aubin',1,45,5);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (40,'2017-04-09',0,'Test5 pour aubin',10,46,5);
INSERT INTO `message` (`id_message`, `date_envoi`, `lu`, `texte`, `membre_id_emetteur`, `proposition_id`, `membre_id_recepteur`) VALUES (41,'2017-04-10',0,'Test6 pour aubin',5,46,10);

/*============================*/
/*		TABLE LOCALISATION	  */
/*============================*/

INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (1,'34 rue de picpus',75012,'paris',2.39535,48.8452,1,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (2,'92 avenue du général michel bizot',75012,'paris',2.40387,48.8375,2,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (3,'9 Boulevard du Général de Gaulle',92120,'Montrouge',2.32717,48.8164,3,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (4,'1 rue d Alésia',75014,'Paris',2.34114,48.8264,4,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (5,'3 rue de la pomme',31000,'Toulouse',1.44703,43.6019,5,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (6,'4 rue des messageries',75010,'Paris',2.35083,48.8762,5,'Travail');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (7,'5 rue Monge',75005,'Paris',2.34968,48.8494,6,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (8,'50 boulevard du minervois',11700,'Pepieux',2.68208,43.2969,6,'Travail');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (9,'3 avenue verdier',92120,'Montrouge',2.32027,48.8144,7,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (10,'15 rue pasteur',73200,'albertville',6.38809,45.6697,7,'Travail');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (11,'5 rue de la paix',75002,'Paris',2.33122,48.8696,8,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (12,'3 boulevard du roi',78000,'Versailles',2.12515,48.8103,9,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (13,'Palais du louvre',75001,'Paris',2.33856,48.8604,9,'Travail');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (14,'67 boulevard de la reine',78000,'Versailles',2.1308,48.8097,10,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (15,'25 Avenue Danielle casanova',94200,'Ivry-sur-seine',2.38165,48.8175,11,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (16,'12 Allée Sonia Delaunay',94800,'VilleJuif',2.347641,48.788771,12,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (17,'65 Quai du Rancy',94380,'Bonneuil-sur-Marne',2.48085,48.779723,12,'Travail');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (18,'16 Rue Montbauron',78000,'Versailles',2.136154,48.80415,13,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (19,'49 Boulevard Pasteur',93120,'La Courneuve',2.383347,48.922499,14,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (20,'62 Rue Ernest Savart',93100,'Montreuil',2.439651,48.868328 ,14,'Travail');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (21,'120 Avenue Pablo Picasso',92000,'Nanterre',2.225418,48.888198,15,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (22,'13 Rue Petitpas',28100,'Dreux',1.365738,48.731738,16,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (23,'20 Rue de la Baume',75008,'Paris',2.313137,48.874425,16,'Travail');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (24,'91 Rue Championnet',75018,'Paris',2.342362,48.895534,17,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (25,'68 Boulevard de Clichy',75018,'Paris',2.33403,48.883683,17,'Travail');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (26,'35 bis Rue du Borrégo',75020,'Paris',2.40107,48.873296,18,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (27,'63 Boulevard Richard Lenoir',75011,'Paris',2.372231,48.860085,19,'Adresse Principale');
INSERT INTO `localisation` (`id_localisation`, `adresse`, `code_postal`, `ville`, `longitude`, `latitude`, `membre_id`, `titre_adresse`) VALUES (28,'44 Rue Frémicourt',75015,'Paris',2.301335,48.84783 ,20,'Adresse Principale');



/*============================*/
/*		TABLE LISTE			  */
/*============================*/

INSERT INTO `liste` (`id_liste`, `titre_liste`, `date_creation`, `date_valid`, `membre_id`) VALUES (1,'Mamam','2017-04-15 00:00:00',NULL,7);
INSERT INTO `liste` (`id_liste`, `titre_liste`, `date_creation`, `date_valid`, `membre_id`) VALUES (2,'Papa','2017-04-15 00:00:00',NULL,5);
INSERT INTO `liste` (`id_liste`, `titre_liste`, `date_creation`, `date_valid`, `membre_id`) VALUES (3,'maison','2017-04-15 00:00:00',NULL,5);
INSERT INTO `liste` (`id_liste`, `titre_liste`, `date_creation`, `date_valid`, `membre_id`) VALUES (4,'Pourquoi pas','2017-04-15 00:00:00',NULL,6);
INSERT INTO `liste` (`id_liste`, `titre_liste`, `date_creation`, `date_valid`, `membre_id`) VALUES (5,'Maison Campagne','2017-04-15 00:00:00',NULL,11);
INSERT INTO `liste` (`id_liste`, `titre_liste`, `date_creation`, `date_valid`, `membre_id`) VALUES (6,'fils','2017-04-15 00:00:00',NULL,12);
INSERT INTO `liste` (`id_liste`, `titre_liste`, `date_creation`, `date_valid`, `membre_id`) VALUES (7,'fille','2017-04-15 00:00:00',NULL,12);


/*============================*/
/*		TABLE ENVIE			  */
/*============================*/

INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (1,NULL,1,2,10,17,'Mug pika');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (2,NULL,1,NULL,NULL,NULL,'Canard');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (3,25,2,NULL,8,50,'Mug');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (4,25,3,NULL,10,NULL,'velo');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (5,25,3,NULL,NULL,NULL,'casque');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (6,25,4,NULL,NULL,NULL,'Cheval');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (7,25,5,NULL,NULL,NULL,'cable');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (8,25,5,NULL,NULL,NULL,'Bouteille');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (9,25,6,NULL,NULL,NULL,'Guitare');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (10,25,7,NULL,NULL,NULL,'ordinateur');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (11,25,7,NULL,NULL,NULL,'poupee');
INSERT INTO `envie` (`id_envie`, `distance`, `liste_id`, `valeur_id`, `categorie_id`, `sous_categorie_id`, `intitule`) VALUES (12,25,7,NULL,12,NULL,'lego');

/*============================*/
/*		TABLE FAVORI		  */
/*============================*/

INSERT INTO `favori` (`membre_id`, `proposition_id`) VALUES (5,1);
INSERT INTO `favori` (`membre_id`, `proposition_id`) VALUES (8,6);
INSERT INTO `favori` (`membre_id`, `proposition_id`) VALUES (9,5);
INSERT INTO `favori` (`membre_id`, `proposition_id`) VALUES (11,1);
INSERT INTO `favori` (`membre_id`, `proposition_id`) VALUES (11,6);

/*============================*/
/*		TABLE ECHANGE	      */
/*============================*/

INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (1,'1','2017-04-15 00:00:00','2017-04-15 00:00:00','2017-04-16 00:00:00','2017-04-17 00:00:00','Attente comblée',5,'Bon contact',4,4562,3,4,10,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (2,'2','2017-04-02 00:00:00','2017-04-03 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,5,12,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (3,'3','2017-04-01 00:00:00','2017-04-02 00:00:00','2017-04-03 00:00:00',NULL,NULL,NULL,NULL,NULL,NULL,2,5,18,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (4,4,'2017-04-01','2017-04-02',NULL,'2017-04-03','Tres bon contact',4,'Parfait',3,1235,3,12,37,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (5,5,'2017-04-02','2017-04-03',NULL,'2017-04-04','A l écoute',4,'Un plaisir',5,4895,2,13,17,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (6,6,'2017-04-03','2017-04-04',NULL,'2017-04-05','Très réactif',4,'Vive vous!',4,1656,1,14,30,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (7,7,'2017-04-04','2017-04-05',NULL,'2017-04-06','Super!!',4,'A refaire',3,3213,5,15,43,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (8,8,'2017-04-05','2017-04-06',NULL,'2017-04-07','Trop bien',4,'Chouette',5,7945,1,16,20,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (9,9,'2017-04-06','2017-04-07',NULL,'2017-04-08','Très mignon',4,'Grogon',4,3546,1,17,32,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (10,10,'2017-04-06','2017-04-07',NULL,'2017-04-08','Très mignon',4,'Grogon',4,3541,1,5,28,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (11,11,'2017-04-06',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,5,43,'2017-04-7');
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (12,12,'2017-04-06','2017-04-10',NULL,'2017-04-11','yeah',4,'youhhou',4,1454,4,1,44,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (13,13,'2017-04-06','2017-04-07','2017-04-08',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,45,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (14,14,'2017-04-06','2017-04-07',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,46,NULL);
INSERT INTO `echange` (`id_echange`, `reference_echange`, `date_init`, `date_acceptation`, `date_refus`, `date_validation`, `comm_chercheur`, `note_chercheur`, `comm_donneur`, `note_donneur`, `code_echange`, `prix`, `membre_id`, `proposition_id`, `date_annul`) VALUES (15,15,'2017-05-06','2017-05-07',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,47,'2017-05-8');
 
/*============================*/
/*		TABLE RDV			  */
/*============================*/

INSERT INTO `rdv` (`id_rdv`, `date_annulation`, `commentaire`, `date_rdv`, `lieu`, `echange_id`) VALUES (1, NULL, 'Cela vous va?', '2017-05-8', 'Paris', 12);
INSERT INTO `rdv` (`id_rdv`, `date_annulation`, `commentaire`, `date_rdv`, `lieu`, `echange_id`) VALUES (2, NULL, 'Cela vous va?', '2017-03-16', 'Paris', 5);
INSERT INTO `rdv` (`id_rdv`, `date_annulation`, `commentaire`, `date_rdv`, `lieu`, `echange_id`) VALUES (3, NULL, 'Cela vous va?', '2017-03-11', 'Paris', 6);

/*============================*/
/*		TABLE Photos		  */
/*============================*/

INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (1,'img/imgProposition/pot.jpg',1);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (2,'img/imgProposition/truc.jpg',2);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (3,'img/imgProposition/bidule1.jpg',3);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (4,'img/imgProposition/chaussure.jpg',5);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (5,'img/imgProposition/chaton.jpg',6);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (6,'img/imgProposition/rummikub.jpg',7);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (7,'img/imgProposition/canard.jpg',8);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (8,'img/imgProposition/velo01.jpg',9);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (9,'img/imgProposition/velo02.jpg',9);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (10,'img/imgProposition/velo03.jpg',9);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (11,'img/imgProposition/asus01.jpg',10);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (12,'img/imgProposition/asus02.jpg',10);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (13,'img/imgProposition/asus03.jpg',10);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (14,'img/imgProposition/bol01.jpg',11);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (15,'img/imgProposition/bol02.jpg',11);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (16,'img/imgProposition/hermine.jpg',12);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (17,'img/imgProposition/cadenas.jpg',13);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (18,'img/imgProposition/peluche.jpg',14);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (19,'img/imgProposition/ballon.jpg',15);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (20,'img/imgProposition/timbres.jpg',16);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (21,'img/imgProposition/casserole.jpg',17);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (22,'img/imgProposition/velo04.jpg',18);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (23,'img/imgProposition/roueVelo.jpg',19);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (24,'img/imgProposition/trottinette.jpg',20);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (25,'img/imgProposition/casque.jpg',21);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (26,'img/imgProposition/poupee.jpg',22);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (27,'img/imgProposition/bougie.jpg',23);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (28,'img/imgProposition/lego.jpg',24);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (29,'img/imgProposition/peluche2.jpg',25);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (30,'img/imgProposition/verre.jpg',26);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (31,'img/imgProposition/osier.jpg',27);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (32,'img/imgProposition/gant.jpg',28);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (33,'img/imgProposition/portebebe.jpg',29);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (34,'img/imgProposition/cable.jpg',30);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (35,'img/imgProposition/ecran.jpg',31);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (36,'img/imgProposition/manche.jpg',32);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (37,'img/imgProposition/rateau.jpg',33);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (38,'img/imgProposition/mug.jpg',34);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (39,'img/imgProposition/parapluie.jpg',35);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (40,'img/imgProposition/collectionTimbre.jpg',36);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (41,'img/imgProposition/livre.jpg',37);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (42,'img/imgProposition/cd.jpg',38);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (43,'img/imgProposition/vinyl.jpg',39);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (44,'img/imgProposition/vhs.jpg',40);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (45,'img/imgProposition/pomme.jpg',41);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (46,'img/imgProposition/marteau.jpg',42);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (47,'img/imgProposition/faucille.jpg',43);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (48,'img/imgProposition/bidule2.jpg',3);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (49,'img/imgProposition/bidule3.jpg',3);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (50,'img/imgProposition/faucille.jpg',44);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (51,'img/imgProposition/faucille.jpg',45);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (52,'img/imgProposition/faucille.jpg',46);
INSERT INTO `photo` (`id_photo`, `url`, `proposition_id`) VALUES (53,'img/imgProposition/faucille.jpg',47);

/*============================*/
/*		TABLE LOCALISER       */
/*============================*/



INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (1,1);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (1,2);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (2,3);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (7,5);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (8,5);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (7,6);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (8,6);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (5,7);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (6,7);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (4,8);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (9,9);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (10,9);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (2,10);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (5,11);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (14,12);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (12,13);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (2,14);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (14,15);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (11,16);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (16,17);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (17,17);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (16,18);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (17,19);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (16,20);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (17,20);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (16,21);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (17,21);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (18,22);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (18,23);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (18,24);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (19,25);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (20,25);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (19,25);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (20,25);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (19,26);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (20,27);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (21,28);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (21,29);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (21,30);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (22,31);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (23,31);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (22,32);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (23,32);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (22,33);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (23,33);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (24,34);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (25,34);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (24,35);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (25,35);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (24,36);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (25,36);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (26,37);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (26,38);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (26,39);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (27,40);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (27,41);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (27,42);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (28,43);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (5,44);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (5,45);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (5,46);
INSERT INTO `localiser` (`localisation_id`, `proposition_id`) VALUES (5,47);

/*============================*/
/*		TABLE DEPARTEMENT       */
/*============================*/

INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (1,'Ain','1');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (2,'Aisne','2');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (3,'Allier','3');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (4,'Alpes de Hautes-Provence','4');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (5,'Hautes-Alpes','5');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (6,'Alpes-Maritimes','6');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (7,'Ardèche','7');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (8,'Ardennes','8');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (9,'Ariège','9');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (10,'Aube','10');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (11,'Aude','11');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (12,'Aveyron','12');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (13,'Bouches-du-Rhône','13');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (14,'Calvados','14');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (15,'Cantal','15');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (16,'Charente','16');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (17,'Charente-Maritime','17');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (18,'Cher','18');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (19,'Corrèze','19');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (20,'Corse-du-Sud','2A');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (21,'Haute-Corse','2B');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (22,'Côte-d''Or','21');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (23,'Côtes d''Armor','22');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (24,'Creuse','23');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (25,'Dordogne','24');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (26,'Doubs','25');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (27,'Drôme','26');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (28,'Eure','27');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (29,'Eure-et-Loir','28');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (30,'Finistère','29');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (31,'Gard','30');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (32,'Haute-Garonne','31');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (33,'Gers','32');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (34,'Gironde','33');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (35,'Hérault','34');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (36,'Ille-et-Vilaine','35');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (37,'Indre','36');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (38,'Indre-et-Loire','37');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (39,'Isère','38');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (40,'Jura','39');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (41,'Landes','40');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (42,'Loir-et-Cher','41');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (43,'Loire','42');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (44,'Haute-Loire','43');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (45,'Loire-Atlantique','44');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (46,'Loiret','45');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (47,'Lot','46');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (48,'Lot-et-Garonne','47');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (49,'Lozère','48');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (50,'Maine-et-Loire','49');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (51,'Manche','50');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (52,'Marne','51');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (53,'Haute-Marne','52');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (54,'Mayenne','53');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (55,'Meurthe-et-Moselle','54');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (56,'Meuse','55');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (57,'Morbihan','56');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (58,'Moselle','57');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (59,'Nièvre','58');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (60,'Nord','59');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (61,'Oise','60');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (62,'Orne','61');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (63,'Pas-de-Calais','62');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (64,'Puy-de-Dôme','63');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (65,'Pyrénées-Atlantiques','64');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (66,'Hautes-Pyrénées','65');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (67,'Pyrénées-Orientales','66');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (68,'Bas-Rhin','67');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (69,'Haut-Rhin','68');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (70,'Rhône','69');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (71,'Haute-Saône','70');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (72,'Saône-et-Loire','71');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (73,'Sarthe','72');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (74,'Savoie','73');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (75,'Haute-Savoie','74');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (76,'Paris','75');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (77,'Seine-Maritime','76');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (78,'Seine-et-Marne','77');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (79,'Yvelines','78');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (80,'Deux-Sèvres','79');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (81,'Somme','80');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (82,'Tarn','81');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (83,'Tarn-et-Garonne','82');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (84,'Var','83');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (85,'Vaucluse','84');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (86,'Vendée','85');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (87,'Vienne','86');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (88,'Haute-Vienne','87');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (89,'Vosges','88');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (90,'Yonne','89');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (91,'Territoire-de-Belfort','90');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (92,'Essonne','91');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (93,'Hauts-de-Seine','92');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (94,'Seine-Saint-Denis','93');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (95,'Val-de-Marne','94');
INSERT INTO`departement` (`id_deptartement`, `nom_departement`, `num_departement`) VALUES (96,'Val-d''Oise','95');

