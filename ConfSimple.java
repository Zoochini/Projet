import java.util.*;

public class ConfSimple implements Configuration {

    int nbSucc;
    int val;
    public ArrayList succ;
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
    }

    //Méthodes

    public int tracePosible(){
       return conf.tracePossible();
    }

    public Jeu trace(int i){
        conf.trace(i);
    }



    @Override
    public String toString(){
        return " "+val;
    }
    public int ident(){
        return val;
    }


}
