package mediatheque.model;

/**
 * Représente un DVD dans la médiathèque.
 * Un DVD est un type de document avec un titre, un auteur et une année.
 */
public class DVD extends Document {

    /**
     * Crée un nouveau DVD avec son titre, son auteur et son année de sortie.
     *
     * @param titre  Le titre du DVD.
     * @param auteur Le nom du réalisateur ou auteur du DVD.
     * @param annee  L'année de sortie du DVD.
     */
    public DVD(String titre, String auteur, int annee) {
        super(titre, auteur, annee);
    }

    /**
     * Retourne le type du document.
     *
     * @return Le mot "DVD", pour indiquer que c'est un DVD.
     */
    @Override
    public String getType() {
        return "DVD";
    }
}
