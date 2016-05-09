
/*
 * Classe utilisé pour crée le "plateau" de jeu
 * */

public class Jeu {
	//On definit le jeu sous un format String pour simplifier l'implementation
	// dans un fichier dot et la conversion en graphe
	public String plateau;
	public int nbl;
	public int nbc;

	//Constructeur

	public Jeu (String type,int nbl, int nbc){
		this.nbl = nbl;
		this.nbc = nbc;
		if(type.equals("Vide")){
			plateauV(nbl,nbc);
		}else{
			plateauR(nbl,nbc);
		}
	}

	public Jeu(Jeu j){
		this.nbl = j.nbl;
		this.nbc = j.nbc;
		this.plateau = new String(j.plateau);
	}

	private void plateauV(int nbl,int nbc){
		this.plateau = "";
		int a;
		for(int i=0; i<nbl*2+1; i++){
			a = 0;
			if(i%2==0){
				while(a<nbc){
					this.plateau += "0";
					a +=1;
				}
			}else{
				while(a<=nbc){
					this.plateau += "0";
					a +=1;
				}
			}
			this.plateau += "\n";
		}
	}

	private void plateauR(int nbl, int nbc){
		this.plateau = "";
		int a;
		for(int j=0; j<nbc; j++){
			this.plateau += "1";
		}
		this.plateau += "\n";
		for(int i=1; i<nbl*2; i++){
			a = 0;
			if(i%2==0){
				while(a<nbc){
					this.plateau += "0";
					a +=1;
				}
			}else{
				this.plateau += "1";
				while(a<nbc-1){
					this.plateau += "0";
					a +=1;
				}
				this.plateau += "1";
			}
			this.plateau += "\n";
		}
		for(int j=0; j<nbc; j++){
			this.plateau += "1";
		}
		this.plateau += "\n";
	}

	//Méthodes

	public static String replaceCharAt(String s, int pos, char c) {
		return s.substring(0,pos) + c + s.substring(pos+1);
	}

	public void jouer(int numeroLigne,int numeroColonne){//à vérifier
		//Ligne paire
		if((numeroLigne-1)%2==0){
			int position = (numeroLigne/2)*(nbc+1)+(numeroLigne/2)*(nbc+2)+(numeroColonne-1)/2;
			replaceCharAt(plateau,position,'1');
		}
		//Ligne impaire
		else{
			int position = ((numeroLigne/2)+1)*(nbc+1)+(numeroLigne/2)*(nbc+2)+numeroColonne/2;
			plateau = replaceCharAt(plateau,position,'1');
		}
	}

	public void jouer(int pos){
		plateau = replaceCharAt(plateau,pos,'1');
	}


	//Renvoie le nombre de successeurs possibles pour une configuration sans gérer les symetrie permet egalement de savoir s'il reste un coup possible a jouer (le nombre de zero de la chaine)
	public int tracePossible(){
		int tp = 0;
		int l = plateau.length();
		for(int i = 0; i<l; i++){
			if(plateau.charAt(i)=='0'){
				tp++;
			}
		}
		return tp;
	}

	//Trace un trait a la position du x zero du plateau (numero0 ici represente x) permet donc de completer le plateau
	public Jeu trace(int numero0){
		int i = 0;
		while(numero0!=0){
			if(plateau.charAt(i)=='0'){
				numero0--;
			}
			i++;
		}
		i--;//On decremente la position de i de 1 pour ne pas se trouver à la position situé après l'endroit où l'on souhaite jouer
		Jeu newConf = new Jeu(this);
		replaceCharAt(newConf.plateau,i,'1');
		newConf.completerCarre();
		return newConf;
	}

