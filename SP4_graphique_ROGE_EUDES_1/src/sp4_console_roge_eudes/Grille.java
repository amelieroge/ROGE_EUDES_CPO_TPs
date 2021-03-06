package sp4_console_roge_eudes;

public class Grille {
    Cellule [][] CelluleJeu ;
    
    public Grille () {
        CelluleJeu = new Cellule[6][7]; // 6 se balader sur ligne / 7 se balader sur colonne
        for (int i = 0 ; i < 6 ; i++){
            for (int j = 0 ; j < 7 ; j++){
                CelluleJeu[i][j] = new Cellule();
            }
        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton j,int n) {
        for (int i = 0 ; i <6  ; i++) {
            if (CelluleJeu[i][n].jetonCourant == null) {
                CelluleJeu[i][n].affecterJeton(j) ;
                return true ;
            }
        } 
        return false;
    }
    
    public int connaitreLigne(int c){
        if (CelluleJeu[5][c].jetonCourant != null) return 5 ;
        for (int i=0 ; i<5 ; i++){
            if (CelluleJeu[i][c].jetonCourant != null && CelluleJeu[i+1][c].jetonCourant == null){
                return i ;
            }
        } 
        return 0 ;
    }
    
    public boolean etreGagnantePourJoueur(Joueur joueur){
        for (int i = 0 ; i <= 5 ; i++){
            for (int j = 0 ; j <= 3 ; j++){
                if ((CelluleJeu[i][j].lireCouleurDuJeton() == CelluleJeu[i][j+1].lireCouleurDuJeton()
                        && CelluleJeu[i][j].lireCouleurDuJeton() == CelluleJeu[i][j+2].lireCouleurDuJeton()
                        && CelluleJeu[i][j].lireCouleurDuJeton() == CelluleJeu[i][j+3].lireCouleurDuJeton()
                        && CelluleJeu[i][j].lireCouleurDuJeton() == joueur.Couleur)) return true;}}

        for (int k = 0 ; k <= 2 ; k++){
            for (int l = 0 ; l <= 6 ; l++){
                if (CelluleJeu[k][l].lireCouleurDuJeton() == CelluleJeu[k+1][l].lireCouleurDuJeton()
                        && CelluleJeu[k][l].lireCouleurDuJeton() == CelluleJeu[k+2][l].lireCouleurDuJeton()
                        && CelluleJeu[k][l].lireCouleurDuJeton() == CelluleJeu[k+3][l].lireCouleurDuJeton()
                        && CelluleJeu[k][l].lireCouleurDuJeton() == joueur.Couleur) return true;}}

        for (int a = 0 ; a <= 2 ; a++){
            for (int b = 0 ; b <= 3 ; b++){
                if (CelluleJeu[a][b].lireCouleurDuJeton() == CelluleJeu[a+1][b+1].lireCouleurDuJeton()
                        && CelluleJeu[a][b].lireCouleurDuJeton() == CelluleJeu[a+2][b+2].lireCouleurDuJeton()
                        && CelluleJeu[a][b].lireCouleurDuJeton() == CelluleJeu[a+3][b+3].lireCouleurDuJeton()
                        && CelluleJeu[a][b].lireCouleurDuJeton() == joueur.Couleur) return true;}}

        for (int m = 3 ; m <= 5 ; m++){
            for (int n = 0 ; n <= 3 ; n++){
                if (CelluleJeu[m][n].lireCouleurDuJeton() == CelluleJeu[m-1][n+1].lireCouleurDuJeton()
                        && CelluleJeu[m][n].lireCouleurDuJeton() == CelluleJeu[m-2][n+2].lireCouleurDuJeton()
                        && CelluleJeu[m][n].lireCouleurDuJeton() == CelluleJeu[m-3][n+3].lireCouleurDuJeton()
                        && CelluleJeu[m][n].lireCouleurDuJeton() == joueur.Couleur) return true;}}
 
        return false;
    }
    
    public boolean etreRemplie(){
        if (colonneRemplie(1) && colonneRemplie(2) && colonneRemplie(3) && colonneRemplie(4) && colonneRemplie(5) && colonneRemplie(6) && colonneRemplie(0)) return true;
        else return false;
    }
    
    public void viderGrille(){
       for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; i < 6 ; j++){
                CelluleJeu[i][j].affecterJeton(null);
            }
        }
    }
    
    public void afficherGrilleSurConsole(){
        String res = "";
        String res1 = "";
        for (int i = 5 ; i >= 0 ; i--){ //lignes
            for (int j = 0 ; j <= 6 ; j++){ //colonnes
                if (CelluleJeu[i][j].presenceTrouNoir() ==true) res += "\u001B[34m O \u001B[30m";
                if (CelluleJeu[i][j].presenceTrouNoir() ==false && CelluleJeu[i][j].presenceDesintegrateur()) res += "\u001B[35m ?? \u001B[30m";
                if (CelluleJeu[i][j].jetonCourant == null && CelluleJeu[i][j].presenceTrouNoir()==false
                        && CelluleJeu[i][j].presenceDesintegrateur()==false ) res += " x ";
                else {if (CelluleJeu[i][j].lireCouleurDuJeton() == "rouge") res += ("\u001B[31m R \u001B[30m");
                     if (CelluleJeu[i][j].lireCouleurDuJeton() == "jaune") res += ("\u001B[33m J \u001B[30m");}
                //System.out.println(res);
            } 
            res1 += res + "\n";
            res = "";
        } 
        System.out.println(res1);
    }
    
    public boolean celluleOccupee(int ligne,int colonne){
        if (CelluleJeu[ligne][colonne] == null) return false;
        else return true;
    }
    
    public String lireCouleurDuJeton(int ligne, int colonne){
        return CelluleJeu[ligne][colonne].lireCouleurDuJeton();
    }
 
    public boolean colonneRemplie(int colonne){
        if (CelluleJeu[5][colonne] == null) return false;
        else return true;}
    
    public void tasserGrille(int colonne){
        for (int i = 0 ; i < 5 ; i++){
            if (CelluleJeu[i][colonne].jetonCourant == null && CelluleJeu[i+1][colonne].jetonCourant != null){
                for (int j = i ; j < 5 ; j++){
                    CelluleJeu[j][colonne].jetonCourant = CelluleJeu[j+1][colonne].jetonCourant;
                    CelluleJeu[j+1][colonne].jetonCourant = null;}}}
    }
    
    public Jeton recupererJeton(int ligne, int colonne){
        if (CelluleJeu[ligne][colonne].recupererJeton() == null){
            return null;
        } else {        
        Jeton jetonARetourner = CelluleJeu[ligne][colonne].jetonCourant;
        CelluleJeu[ligne][colonne].jetonCourant = null;
        tasserGrille(colonne);
        return jetonARetourner;}
    }
    
    public boolean placerTrouNoir(int n, int m) {
        if ( CelluleJeu[n][m].presenceTrouNoir()==false) {
             CelluleJeu[n][m].placerTrouNoir() ; 
        return true ; }
        else { return false ;}
    }
    
    public boolean placerDesintegrateur(int n,int m) { //V4
        if (CelluleJeu[n][m].presenceDesintegrateur()==false) {
            CelluleJeu[n][m].placerDesintegrateur() ;
            return true ; }
        else { return false ;
        }
    }
    
    public boolean supprimerJeton(int n,int m){
        if (CelluleJeu[n][m].jetonCourant != null) {
            CelluleJeu[n][m].jetonCourant = null ;
            return true ; }
        else { return false ;
        }
    }
}
