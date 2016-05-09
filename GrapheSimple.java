import java.util.*;
import  java.io.*;

/*Graphe composé d'un sommet initial de type Configuration
  Ce même sommet sera composé d'une liste d'autres configuration
  défnit comme étant ces successeurs.
 */

public class GrapheSimple implements Graphe {
    TreeMap<Integer,Configuration> g;

    public GrapheSimple(Jeu jeu){
        this.g = new TreeMap();
        Configuration initial = new ConfSimple(0,jeu);
        g.put(0,initial);
        this.defGraphe(0);
    }

    public void defGraphe(Integer k){
        if(k<g.size()){
            int j = g.size();
            Configuration c = g.get(k);
            for(int i=0; i<c.succ.size(); i++){
                if(!g.containsValue(c.succ.get(i))){
                    g.put(j,c.succ.get(i));
                    j++;
                }
            }
            this.defGraphe(k+1);
        }
    }

    public void toDot(int nbl, int nbc) throws IOException{
        File f = new File("C"+nbl+"x"+nbc+".dot");
        f.createNewFile();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        pw.print("digraph default {\ngraph[labelloc=\"t\" fontsize=16 fontcolor=\"blue\"\nlabel=\"Graphe des configurations d'un jeu de pipopipette\\n et calcul d'une stratégie gagnante\\n\\n\"]\n\nnode [shape=box fontname = \"Courrier New\" color=\"sienna\"]\nedge[fontname = \"Times\" fontcolor=\"sienna\"]\n\n");
        Configuration c;
        for(int i=0; i<g.size();i++){
            c=g.get(i);
            pw.print("N"+i+" [label=N"+i+":V="+c.val+"\\n"+c.todot()+"\"]\n");
        }
        int j=0;
        Configuration s;
        for(int i=0; i<g.size();i++){
            c=g.get(i);
            while(j<c.succ.size()){
                s = c.succ.get(j);
                pw.print("N"+i+"->N"+s.keyOfValue(this)+"[taillabel="+s.nbSucc+"]\n");
                j++;
            }
            j=0;
        }
        pw.print("}");
        pw.close();
    }

    //A completer grace aux poids
    public void toPip(String type, int nbl, int nbc) throws IOException{
        File f = new File("C"+nbl+"x"+nbc+".pip");
        f.createNewFile();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
        if(type.equals("0")){
            pw.print()
        }
    }
}