	//Complete toutes les combinaisons de carre possible a completer sur le plateau
	public void completerCarre(){//a fignoler (repetition de code)
		for(int i=0; i<nbl*2-1;i++){
			if(i%2==0){
				for(int j=0; j<nbc+1;j++){
					//Ligne paire
					if(i==0){
						if(plateau.charAt(j)=='1' && plateau.charAt(nbc+1+j)=='1' && plateau.charAt(nbc+3+j)=='1' && plateau.charAt(nbc+2+j)!=1){
							replaceCharAt(plateau,nbc+2+j,'1');
						}
					}else{
						if(i==nbl*2-2){
							if(plateau.charAt((nbl/2+1)*(nbc+1)+(nbl/2+1)*(nbc+2)+j)=='1' && plateau.charAt((nbl/2+1)*(nbc+1)+(nbl/2)*(nbc+2)+j)=='1' && plateau.charAt((nbl/2+1)*(nbc+1)+(nbl/2)*(nbc+2)+j+3)=='1' && plateau.charAt((nbl/2+1)*(nbc+1)+(nbl/2)*(nbc+2)+j+2)!=1){
								replaceCharAt(plateau,(nbl/2+1)*(nbc+1)+(nbl/2)*(nbc+2)+j+2,'1');
							}
						}else{//Cas vers le bas
							if(plateau.charAt((i/2)*(nbc+1)+(i/2)*(nbc+2)+j+1)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+j+1)=='1'  && plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+j+2)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2+1)*(nbc+2)+j+1)!=1){
								replaceCharAt(plateau,(i/2+1)*(nbc+1)+(i/2+1)*(nbc+2)+j+1,'1');
							}else{
								if(plateau.charAt((i/2)*(nbc+1)+(i/2)*(nbc+2)+j+1)=='1' && plateau.charAt((i/2)*(nbc+1)+(i/2-1)*(nbc+2)+j+1)=='1' && plateau.charAt((i/2)*(nbc+1)+(i/2-1)*(nbc+2)+j+2)=='1' && plateau.charAt((i/2-1)*(nbc+1)+(i/2-1)*(nbc+2)+j+1)!=1){
									replaceCharAt(plateau,(i/2-1)*(nbc+1)+(i/2-1)*(nbc+2)+j+1,'1');
								}
							}
						}
					}
				}
			}else{
				for(int j=0; j<nbc*2-1;j++){
					//Ligne impaire
					if(j==0){
						if(plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+1)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2+1)*(nbc+2)+1)=='1' && plateau.charAt((i/2)*(nbc+1)+(i/2)*(nbc+2)+1)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+2)=='1'){
							replaceCharAt(plateau,(i/2+1)*(nbc+1)+(i/2)*(nbc+2)+2,'1');
						}else{
							if(j==nbc*2-2){
								if(plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+1+j)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2+1)*(nbc+2)+1+j)=='1' && plateau.charAt((i/2)*(nbc+1)+(i/2)*(nbc+2)+1+j)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+2+j)=='1'){
									replaceCharAt(plateau,(i/2+1)*(nbc+1)+(i/2)*(nbc+2)+2+j,'1');
								}
							}else{
								if(plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+1+j)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2+1)*(nbc+2)+1+j)=='1' && plateau.charAt((i/2)*(nbc+1)+(i/2)*(nbc+2)+1+j)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+2+j)=='1'){
									replaceCharAt(plateau,(i/2+1)*(nbc+1)+(i/2)*(nbc+2)+2+j,'1');
								}else{
									if(plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+1)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2+1)*(nbc+2)+1)=='1' && plateau.charAt((i/2)*(nbc+1)+(i/2)*(nbc+2)+1)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+2)=='1'){
										replaceCharAt(plateau,(i/2+1)*(nbc+1)+(i/2)*(nbc+2)+2,'1');
									}
								}
							}
						}
					}
				}
			}
		}
	}

	//Retourne le nombre de carre complete d'un plateau
	public int nbCarre(){
		int nbCarre = 0;
		for(int i=0; i<nbl*2-2;i+=2){
			for(int j=0;j<nbc+1;j++){
				if(plateau.charAt((i/2)*(nbc+1)+(i/2)*(nbc+2)+j+1)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+j+1)=='1'  && plateau.charAt((i/2+1)*(nbc+1)+(i/2)*(nbc+2)+j+2)=='1' && plateau.charAt((i/2+1)*(nbc+1)+(i/2+1)*(nbc+2)+j+1)=='1'){
					nbCarre++;
				}
			}
		}
		return nbCarre;
	}

	public boolean equals(Jeu j){
		return nbl==j.nbl && nbc==j.nbc && plateau.equals(j.plateau);
	}

	public String toString(){
		String s = "";
		int cpt = 0;
		int y;
		for(int i=0; i<2*nbl+1; i++){
			if(i%2 == 0){
				s += " .";
				y = nbc+1;
			}else{
				y = nbc+2;
			}
			for(int j=0; j<y; j++){
				if(i%2 == 0){
					if(plateau.charAt(cpt) == '1'){
						s += "-.";
					}else{
						if(plateau.charAt(cpt) == '0'){
							s += " .";
						}
					}
					cpt += 1;
				}else{
					if(plateau.charAt(cpt) == '1'){
						s += " |";
					}else{
						if(plateau.charAt(cpt) == '0'){
							s += "  ";
						}
					}
					cpt += 1;
				}
			}
			s += "\n";
		}
		return s;
	}
}