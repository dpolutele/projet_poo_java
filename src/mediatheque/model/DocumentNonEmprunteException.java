package mediatheque.model;

/**
 * Cette classe représente une erreur qui se produit
 * quand on essaie de retourner un document qui n'a pas été emprunté.
 */
public class DocumentNonEmprunteException extends Exception {

    /**
     * Crée une nouvelle erreur avec un message personnalisé.
     *
     * @param message Le texte expliquant pourquoi l'erreur est affichée.
     */
    public DocumentNonEmprunteException(String message) {
        super(message);
    }
}
