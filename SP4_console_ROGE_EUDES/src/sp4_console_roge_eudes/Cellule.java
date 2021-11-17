/*
  v1 check
*/
package sp4_console_roge_eudes;

/* Cellule
- boolean trouNoir v2
- boolean desintegrateur v4

+ Cellule()
+ Jeton recupererJeton() v3
+ boolean supprimerJeton() v4
+ boolean placerTrouNoir() v2
+ boolean placerDesintegrateur() v4
+ boolean presenceTrouNoir() v2
+ boolean presenceDesintegrateur() v4
+ boolean recupererDesintegrateur() v4
+ boolean activerTrouNoir() v2
 */

public class Cellule {
    Jeton jetonCourant ;
    boolean trouNoir ;
    
    public Cellule () {
        jetonCourant = null ;
        trouNoir = false ;
    }
    
    public boolean affecterJeton(Jeton jeton){
        if (jetonCourant == null){
            jetonCourant = jeton;
            if (presenceTrouNoir()==true) activerTrouNoir() ;
            return true;
        } else return false;
    }
    
    public String lireCouleurDuJeton(){
        if (jetonCourant == null) return "vide"; 
        else return jetonCourant.lireCouleur();
    }
    
    public boolean placerTrouNoir() {
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
}

