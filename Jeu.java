
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

	private Jeu (String type,int nbl, int nbc){
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
		if(numeroLigne%2==0){
			int position = (nbc+1)*(numeroLigne/2)+numeroColonne-1;
			replaceCharAt(plateau,position,'1');
		}
		//Ligne impaire
		else{
			int position = (numeroLigne/2)*(nbc+1)+(numeroLigne/2)*(nbc+2);
			plateau = replaceCharAt(plateau,position,'1');
		}
	}

	public void jouer(int pos){
		plateau = replaceCharAt(plateau,pos,'1');
	}

	public String toString(){
		String s = "";
		int cpt = 0;
		int x = (nbl+1)*nbc + nbl*(nbc+1);
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