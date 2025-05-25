package mediatheque.model;

/**
 * Représente un CD dans la médiathèque.
 * Un CD est un type de document avec un titre, un auteur et une année.
 */
public class CD extends Document {

    /**
     * Crée un nouveau CD avec son titre, son auteur et son année de sortie.
     *
     * @param titre  Le titre du CD.
     * @param auteur Le nom de l'auteur ou artiste du CD.
     * @param annee  L'année de sortie du CD.
     */
    public CD(String titre, String auteur, int annee) {
        super(titre, auteur, annee);
    }

    /**
     * Retourne le type du document.
     *
     * @return Le mot "CD", pour indiquer que c'est un CD.
     */
    @Override
    public String getType() {
        return "CD";
    }
}
