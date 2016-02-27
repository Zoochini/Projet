
import java.util.*;

public class Partie {

	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		//Définition du jeu/plateau
		//Jeu jeu = new Jeu(args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		
		Jeu jeu = new Jeu("rempli",4,4);
		
		Joueur j1 = new Humain("Humain");
		Joueur j2 = new Simplet();
		
		jeu.afficher();
		jeu.afficher1();

		in.close();
	}
}
