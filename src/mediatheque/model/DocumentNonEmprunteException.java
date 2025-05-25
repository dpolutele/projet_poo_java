package mediatheque.model;

public class DocumentNonEmprunteException extends Exception {
    public DocumentNonEmprunteException(String message) {
        super(message);
    }
}
