
/*
 * Classe utilisé pour crée le "plateau" de jeu
 * */

public class Jeu {
	
	private int[][] jeu;

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
}