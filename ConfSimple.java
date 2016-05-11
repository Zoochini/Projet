import java.util.*;

public class ConfSimple implements Configuration {

    int nbSucc;
    int val;
    public ArrayList<Configuration> succ;
    public Jeu conf;

    //Constructeur(s)

    /**
     * Initialise une nouvelle configuration
     * @param val Le poids de la configuration
     * @param conf Le jeu a aprtir duquel la configuration est creer
     */
    public ConfSimple(int val, Jeu conf) {
        this.nbSucc = 0;
        this.val = val;
        this.conf = new Jeu(conf);

        //On définit les successeurs de cette configuration
        for(int i = 0; i<conf.tracePossible(); i++){
            succ.add(new ConfSimple(0,this.trace(i)));//à compléter pour définir les valeurs et les poids
        }

        //Symetrie
        if(succ.size()>1){
            Configuration confi;
            Configuration confj;
            for(int i=0; i<succ.size();i++) {
                for (int j = 0; j < succ.size(); j++) {
                    if (i != j) {
                        confi = succ.get(i);
                        confj = succ.get(j);
                        if(confi.symetrique(confj)){
                            succ.remove(j);
                            nbSucc++;
                        }
                    }
                }
            }
        }
    }

    //Méthodes

    /**
     * Permet de savoir s'il reste des successeurs a definir (sans les symetrie)
     * @return Le nombre de successeurs possible restant
     */
    public int tracePosible(){
       return conf.tracePossible();
    }

    /**
     * Trace un trait pour definir ensuite un nouveau succeseurs
     * @param i La position du trait a placer
     * @return Renvoie le nouveau plateau avec le trait place qui servira de successeur
     */
    public Jeu trace(int i){
        return conf.trace(i);
    }

    /**
     * Permet d'identifier le nombre de carre completer dans une configuration
     * @return Le nombre de carre completer dans cette configuration
     */
    public int nbCarre(){
        return conf.nbCarre();
    }

    /**
     * Compare deux configurations entre elle et determine si elles sont symetrique
     * @param c La configuration compare a celle instancie
     * @return Vrai si symetrique Faux sinon
     */
    public boolean symetrique(Configuration c){
        if(this.succ.size()==c.succ.size()){
            int nbCarrei=0;
            int nbCarrej=0;
            for(int i=0; i<this.succ.size();i++){
                nbCarrei += this.succ.get(i).conf.nbCarre();
                nbCarrej += c.succ.get(i).conf.nbCarre();
            }
            return nbCarrei == nbCarrej;
        }
        return false;
    }

    /**
     * Determine la cle dans le Graphe d'une configuration donne
     * @param gs Le graphe dans lequel on cherche la cle
     * @return La cle correspondant a la configuration
     */
    public Integer keyOfValue(Graphe gs){
        for(int i=0; i<gs.g.size();i++){
            if(gs.g.get(i).equals(this)){
                return i;
            }
        }
        throw new IndexOutOfBoundsException("La cle n'existe pas.");
    }

    /**
     * Convertit la configuration en parametre en chaine de caractere plus simple a implementer
     * @return La configuration instancie au format String plus simple a integrer dans le fichier dot
     * @see GrapheSimple#toDot(int, int)
     */
    public String todot(){
        char c[] = new String(conf.toString()).toCharArray();
        String s = new String("");
        for(int i=0; i<c.length; i++){
            if(c[i]=='\n'){
                s = s+"\\n";
            }else{
                s = s+c[i];
            }
        }
        return s;
    }
    public int ident(){
        return val;
    }
}
