# Compte rendu du TP2 de Java

*Par Martial Fousset*

Tout le code est dans le [repository Github](https://github.com/Pumchh/TP2_Java).

## Ce n'est pas une chaussette

J'ai eu quelques difficulté à comprendre comment faire au début parce que les explications du sujet et le cours ne sont
pas vraiment claires. Mais en cherchant sur internet, avec l'aide des IA, de M. Chassel et de mes camarades,
j'ai réussi à comprendre et réaliser cette partie.

Une fois la partie compréhension passée, j'ai pu réaliser la suite du TP avec moins de difficultés.

Nous pouvons observer la forme des requêtes HTTP comme suit :

    HTTP/1.1 200 OK
    Content-Length: 26
    Content-Type: text/html; charset=utf-8


## Réorganisation

J'ai codé toutes les classes demandées en essayant de comprendre le fonctionnement et l'utilité de chacune
d'entre elles.
Globalement, je n'ai pas eu de grande difficulté, je suis juste resté bloqué sur la forme des envois de requêtes
dans lesquels il faut faire attention aux retours à la ligne (\n) pour que le serveur puisse les lire correctement.

## Un peu de contenu

Il a fallût ajouter une méthode sendContent dans la classe HttpResonse.
Nous pouvons maintenant envoyer du contenu dans les requêtes HTTP.
En utilisant "text/plain" comme type de contenu, nous pouvons envoyer du texte brut, en utilisant "text/html" nous
pouvons envoyer du code HTML.

Ensuite, il a fallût ajouter une méthode sendFile dans la classe HttpResponse. Cette méthode permet d'envoyer un fichier.
Nous traitons les fichiers envoyés comme des fichiers binaires.

J'ai réussi à envoyer un fichier HTML (index.html fait au TD de DevWeb) mais n'ai pas réussi à faire en sorte d'afficher
les images et vidéos du fichier HTML ni d'appliquer la mise en forme CSS. J'ai passé plusieurs heures à essayer de
déboguer mon code mais n'ai pas réussi à trouver la solution, donc j'ai abandonné.

## La fin du "Chacun son tour"

J'ai modifié mon code pour qu'il puisse gérer plusieurs requêtes en même temps. J'ai utilisé un thread pour chaque
requête.


## Conclusion

Il m'a fallût un peu de temps pour comprendre le fonctionnement de ce qu'on a vu. J'ai passé plusieurs heures à
essayer de déboguer mon code pour afficher les images et vidéos du fichier HTML mais n'ai pas réussi (je suis certain
que c'est quelque chose de bête). Je pense qu'avec un cours plus clair et au moins une séance de TP en plus avec un
prof pour expliquer les différents points, cela aurait été plus simple.





