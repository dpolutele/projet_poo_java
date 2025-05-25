package mediatheque.model;

public class CD extends Document {
    public CD(String titre, String auteur, int annee) {
        super(titre, auteur, annee);
    }

    @Override
    public String getType() {
        return "CD";
    }
}
