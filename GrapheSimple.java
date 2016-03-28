import java.util.*;

/*Graphe composé d'un sommet initial de type Configuration
  Ce même sommet sera composé d'une liste d'autres configuration
  défnit comme étant ces successeurs.
 */

public class GrapheSimple implements Graphe {
    Configuration initial;

    public GraphSimple(String type,Jeu jeu){
        initial = new ConfSimple(0,jeu);

    }
    public Iterator<Integer> action(Configuration c);
    public Configuration succ(Configuration c){
        int nbSucc = toto[c.ident()].length;
    }
}
