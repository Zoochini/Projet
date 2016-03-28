
import java.util.*;

public class Humain extends Joueur{
	
	public Humain (String nom){
		super(nom);
	}
	
	public void jouer(int[][] jeu){
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez le numero d'une ligne o� placer un trait");
		int numl=in.nextInt();
		System.out.println("Entrez le num�ro d'une colonne o� placer un trait");
		int numc=in.nextInt();
		jeu[numl][numc]=1;
		in.close();
	}
}