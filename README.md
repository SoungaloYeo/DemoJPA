#****************************** J P A ****************************************
JPA est une spécification JAVA qui définit un ensemble de règles permettant 
la gestion de la correspondance entre nos objets Java et notre base de données

cette demo donne un apreçu sur l'implementation de JPA dans vos projet JAVA en
utilisant Hibernate.

Il s'agit en fait d'un CRUD avec des classes DAO(ClasseDAO, SpeakerDAO, TailleDAO)
 developpé pour chaque classe concrete à fin de faciliter la comprehension.
Pour ceux qui comprenne mieux la géneracité j'y ais mis une classe DAO générique pour
vous il vous suffirat de supprimer les contenus de toutes les autres classeDAO ensuit 
de les faire hériter de la classe DAO en question.
vous pourrier aussi ajouter vos classes de Service en fonction de votre logic metier
ou meme ajouter de nouvelle methodes spécifiques pour des traitement donnés

#*************************************************
Info demo à realiser :
1-Type de projet _ _ _ _ _ _ _ _ _ _ _: java SE
2-Gestion des depandences_ _ _ _ _:projet Maven
2-fonctionnalitées à mettre en place : réaliser un CRUD
3-IDE: NetBeans 8.2 (developpement version)
4-type de base de donnée: MySql

ci nous avons les cas suivant  :
 Un « Theme » est presenté par un « Speaker » 
 Un « Speaker » ne passe que dans une « Salle » 
 Pour une « Salle » donné passe plusieurs « Speaker »
d’ou les relations 
-OneToOne unidirectionnelle
-OneToMany bidirectionnelle

Il faut noter que d’autre type de relation existent t-elle que :
-OneToOne bidirectionnelle
-OneToMany unidirectionnelle
-ManyToMany bidirectionnelle

PRECEDURE DE REALISATION
ici le nom de la base de donnee "demoE" est précisé dans le fichier persistence.xml dans le repertoire
ressources. vous pouvez le modifier mais assurez-vous de crer d'abort la BD avant toute execution
