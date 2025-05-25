package mediatheque.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import mediatheque.model.*;

/**
 * Fenêtre principale de l'application.
 * Permet d'afficher, filtrer et emprunter des documents via une interface graphique.
 */
public class Main extends JFrame {
    private List<Document> supports = new ArrayList<>();
    private JTextArea affichage;

    /**
     * Constructeur de la fenêtre principale.
     * Initialise l'interface et charge les documents (livres, CDs, DVDs).
     */
    public Main() {
        setTitle("Médiathèque");
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Création des documents
        supports.add(new Livre("1984", "George Clowney", 1949));
        supports.add(new Livre("Le Petit Prince", "Aymeric Boutin", 1943));
        supports.add(new Livre("La Guerre des Boutins", "Mathieu Galois", 2024));
        supports.add(new Livre("Marsupilamine", "Lionnel Messi", 1949));
        supports.add(new CD("Thriller", "Michael Jackson", 1982));
        supports.add(new CD("Moonwalk", "Michael Jackson", 1982));
        supports.add(new CD("BeeGees", "Stay Alive", 1982));
        supports.add(new CD("One Love", "Bob Marley", 1982));
        supports.add(new DVD("Harry Potter I", "Christopher Oconor", 2010));
        supports.add(new DVD("Harry Potter II", "Christopher Oconor", 2011));
        supports.add(new DVD("Harry Potter III", "Christopher Oconor", 2012));
        supports.add(new DVD("Harry Potter IV", "Christopher Oconor", 2013));

        // Zone d'affichage
        affichage = new JTextArea();
        affichage.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(affichage);
        add(scrollPane, BorderLayout.CENTER);

        // Barre de boutons
        JPanel boutons = new JPanel(new FlowLayout());

        // Ajout des boutons avec actions
        ajouterBouton(boutons, "Nouvel emprunt", e -> nouvelEmprunt());
        ajouterBouton(boutons, "Afficher tous", e -> afficher(supports));
        ajouterBouton(boutons, "Afficher empruntés", e -> {
            List<Document> empruntes = supports.stream().filter(Document::estEmprunte).toList();
            afficher(empruntes);
        });
        ajouterBouton(boutons, "Afficher disponibles", e -> {
            List<Document> dispo = supports.stream().filter(d -> !d.estEmprunte()).toList();
            afficher(dispo);
        });
        ajouterBouton(boutons, "Filtrer par type", e -> filtrerParType());
        ajouterBouton(boutons, "Rechercher titre", e -> rechercherParTitre());

        add(boutons, BorderLayout.SOUTH);
    }

    /**
     * Ajoute un bouton à un panneau avec un texte et une action à effectuer.
     *
     * @param panel Le panneau sur lequel ajouter le bouton.
     * @param label Le texte du bouton.
     * @param action L'action à effectuer lorsqu'on clique.
     */
    private void ajouterBouton(JPanel panel, String label, ActionListener action) {
        JButton bouton = new JButton(label);
        bouton.addActionListener(action);
        panel.add(bouton);
    }

    /**
     * Permet à un utilisateur de saisir ses informations et d'emprunter un document.
     */
    private void nouvelEmprunt() {
        JTextField champNom = new JTextField();
        JTextField champPrenom = new JTextField();
        Object[] message = {"Nom:", champNom, "Prénom:", champPrenom};

        int option = JOptionPane.showConfirmDialog(this, message, "Informations Utilisateur", JOptionPane.OK_CANCEL_OPTION);
        if (option != JOptionPane.OK_OPTION) return;

        String nom = champNom.getText().trim();
        String prenom = champPrenom.getText().trim();
        if (nom.isEmpty() || prenom.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.");
            return;
        }

        Utilisateur utilisateur = new Utilisateur(nom, prenom);

        // On propose tous les documents à l'utilisateur
        List<Document> disponibles = new ArrayList<>(supports);

        Document selection = (Document) JOptionPane.showInputDialog(
                this, "Sélectionnez un document:", "Emprunt",
                JOptionPane.PLAIN_MESSAGE, null,
                disponibles.toArray(new Document[0]), disponibles.get(0));

        if (selection != null) {
            boolean empruntReussi = utilisateur.emprunter(selection);
            if (empruntReussi) {
                JOptionPane.showMessageDialog(this, utilisateur.getNomComplet() + " a emprunté : " + selection.getTitre());
            } else {
                JOptionPane.showMessageDialog(this, "Ce document est déjà emprunté.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Affiche une liste de documents dans la zone de texte.
     *
     * @param liste La liste de documents à afficher.
     */
    private void afficher(List<Document> liste) {
        StringBuilder sb = new StringBuilder();
        for (Document d : liste) {
            sb.append(d.toString()).append("\n");
        }
        affichage.setText(sb.toString());
    }

    /**
     * Filtre les documents par type (Livre, CD, DVD) et les affiche.
     */
    private void filtrerParType() {
        String[] types = {"Livre", "CD", "DVD"};
        String type = (String) JOptionPane.showInputDialog(this, "Choisissez un type:", "Filtrer", JOptionPane.PLAIN_MESSAGE, null, types, types[0]);
        if (type == null) return;

        List<Document> filtres = supports.stream()
                .filter(d -> d.getType().equalsIgnoreCase(type))
                .toList();
        afficher(filtres);
    }

    /**
     * Recherche les documents dont le titre contient une chaîne donnée.
     */
    private void rechercherParTitre() {
        String titre = JOptionPane.showInputDialog(this, "Entrez le titre à rechercher:");
        if (titre == null || titre.isBlank()) return;

        List<Document> resultats = supports.stream()
                .filter(d -> d.getTitre().toLowerCase().contains(titre.toLowerCase()))
                .toList();
        afficher(resultats);
    }

    /**
     * Point d'entrée du programme. Lance l'interface graphique.
     *
     * @param args Arguments non utilisés ici.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main fenetre = new Main();
            fenetre.setVisible(true);
        });
    }
}
