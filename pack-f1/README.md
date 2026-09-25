# Projet transversal F1 — Python → Java → JavaScript

Pack complet : énoncé, données, squelettes, tests, extensions et corrigés.

```
ENONCE.md                    l'énoncé étudiant (à lire en premier)
donnees/resultats.csv        l'export brut du championnat
01-python/ingestion.ipynb    maillon 1 — à compléter
Convertit un temps au format "1:33.996" en nombre de secondes . Découpe : multiplie les minutes par 60 ajoute les secondes et arrondit à 3 décimales Renvoie None si le texte est vide.

2 ignore l'en tete, et renvoie une liste de dictionnaires contenant pour chaque ligne la course, le pilote, l'écurie, la position (0 si abandon) et le temps converti en secondes None si absent.

3 écrit un fichier CSV avec un en-tête, puis chaque ligne du classement dans l'ordre reçu, en séparant les champs par des points-virgules et en formatant le temps à 3 décimales (ou vide si absent)

02-java/src/                 maillon 2 — Classement.java à compléter
1 
On parcourt chaque ligne et on cumule dans un dictionnaire les points victoires et 2e places pour chaque pilote.
On transforme ce dictionnaire en liste pour pouvoir la trier
On trie la liste par points décroissants, puis victoires, puis 2e places, puis nom alphabétique


2 On parcourt chaque course pour accumuler dans un dictionnaire les points victoires et 2e places de chaque pilote
On convertit ce dictionnaire en liste pour pouvoir la trier
On trie la liste par points, puis victoires, puis 2e places, puis nom a => z

3.On parcourt chaque pilote et on cumule dans une HashMap les points, victoires et 2e places de son écurie
On convertit la HashMap en ArrayList pour pouvoir la trier
On trie avec les mêmes critères que le classement pilotes 

4.On parcourt chaque course du pilote et on additionne ses positions en ignorant les abandons
On compte combien de courses terminées il a pour calculer la moyenne
On renvoie la moyenne arrondie à 2 décimales ou 0 s'il n'a jamais terminé

03-js/                       maillon 3 — app.js à compléter, index.html à ouvrir
secours/                     résultats de référence, en cas de blocage
extensions/E1 à E4           les extensions et leurs tests
formateur/                   corrigés, grille, générateur — À RETIRER avant distribution
```

Prérequis : Python 3 avec Jupyter, un JDK (`javac -version`), un navigateur.
