import java.util.*;

public class ConfSimple implements Configuration {

    int nbSucc;
    int val;
    public ArrayList<Configuration> succ;
    public Jeu conf;

    //Constructeur(s)

    public ConfSimple(int val, Jeu conf) {
        this.nbSucc = 0;
        this.val = val;
        this.conf = new Jeu(conf);

        //On définit les successeurs de cette configuration
        for(int i = 0; i<conf.tracePossible(); i++){
            succ.add(new ConfSimple(0,this.trace(i)));//à compléter pour définir les valeurs et les poids
        }

        //Symetrie
        if(succ.size()>1){
            Configuration confi;
            Configuration confj;
            for(int i=0; i<succ.size();i++) {
                for (int j = 0; j < succ.size(); j++) {
                    if (i != j) {
                        confi = succ.get(i);
                        confj = succ.get(j);
                        if(confi.symetrique(confj)){
                            succ.remove(j);
                            nbSucc++;
                        }
                    }
                }
            }
        }
    }

    //Méthodes

    public int tracePosible(){
       return conf.tracePossible();
    }

    public Jeu trace(int i){
        conf.trace(i);
    }

    public int nbCarre(){
        return conf.nbCarre();
    }

    public boolean symetrique(Configuration c){
        if(this.succ.size()==c.succ.size()){
            int nbCarrei=0;
            int nbCarrej=0;
            for(int i=0; i<this.succ.size();i++){
                nbCarrei += this.succ.get(i).conf.nbCarre();
                nbCarrej += c.succ.get(i).conf.nbCarre();
            }
            return nbCarrei == nbCarrej;
        }
        return false;
    }

    public Integer keyOfValue(Graphe gs){
        for(int i=0; i<gs.g.size();i++){
            if(gs.g.get(i).equals(this)){
                return i;
            }
        }
    }

    @Override
    public String toString(){
        return " "+val;
    }

    public String todot(){
        char c[] = new String(conf.toString()).toCharArray();
        String s = new String("");
        for(int i=0; i<c.length; i++){
            if(c[i]=='\n'){
                s = s+"\\n";
            }else{
                s = s+c[i];
            }
        }
        return s;
    }
    public int ident(){
        return val;
    }
}
