import java.util.*;

public interface Graphe{
    public Configuration initial(int nbl, int nbc);//Configure le sommet initial N1
    public Iterator<Integer> succ(Configuration);
    public Configuration succ(int a);
}