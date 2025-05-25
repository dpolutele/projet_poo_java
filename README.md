# Projet Java - Médiathèque  
# UNC 2025 - POLUTELE Dylan

🎯 Ce projet Java a été réalisé dans le cadre de la pratique des concepts de la Programmation Orientée Objet (POO), incluant :
- Héritage, encapsulation, abstraction,
- Gestion des exceptions 
- Manipulation de collections,
- Utilisation d’une interface graphique simple (Swing).

📚 L'application simule une médiathèque qui propose différents supports culturels (livres, CD, DVD) que les utilisateurs peuvent consulter ou emprunter. L'interface permet la gestion de ces supports via un menu interactif avec des boutons.

🔧 Fonctionnalités principales :
- 🆕 Ajout initial de documents (dans le main).
- 📃 Affichage : Tous les documents, Documents empruntés, Documents disponibles.
- 🔎 Recherche de documents par titre.
- 🧩 Filtrage par type de support (Livre, CD, DVD).
- 🙋‍♂️ Gestion des emprunts par utilisateur (saisie nom & prénom).
- 🖥 Interface utilisateur simple avec Java Swing.

🛠 Technologies utilisées :
- Java 21.0.5
- Java Swing
- Collections (List, ArrayList)
- POO (classes abstraites, héritage, interfaces)
- Architecture en packages

🚀 Lancer le projet :

1. Clonez le dépôt depuis GitHub :

```bash/powershell```

git clone https://github.com/dpolutele/projet_poo_java.git
cd projet_poo_java

2. Assurez-vous que le fichier JAR exécutable est présent dans le dépôt (mediatheque.jar).

3. Lancez l’application via le fichier JAR :

java -jar mediatheque.jar

Astuce :
Vous pouvez aussi lancer l'application directement dans votre IDE (Eclipse, IntelliJ IDEA, NetBeans, VS Code...) en ouvrant le dossier du projet et en exécutant la classe mediatheque.ui.Main (en lancant le RUN), assurez-vous également d'avoir une version de Java à jour et bien configuré (JAVA 16 ou +).


## Arborescence du projet : 

projet_poo_java/  
├── bin/                           → fichiers compilés (.class)  
├── javadoc/                       → documentation générée (Javadoc)  
├── src/  
│   └── mediatheque/  
│       ├── model/                → classes métier : Document, Livre, CD, DVD, Utilisateur, exceptions, etc.  
│       └── ui/  
│           └── Main.java         → interface graphique principale  
├── mediatheque.jar           → fichier exécutable JAR  
└── rapport.pdf                   → rapport du projet



👤 Auteur :
POLUTELE Dylan
Licencec MIAGE - 2025 