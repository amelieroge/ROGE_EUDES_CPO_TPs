package sp4_console_roge_eudes;

public class Cellule {
    Jeton jetonCourant ;
    boolean trouNoir ;
    boolean desintegrateur ;
    
    public Cellule () {
        jetonCourant = null ;
        trouNoir = false ;
        desintegrateur = false ;
    }
    
    public boolean affecterJeton(Jeton jeton){
        if (jetonCourant == null){
            jetonCourant = jeton;
            if (presenceTrouNoir()==true) activerTrouNoir() ;
            if (presenceDesintegrateur()==true) desintegrateur=false ;
            return true;
        } else return false;
    }
    
    public String lireCouleurDuJeton(){
        if (jetonCourant == null) return "vide"; 
        else return jetonCourant.lireCouleur();
    }
    
    public Jeton recupererJeton(){
        return jetonCourant;
    }

    public boolean placerTrouNoir() { //V3
        if (trouNoir == false) { 
            trouNoir = true ;
            return true ;
        }
        else { return false ; }
    }
    
    public boolean presenceTrouNoir() {
        if (trouNoir == true){
            return true ;}
        else { return false ;}
    }
    
    public boolean activerTrouNoir() {
        if (presenceTrouNoir()== true) {
            jetonCourant = null ;
            trouNoir = false ;
            return true ; }
        else { return false ;}
    }
    
    public boolean supprimerJeton() { //V4
        if (jetonCourant != null) {
            jetonCourant = null ;
            return true ;
        }
        else return false ;
    }
    
    public boolean placerDesintegrateur(){
        if (desintegrateur == false) {
            desintegrateur = true ;
            return true ;}
        else return false ;
    }
    
    public boolean presenceDesintegrateur() {
        if (desintegrateur == true) return true ;
        else return false ;
    }
    
    public boolean recupererDesintegrateur() {
        if (desintegrateur == true) {
            return true ;}
        else return false ;
    }
}
