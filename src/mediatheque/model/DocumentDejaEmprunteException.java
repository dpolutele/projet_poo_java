package mediatheque.model;

/**
 * Cette classe représente une erreur qui se produit
 * quand on essaie d'emprunter un document déjà emprunté.
 */
public class DocumentDejaEmprunteException extends Exception {

    /**
     * Crée une nouvelle erreur avec un message personnalisé.
     *
     * @param message Le texte expliquant pourquoi l'erreur est affichée.
     */
    public DocumentDejaEmprunteException(String message) {
        super(message);
    }
}
