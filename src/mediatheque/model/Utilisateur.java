package mediatheque.model;

import java.util.ArrayList;
import java.util.List;

public class Utilisateur {
    private String nom;
    private String prenom;
    private List<Document> emprunts;

    public Utilisateur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.emprunts = new ArrayList<>();
    }

    public String getNomComplet() {
        return prenom + " " + nom;
    }

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

    public List<Document> getEmprunts() {
        return emprunts;
    }

    @Override
    public String toString() {
        return getNomComplet();
    }
}
