
public abstract class Joueur {

	private String nom;
	private int nbCarre;
	
	public Joueur(String nom){
		this.nom = nom;
	}
	
	public abstract void jouer(int[][] jeu);
	
	/*
	 * Programme vérifiant si un carrée a été complété
	 * pour pouvoir déterminer si le joueur doit rejouer
	 * retourne vrai si le joueur doit rejouer sinon faux
	 */
	public boolean verifCarre(int [][] jeu, int numl, int numc){
		
		//Cas numl = Paire && numc = Impair ==> -
		if(numl%2==0 && numc%2!=0){
			if(numl==0){
				if(jeu[numl+1][numc-1]==1 && jeu[numl+1][numc+1]==1 && jeu[numl+2][numc]==1 && jeu[numl+1][numc]==0){
					nbCarre++;
					jeu[numl+1][numc]=1;
					return true;
				}
			}else{
				if(numl==jeu.length-1){
					if(jeu[numl-1][numc-1]==1 && jeu[numl-1][numc+1]==1 && jeu[numl-2][numc]==1 && jeu[numl-1][numc]==0){
						nbCarre++;
						jeu[numl-1][numc]=1;
						return true;
					}
				}else{
					int scorePrecedent=nbCarre;
					if(jeu[numl-1][numc-1]==1 && jeu[numl-1][numc+1]==1 && jeu[numl-2][numc]==1 && jeu[numl-1][numc]==0){
						nbCarre++;
						jeu[numl-1][numc]=1;
					}
					if(jeu[numl+1][numc-1]==1 && jeu[numl+1][numc+1]==1 && jeu[numl+2][numc]==1 && jeu[numl+1][numc]==0){
						nbCarre++;
						jeu[numl+1][numc]=1;
					}
					if(scorePrecedent<nbCarre){
						return true;
					}
				}
			}
		//Cas numl = Impair && numc = Paire ==> |
		}else{
			if(numl%2!=0 && numc%2==0){
				if(numc==0){
					if(jeu[numl-1][numc+1]==1 && jeu[numl+1][numc+1]==1 && jeu[numl][numc+2]==1 && jeu[numl][numc+1]==0){
						nbCarre++;
						jeu[numl][numc+1]=1;
						return true;
					}
				}else{
					if(numc==jeu[0].length-1){
						if(jeu[numl-1][numc-1]==1 && jeu[numl+1][numc-1]==1 && jeu[numl][numc-2]==1 && jeu[numl][numc-1]==0){
							nbCarre++;
							jeu[numl][numc-1]=1;
							return true;
						}
					}else{
						int scorePrecedent=nbCarre;
						if(jeu[numl-1][numc+1]==1 && jeu[numl+1][numc+1]==1 && jeu[numl][numc+2]==1 && jeu[numl][numc+1]==0){
							nbCarre++;
							jeu[numl][numc+1]=1;
						}
						if(jeu[numl-1][numc-1]==1 && jeu[numl+1][numc-1]==1 && jeu[numl][numc-2]==1 && jeu[numl][numc-1]==0){
							nbCarre++;
							jeu[numl][numc-1]=1;
						}
						if(scorePrecedent<nbCarre){
							return true;
						}
					}
				}
			}
		}
		
		//Aucun carr� compl�t�
		return false;
	}

	public String getNom() {
		String n = new String(nom);
		return n;
	}

	public int getNbCarre() {
		return nbCarre;
	}
}