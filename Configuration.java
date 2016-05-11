import java.util.*;

public interface Configuration{

        int nbSucc=0;
        int val=0;
        Jeu conf = null;
        ArrayList<Configuration> succ = new ArrayList<Configuration>();

    /**
     * Facilite l'implementation dans un fichier dot de la configuration en la convertissant en chaine de caractere
     * @return La chaine de caractere a implementer
     * @see Graphe#toDot(int, int)
     */
    public String todot();

    /**
     * Compare deux configuration pour determiner si elles sont symetrique
     * @param c Configuration compare a celle instancie a la base
     * @return Vrai si symetrique Faux sinon
     */
    public boolean symetrique(Configuration c);

    /**
     * Identifie la cle lier a une configuration du graphe
     * @param gs Graphe dans lequel on recherche la cle
     * @return La cle lie a la configuration instancie
     */
    public Integer keyOfValue(Graphe gs);
}