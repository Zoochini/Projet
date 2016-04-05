import java.util.*;

public class ConfSimple implements Configuration {

    int val;
    public ArrayList succ;
    public Jeu conf;

    public ConfSimple(int val, Jeu conf) {
        this.val = val;
        this.conf = new Jeu(conf);

        //On définit les successeurs de cette configuration
        for(int i = 0; i<conf.tracePossible(); i++){
            succ.add(new ConfSimple(0,conf.trace(i)));//à compléter pour définir les valeurs et les poids
        }
    }

    @Override
    public String toString(){
        return " "+val;
    }
    public int ident(){
        return val;
    }


}
