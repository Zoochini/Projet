import java.util.*;

public interface Graphe{
    TreeMap<Integer,Configuration> g=null;
    public Configuration initial(int nbl, int nbc);//Configure le sommet initial N1
    public void toDot(int nbl, int nbc);
    public void toPip;
}