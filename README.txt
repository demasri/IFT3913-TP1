# IFT3913-TP1

UTILISATION DU LOGICIEL:
- Copier un projet Java dans le folder.
- Aller dans src/.
- Sur terminal, faire:

javac CodeAnalyzer.java 
java CodeAnalyzer <chemin absolu du folder contenant le projet Java>

- Pour les resultats, aller dans src/CSV.


FONCTIONNEMENT INTERNE:

- La structure interne et le pseudo-code se trouvent dans 'project structure'.
Le code est separe en 3 classes qui ont chacune une fonction precise:

- CodeAnalyzer: lors de l'initialisation, la classe enregistre via ses attributs le contenu des files du projet Java a analyser, c'est-à-dire toutes les classes et les methodes incluses a l'interieur.
Elle contient toutes les methodes pour calculer les metriques (classe_LOC, ..) et sert d'intermediaire pour creer les fichiers .csv.

- FileManager: cette classe intervient lors de l'initialisation du programme. Elle s'occupe de traverser les fichiers pour recuperer tous les '.java' et leur contenu.
Elle envoie les informations necessaires a la classe CodeAnalyzer qui enregistre toutes les donnees.

- CSVManager: cette classe sert a creer / updater les fichiers .csv.
La classe CodeAnalyzer lui envoie toutes les lignes a ecrire deja formattees et la classe s'occupe de les ecrire dans les fichiers .csv.
