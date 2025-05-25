package mediatheque.model;

public class DVD extends Document {
    public DVD(String titre, String auteur, int annee) {
        super(titre, auteur, annee);
    }

    @Override
    public String getType() {
        return "DVD";
    }
}
