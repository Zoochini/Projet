import java.util.*;

public interface Configuration{

        int nbSucc=0;
        int val=0;
        public Jeu conf = null;
        public ArrayList<Configuration> succ = new ArrayList<Configuration>();
        public String todot();
        public boolean symetrique(Configuration c);
        public Integer keyOfValue(Graphe gs);
}