import java.util.*;

public class Algo{
    Graphe g;
    public String todot(){
        StringBuffer res = new StringBuffer ;
        res.append("digraph default{");
            res.append(Graphe.initial());
            res.append("");
            return res.toString();
        }
        public String todotRec(Configuration c){
            StringBuffer res = new StringBuffer() ;
            res.append(" N "+ c.ident() + " [label= " + ) ;
            for(int a:c.action(c)){
                Configuration cprime=g.succ(c,a);
                res.append(todotRec(cprime));
                res.append("N" + c.indent() + "-> N" + cprime.ident() +"\n");
            }
            return res.toString();
        }
    }
}