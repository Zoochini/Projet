
import java.io.IOException;

public class Partie {

	public static void main(String[] args) throws IOException {
		
		switch(args[0]){

            case "-name" :
                System.out.println("Bardiot Maxime\nKhlifi Hicham\nBaccon Clément\nMagnougnet Cyril\n");
                break;

            case "-h" :
                System.out.println("Options du programme : \n -name : affiche les noms et prénoms des personnes du groupe" +
                        "\n -h : Rappelle la liste des options du programme\n -graphe type nblignes nbcolonnes : renvoie le graphe des config au format dot" +
                        "\n -joue strategie : offre la possibilité de jouer sur la console de manière interactive" +
                        "\n -cal stratégie : calcule une stratégie optimum face à un joueur suivant la stratégie passé en paramètre (renvoie le résultat au format pip)" +
                        "\n -cal -graphe strategie : Même chose renvoyé sou forme dot\n -append parametres strategie : calcule une stratégie par méthode d'apprentissage" +
                        "\n");
                break;

            case "-graphe" :
                int nblignes = Integer.parseInt(args[2]);//Faire fonctions définir jeu
                int nbcolonnes = Integer.parseInt(args[3]);
                Jeu j = DefJeu(args[1],args[2],args[3]);
                GrapheSimple g = new GrapheSimple(j);
                g.toDot(nblignes,nbcolonnes);
                break;

            case "-joue" :
                Humain h = new Joueur();
                switch(args[1]){
                    case "-simplet" :
                        IA s = new Simplet();
                        j = DefJeu(args[2], args[3], args[4]);
                        jouer(h,s,j);
                        break;

                    case "-prevoyant" :
                        IA p = new Prevoyant();
                        j = DefJeu(args[2], args[3], args[4]);
                        j.jouer(h,p);
                        break;

                    case "-idiot" :
                        IA i = new Idiot();
                        j = DefJeu(args[2],args[3],args[4]);
                        j.jouer(h,i);
                        break;

                    //CAS A PART ATTENTION UTILISATION D'UN FICHIER PIP!!!

                    case "-pondere" :
                        IA po = new Pondere();
                        j = DefJeu(args[2],args[3],args[4]);
                        j.jouer(h,po);
                        break;

                    //FIN DU CAS

                    default :
                        System.out.println("Mauvais parametre, réessayer avec de bons paramètres");
                        break;
                break;

                }
                break;

            case "-cal" :
                //à compléter
                break;

            case "-apprend" :
                //à compléter
                break;

            case "-eval" :
                //àcompléter
                break;

            case "-simul" :
                //à compléter
                break;
		}
	}

    public static Jeu DefJeu(String argType,String argNblignes, String argNbcolonnes){
        int nblignes = Integer.parseInt(argNblignes);//Faire fonctions définir jeu
        int nbcolonnes = Integer.parseInt(argNbcolonnes);
        Jeu j = new Jeu(argType, nblignes, nbcolonnes);
        return j;
    }

    public static void jouer(Humain h, IA ia, Jeu j){
        while(j.tracePossible()>0){
            h.jouer(j);
            ia.jouer(j);
        }
        if(h.carreObtenu>ia.carreObtenu){
            System.out.println("Bravo vous avez gagne !\n");
        }else{
            if(h.carreObtenu<ia.carreObtenu){
                System.out.println("Dommage vous avez perdu !\n");
            }else{
                System.out.println("Egalite entre vous !\n");
            }
        }
    }
}
