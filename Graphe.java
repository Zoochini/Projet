import java.io.IOException;
import java.util.*;

public interface Graphe{
    TreeMap<Integer,Configuration> g=null;

    /**
     * Insere un graphe dans un fichier au format dot
     * @param nbl Le nombre de ligne des configurations
     * @param nbc Le nombre de colonne des configurations
     * @throws IOException En cas de probleme avec le fichier creer
     */
    public void toDot(int nbl, int nbc) throws IOException;
    /*public void toPip(String type, int nbl, int nbc) throws IOException;*/
}