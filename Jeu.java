
/*
 * Classe utilisé pour crée le "plateau" de jeu
 * */

public class Jeu {
	
	private int[][] jeu;

	//initialise le jeu
	public Jeu(String type, int nblignes, int nbcolonnes){
		jeu = new int[nblignes*2+1][nbcolonnes*2+1];
		for(int i=0;i<jeu[0].length;i++){
			if(i%2==0){
				for(int j=0;j<jeu.length;j+=2){
					jeu[j][i]=1;
				}
			}
		}
		if(type=="rempli"){
			for(int i=0;i<jeu.length;i++){
				jeu[i][0]=1;
				jeu[i][jeu[0].length-1]=1;
			}
			for(int i=0;i<jeu[0].length;i++){
				jeu[0][i]=1;
				jeu[jeu.length-1][i]=1;
			}
		}
	}

	//Renvoie une copie du plateau en paramètre
	public Jeu(Jeu plateau){
		this.jeu = new int[plateau.jeu.length][plateau.jeu[0].length];
		for(int i=0;i<jeu.length;i++){
			for(int j=0;j<jeu[0].length;j++){
				if(plateau.jeu[i][j]==1){
					jeu[i][j]=plateau.jeu[i][j];
				}
			}
		}
	}

	//Affiche la situation de la partie
	public void afficher(){
		for(int i=0;i<jeu.length;i++){
			for(int j=0;j<jeu[0].length;j++){
				if(jeu[i][j]==1){
					if(i%2==0){
						if(j%2==0){
							System.out.print(".");
						}else{
							System.out.print("_");
						}
					}else{
						if(j%2==0){
							System.out.print("|");
						}else{
							System.out.print(".");
						}
					}
				}else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/*
	 * La fonction afficher sert pour des tests d'affichage
	 */
	
	public void afficher1(){
		for(int i=0;i<jeu.length;i++){
			for(int j=0; j<jeu[0].length;j++){
				System.out.print(jeu[i][j]);
			}
			System.out.println();
		}
	}

	//Renvoie le nombre de coup possibles à jouer
	public int tracePossible(){
		int nombreCoup = 0;
		for(int i=0; i<jeu.length;i++){
			for(int j=0; j<jeu[0].length;j++){
				if(jeu[i][j]==0){
					if(i%2==0){
						if(j%2!=0){
							nombreCoup++;
						}
					}else{
						if(j%2==0){
							nombreCoup++;
						}
					}
				}
			}
		}
		return nombreCoup;
	}

	//Trace le coup possible numéro "i" pour définir une nouvelle configuration
	public Jeu trace(int n){
		Jeu succ = new Jeu(this);
		int i=0;
		int j=0;
		while(n!=0){
			while(j<succ.jeu[0].length){
				if(succ.jeu[i][j]==0){
					n--;
					if(n==0){
						break;
					}
				}
				j++;
			}
			j=0;
			i++;
		}
		succ.jeu[i][j]=1;
		succ.completion(i,j);
		return succ;
	}

	//Complète tous les carrées possible à faire dans le tour du même joueur(sert à définir une nouvelle configuration)
	public void completion(int numl,int numc){

	}
}