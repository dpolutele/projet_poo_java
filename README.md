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
- 📃 Affichage :
  - Tous les documents,
  - Documents empruntés,
  - Documents disponibles.
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

1. Assurez-vous d’avoir les dossiers suivants dans le projet :

   projet_poo_java_POLUTELE_DYLAN/  
   ├── bin/  
   └── src/  
       └── mediatheque/  
           ├── model/  
           └── ui/  

2. Ouvrir votre IDE (Eclipse, IntelliJ IDEA, NetBeans, VS code...).
3. Ouvrir le dossier `projet_poo_java_POLUTELE_DYLAN`.
4. Vérifier votre version de Java (à jour et bien configuré).
5. Ouvrer un nouveau terminal au niveau du projet :
# Compiler tous les fichiers .java du dossier src et sous-dossiers dans le dossier bin avec :
javac -d bin (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object { $_.FullName })

# Se placer dans le dossier bin (dossier racine des classes compilées) : 
cd bin

# Lancer l’application en précisant le package complet et la classe Main : 
java mediatheque.ui.Main


# Vous pouvez également lancer l'application avec le `Run` mais assurez vous d'avoir bien compiler les fichiers.


🗂 Arborescence du projet :

projet_poo_java_POLUTELE_DYLAN/  
├── bin/                           → fichiers compilés (.class)  
└── src/  
    └── mediatheque/  
        ├── model/                → classes métier : Document, Livre, CD, DVD, Utilisateur, etc.  
        └── ui/  
            └── Main.java         → interface graphique principale  

# 👤Auteur :  
# POLUTELE Dylan  
# Université de la Nouvelle-Calédonie (UNC)  



