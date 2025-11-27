Le projet présent projet est un projet de CRUD si,ple effectué pour le test d'embauche à l'UEA:
Auteur: MWIKIZA CISIRIKA Alain
Fonctionnalités effectuées: Simple RESTFull pour le CRUD
Technologie: Spring Boot (Java)

Guide pour utiliser le projet les configurations suivantes:

    spring.datasource.url=jdbc:mysql://localhost:3306/uea-test
    spring.datasource.username=root
    server.port=9090
    spring.datasource.password=password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

Le port 9090 c'est puisque le port 8080 est utlisé par un autre service (Probablement Apache)
j'ai opté pour un simple repository pattern pour la simple raison que je n'ai pas eu assez de logiques métiers à encapsuler dans la
un classe Service(Actions ou Commandes selon les appréciations).

Le projet est juste une API REST Sans frontend faute du temps de tout implémenter

pour tester les APIs nous avons utilisé BRUNO qui est un client htpp simple et souple surtout sur notre envireonnement (Ubuntu 24)

Lien vers le fichier Docker simple

    /home/alaincis/IdeaProjects/UEA/src/main/resources/Dockerfile


Questions pour la base de données:
Liste des étudiants inscrits à un cours :

    SELECT * FROM Etudiant E JOIN cours_etudiants EC ON E.etudiants_id = EC.etudiants_id JOIN Cours C ON EC.cours_id = C.cours_id
    WHERE C.nom = 'EOE';
Liste de cours sans etudiants :

    SELECT C.cours_id, C.nom FROM cours AS C LEFT JOIN cours_etudiants AS CE ON C.cours_id = CE.cours_id  WHERE CE.cours_id IS NULL;

> Note:
> Nous n'avons pas atteints tous les requirements de l'evations faute du temps et ne pas pushé un code avec des bugs vu le temps qui file.