
public class Simplet implements IA{

	int carreObtenu;

	/**
	 * Initialise l'ia
	 */
	public Simplet(){
		carreObtenu=0;
	}

	/**
	 * place un trait aleatoirement sur le plateau
	 * @param jeu Jeu sur lequel on place un trait
     */
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
