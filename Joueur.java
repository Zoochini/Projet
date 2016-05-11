/**
 * Created by Maxime on 29/03/2016.
 */
import java.util.*;

public class Joueur implements Humain {

    int carreObtenu=0;

    //Constructeur

    /**
     * Initialise un nouveau joueur
     */
    public Joueur(){
        carreObtenu = 0;
    }

    //Methodes

    /**
     * Demande a un joueur un numero de ligne et de colonne pour tracer un trait
     * @param j Le jeu sur lequel l'on place un trait
     */
    public void jouer(Jeu j){
        Scanner in = new Scanner (System.in);
        int nbCarreBefore = j.nbCarre();
        System.out.println("Entrez la ligne où vous souhaitez placez un trait\n");
        int numeroLigne = in.nextInt();
        System.out.println("Entrez la colonne où vous souhaitez placez un trait\n");
        int numeroColonne = in.nextInt();
        j.jouer(numeroLigne,numeroColonne);
        if(nbCarreBefore<j.nbCarre()){
            System.out.println("Bien joué vous avez complété un Carré vous pouvez rejouer\n");
            carreObtenu++;
            this.jouer(j);
        }
    }
}
