package mediatheque.model;

/**
 * Représente un livre dans la médiathèque.
 * Un livre est un type de document avec un titre, un auteur et une année.
 */
public class Livre extends Document {

    /**
     * Crée un nouveau livre avec son titre, son auteur et son année de parution.
     *
     * @param titre  Le titre du livre.
     * @param auteur Le nom de l'auteur du livre.
     * @param annee  L'année de parution du livre.
     */
    public Livre(String titre, String auteur, int annee) {
        super(titre, auteur, annee);
    }

    /**
     * Retourne le type du document.
     *
     * @return Le mot "Livre", pour indiquer que c'est un livre.
     */
    @Override
    public String getType() {
        return "Livre";
    }
}
