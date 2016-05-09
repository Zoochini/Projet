import java.io.IOException;
import java.util.*;

public interface Graphe{
    TreeMap<Integer,Configuration> g=null;
    public void toDot(int nbl, int nbc) throws IOException;
    public void toPip(String type, int nbl, int nbc) throws IOException;
}