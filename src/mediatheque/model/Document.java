package mediatheque.model;

public abstract class Document {
    private String titre;
    private String auteur;
    private int annee;
    private boolean emprunte;

    public Document(String titre, String auteur, int annee) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.emprunte = false;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getAnnee() {
        return annee;
    }

    public boolean estEmprunte() {
        return emprunte;
    }

    public void emprunter() throws DocumentDejaEmprunteException {
        if (emprunte) {
            throw new DocumentDejaEmprunteException("Le document \"" + titre + "\" est déjà emprunté.");
        }
        emprunte = true;
    }

    public void retourner() throws DocumentNonEmprunteException {
        if (!emprunte) {
            throw new DocumentNonEmprunteException("Le document \"" + titre + "\" n'est pas emprunté.");
        }
        emprunte = false;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d) %s",
                getType(), titre, auteur, annee, emprunte ? "[EMPRUNTÉ]" : "");
    }
}
