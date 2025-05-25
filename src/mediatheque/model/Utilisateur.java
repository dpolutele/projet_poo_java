package mediatheque.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un utilisateur de la médiathèque.
 * Un utilisateur peut emprunter et retourner des documents.
 */
public class Utilisateur {
    private String nom;
    private String prenom;
    private List<Document> emprunts;

    /**
     * Crée un nouvel utilisateur avec un prénom et un nom.
     *
     * @param nom     Le nom de l'utilisateur.
     * @param prenom  Le prénom de l'utilisateur.
     */
    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.emprunts = new ArrayList<>();
    }

    /**
     * Retourne le nom complet de l'utilisateur.
     *
     * @return Une chaîne contenant le prénom suivi du nom.
     */
    public String getNomComplet() {
        return prenom + " " + nom;
    }

    /**
     * Tente d'emprunter un document.
     *
     * @param doc Le document à emprunter.
     * @return true si l'emprunt a réussi, false sinon.
     */
    public boolean emprunter(Document doc) {
        try {
            doc.emprunter();
            emprunts.add(doc);
            return true;
        } catch (DocumentDejaEmprunteException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * Tente de retourner un document.
     *
     * @param doc Le document à retourner.
     * @return true si le retour a réussi, false sinon.
     */
    public boolean retourner(Document doc) {
        if (emprunts.contains(doc)) {
            try {
                doc.retourner();
                emprunts.remove(doc);
                return true;
            } catch (DocumentNonEmprunteException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return false;
    }

    /**
     * Retourne la liste des documents empruntés par l'utilisateur.
     *
     * @return Une liste de documents.
     */
    public List<Document> getEmprunts() {
        return emprunts;
    }

    /**
     * Retourne le nom complet de l'utilisateur.
     *
     * @return Une chaîne avec le nom et prénom.
     */
    @Override
    public String toString() {
        return getNomComplet();
    }
}
