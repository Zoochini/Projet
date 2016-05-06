import java.util.*;

/*Graphe composé d'un sommet initial de type Configuration
  Ce même sommet sera composé d'une liste d'autres configuration
  défnit comme étant ces successeurs.
 */

public class GrapheSimple implements Graphe {
    HashMap<Integer,Configuration> g;

    public GraphSimple(String type,Jeu jeu){
        this.g = HashMap(Map<Integer,Configuration> g) ;

    }
    public Iterator<Integer> action(Configuration c);
    public Configuration succ(Configuration c){
        int nbSucc = toto[c.ident()].length;
    }
}
