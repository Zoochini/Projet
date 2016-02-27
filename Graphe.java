import java.util.*;

public interface Graphe{
    public Configuration initial();
    public Iterator<Integer> succ(Configuration);
    public Configuration succ(int a);
}