/**
 * Created by Maxime on 29/03/2016.
 */
import java.util.*;

public class Joueur implements Humain {

    String nom;
    int carreObtenu;

    //Constructeur

    public Joueur(String nom){
        this.nom = nom;
        carreObtenu = 0;
    }

    public void jouer(Jeu j){
        Scanner in = new Scanner (System.in);
        System.out.println("Entrez la ligne où vous souhaitez placez un trait\n");
        int numeroLigne = in.nextInt();
        System.out.println("Entrez la colonne où vous souhaitez placez un trait\n");
        int numeroColonne = in.nextInt();
        j.jouer(numeroLigne,numeroColonne);
    }
}
