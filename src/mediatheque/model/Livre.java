package mediatheque.model;

public class Livre extends Document {
    public Livre(String titre, String auteur, int annee) {
        super(titre, auteur, annee);
    }

    @Override
    public String getType() {
        return "Livre";
    }
}
