
public class Simplet extends Joueur{

	public Simplet(){
		super("Simplet");
	}
	
	public void jouer(int[][] jeu){
		int nbVide=0;
		for(int i=1; i<jeu.length; i+=2){
			for(int j=1; j<jeu[0].length; j+=2){
				if(jeu[i][j]==0){
					nbVide++;
				}
			}
		}
		int random = (int )(Math.random() * nbVide + 1);
		for(int i=1; i<jeu.length; i+=2){
			for(int j=1; j<jeu[0].length; j+=2){
				if(jeu[i][j]==0){
					nbVide--;
					if(nbVide==random){
						jeu[i][j]=1;
						return;
					}
				}
			}
		}
	}
}
