package mediatheque.model;

/**
 * Classe abstraite représentant un document de la médiathèque (comme un livre ou un CD).
 * Un document a un titre, un auteur, une année de sortie, et peut être emprunté ou non.
 */
public abstract class Document {
    private String titre;       // Le titre du document
    private String auteur;      // Le nom de l'auteur du document
    private int annee;          // L'année de publication ou de sortie
    private boolean emprunte;   // Indique si le document est actuellement emprunté

    /**
     * Constructeur d'un document.
     *
     * @param titre  Le titre du document.
     * @param auteur Le nom de l'auteur.
     * @param annee  L'année de publication ou de sortie.
     */
    public Document(String titre, String auteur, int annee) {
        this.titre = titre;
        this.auteur = auteur;
        this.annee = annee;
        this.emprunte = false;
    }

    /**
     * Retourne le titre du document.
     *
     * @return Le titre.
     */
    public String getTitre() {
        return titre;
    }

    /**
     * Retourne le nom de l'auteur.
     *
     * @return L'auteur.
     */
    public String getAuteur() {
        return auteur;
    }

    /**
     * Retourne l'année de sortie ou de publication.
     *
     * @return L'année.
     */
    public int getAnnee() {
        return annee;
    }

    /**
     * Indique si le document est actuellement emprunté.
     *
     * @return true si le document est emprunté, false sinon.
     */
    public boolean estEmprunte() {
        return emprunte;
    }

    /**
     * Marque le document comme emprunté.
     *
     * @throws DocumentDejaEmprunteException si le document est déjà emprunté.
     */
    public void emprunter() throws DocumentDejaEmprunteException {
        if (emprunte) {
            throw new DocumentDejaEmprunteException("Le document \"" + titre + "\" est déjà emprunté.");
        }
        emprunte = true;
    }

    /**
     * Marque le document comme retourné (non emprunté).
     *
     * @throws DocumentNonEmprunteException si le document n'était pas emprunté.
     */
    public void retourner() throws DocumentNonEmprunteException {
        if (!emprunte) {
            throw new DocumentNonEmprunteException("Le document \"" + titre + "\" n'est pas emprunté.");
        }
        emprunte = false;
    }

    /**
     * Méthode abstraite pour obtenir le type du document (ex : "Livre", "CD").
     *
     * @return Le type du document.
     */
    public abstract String getType();

    /**
     * Retourne une description du document sous forme de texte.
     *
     * @return Une chaîne de caractères décrivant le document.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d) %s",
                getType(), titre, auteur, annee, emprunte ? "[EMPRUNTÉ]" : "");
    }
}



