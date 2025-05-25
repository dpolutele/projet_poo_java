package mediatheque.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import mediatheque.model.*;

public class Main extends JFrame {
    private List<Document> supports = new ArrayList<>();
    private JTextArea affichage;

    public Main() {
        setTitle("Médiathèque");
        setSize(900, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

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

        affichage = new JTextArea();
        affichage.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(affichage);
        add(scrollPane, BorderLayout.CENTER);

        JPanel boutons = new JPanel(new FlowLayout());

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

    private void ajouterBouton(JPanel panel, String label, ActionListener action) {
        JButton bouton = new JButton(label);
        bouton.addActionListener(action);
        panel.add(bouton);
    }

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

        // Ne filtre plus les documents disponibles : on montre tout
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

    private void afficher(List<Document> liste) {
        StringBuilder sb = new StringBuilder();
        for (Document d : liste) {
            sb.append(d.toString()).append("\n");
        }
        affichage.setText(sb.toString());
    }

    private void filtrerParType() {
        String[] types = {"Livre", "CD", "DVD"};
        String type = (String) JOptionPane.showInputDialog(this, "Choisissez un type:", "Filtrer", JOptionPane.PLAIN_MESSAGE, null, types, types[0]);
        if (type == null) return;

        List<Document> filtres = supports.stream()
                .filter(d -> d.getType().equalsIgnoreCase(type))
                .toList();
        afficher(filtres);
    }

    private void rechercherParTitre() {
        String titre = JOptionPane.showInputDialog(this, "Entrez le titre à rechercher:");
        if (titre == null || titre.isBlank()) return;

        List<Document> resultats = supports.stream()
                .filter(d -> d.getTitre().toLowerCase().contains(titre.toLowerCase()))
                .toList();
        afficher(resultats);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main fenetre = new Main();
            fenetre.setVisible(true);
        });
    }
}
