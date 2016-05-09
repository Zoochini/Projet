
public class Simplet implements IA{

	int carreObtenu;

	public Simplet(){
		carreObtenu=0;
	}
	
	public void jouer(Jeu jeu){
		int nbVide=0;
		int nbCarreBefore = jeu.nbCarre();
		int i =0;
		while(i<jeu.plateau.length()){
			if(jeu.plateau.charAt(i)=='0'){
				nbVide++;
			}
		}
		int random = (int )(Math.random() * nbVide + 1);
		i=0;
		while(random!=0){
			if(jeu.plateau.charAt(i)=='0'){
				random--;
			}
		}
		jeu.jouer(i);
		if(nbCarreBefore<jeu.nbCarre()){
			System.out.println("Simplet a complété un carré il rejoue\n");
			carreObtenu++;
		}
	}
}
