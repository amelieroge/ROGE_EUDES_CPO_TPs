package sp4_console_roge_eudes;

public class Grille {
    Cellule [][] CelluleJeu ;
    
    public Grille () {
        CelluleJeu = new Cellule[6][7]; // 6 se balader sur ligne / 7 se balader sur colonne
        for (int i = 0 ; i < 6 ; i++){
            for (int j = 0 ; j < 7 ; j++){
                CelluleJeu[i][j] = new Cellule(); // créé un tableau de cellules de la classe "Cellule"
            }
        }
    }
    
    public boolean ajouterJetonDansColonne(Jeton j,int n) {
        for (int i = 0 ; i <6  ; i++) {
            if (CelluleJeu[i][n].jetonCourant == null) {
                CelluleJeu[i][n].affecterJeton(j) ; // utilise la méthode affecterJeton de la classe 
                // "Cellule" pour remplir la grille
                return true ;
            }
        } 
        return false;
    }
    
    public int connaitreLigne(int c){
        if (CelluleJeu[5][c].jetonCourant != null) return 5 ; // si la dernière ligne de la colonne n'est 
        // pas vide, envoie la ligne la plus haute
        for (int i=0 ; i<5 ; i++){
            if (CelluleJeu[i][c].jetonCourant != null && CelluleJeu[i+1][c].jetonCourant == null){
                return i ; // retourne la dernière ligne pour laquelle la cellule du dessus est vide
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
        // teste si 4 jetons de la même couleur sont allignés horizontalement

        for (int k = 0 ; k <= 2 ; k++){
            for (int l = 0 ; l <= 6 ; l++){
                if (CelluleJeu[k][l].lireCouleurDuJeton() == CelluleJeu[k+1][l].lireCouleurDuJeton()
                        && CelluleJeu[k][l].lireCouleurDuJeton() == CelluleJeu[k+2][l].lireCouleurDuJeton()
                        && CelluleJeu[k][l].lireCouleurDuJeton() == CelluleJeu[k+3][l].lireCouleurDuJeton()
                        && CelluleJeu[k][l].lireCouleurDuJeton() == joueur.Couleur) return true;}}
        // teste si 4 jetons de la même couleur sont allignés verticalement 

        for (int a = 0 ; a <= 2 ; a++){
            for (int b = 0 ; b <= 3 ; b++){
                if (CelluleJeu[a][b].lireCouleurDuJeton() == CelluleJeu[a+1][b+1].lireCouleurDuJeton()
                        && CelluleJeu[a][b].lireCouleurDuJeton() == CelluleJeu[a+2][b+2].lireCouleurDuJeton()
                        && CelluleJeu[a][b].lireCouleurDuJeton() == CelluleJeu[a+3][b+3].lireCouleurDuJeton()
                        && CelluleJeu[a][b].lireCouleurDuJeton() == joueur.Couleur) return true;}}
        // teste si 4 jetons de la même couleur sont allignés en diagonale montante

        for (int m = 3 ; m <= 5 ; m++){
            for (int n = 0 ; n <= 3 ; n++){
                if (CelluleJeu[m][n].lireCouleurDuJeton() == CelluleJeu[m-1][n+1].lireCouleurDuJeton()
                        && CelluleJeu[m][n].lireCouleurDuJeton() == CelluleJeu[m-2][n+2].lireCouleurDuJeton()
                        && CelluleJeu[m][n].lireCouleurDuJeton() == CelluleJeu[m-3][n+3].lireCouleurDuJeton()
                        && CelluleJeu[m][n].lireCouleurDuJeton() == joueur.Couleur) return true;}}
        // teste si 4 jetons de la même couleur sont allignés en diagonale descendante
 
        return false;
    }
    
    public boolean etreRemplie(){
        if (colonneRemplie(1) && colonneRemplie(2) && colonneRemplie(3) && colonneRemplie(4) && colonneRemplie(5) && colonneRemplie(6) && colonneRemplie(0)) return true;
        else return false; // si toutes les colonnes sont remplies, renvoie true
    }
    
    public void viderGrille(){
       for (int i = 0 ; i < 5 ; i++){
            for (int j = 0 ; i < 6 ; j++){
                CelluleJeu[i][j].affecterJeton(null); // permet de vider la grille à la fin de la partie pour en faire une nouvelle
            }
        }
    }
    
    public void afficherGrilleSurConsole(){
        String res = "";
        String res1 = "";
        for (int i = 5 ; i >= 0 ; i--){ //lignes
            for (int j = 0 ; j <= 6 ; j++){ //colonnes
                if (CelluleJeu[i][j].presenceTrouNoir() ==true) res += "\u001B[34m O \u001B[30m"; //fait afficher les trous noirs par des O bleus
                if (CelluleJeu[i][j].presenceTrouNoir() ==false && CelluleJeu[i][j].presenceDesintegrateur()) res += "\u001B[35m § \u001B[30m";
                // fait afficher les desintégrateurs par des $ roses
                if (CelluleJeu[i][j].jetonCourant == null && CelluleJeu[i][j].presenceTrouNoir()==false
                        && CelluleJeu[i][j].presenceDesintegrateur()==false ) res += " x "; // fait affcicher les cellules vides par des x noirs
                else {if (CelluleJeu[i][j].lireCouleurDuJeton() == "rouge") res += ("\u001B[31m R \u001B[30m"); // fait afficher les jetons rouge par 
                // des R rouges
                     if (CelluleJeu[i][j].lireCouleurDuJeton() == "jaune") res += ("\u001B[33m J \u001B[30m");} // fait afficher les jetons jaunes 
                // par des J jaunes
            } 
            res1 += res + "\n"; // met la ligne créée dans res1 et va à la ligne
            res = ""; // reset res pour crééer la ligne suivante
        } 
        System.out.println(res1); // affiche res1 qui est la compliation des lignes
    }
    
    public boolean celluleOccupee(int ligne,int colonne){
        if (CelluleJeu[ligne][colonne].jetonCourant == null) return false;
        else return true;
    }
    
    public String lireCouleurDuJeton(int ligne, int colonne){
        return CelluleJeu[ligne][colonne].lireCouleurDuJeton();
    }
 
    public boolean colonneRemplie(int colonne){
        if (CelluleJeu[5][colonne].jetonCourant == null) return false;
        else return true;}
    
    public void tasserGrille(int colonne){
        for (int i = 0 ; i < 5 ; i++){
            if (CelluleJeu[i][colonne].jetonCourant == null && CelluleJeu[i+1][colonne].jetonCourant != null){ // détecte s'il y a un trou dans la grille
                for (int j = i ; j < 5 ; j++){
                    CelluleJeu[j][colonne].jetonCourant = CelluleJeu[j+1][colonne].jetonCourant; // descend le jeton du dessus
                    CelluleJeu[j+1][colonne].jetonCourant = null;}}} // annule le jeton déplacé pour pouvoir déplacer les jetons encore au dessus
    }
    
    public Jeton recupererJeton(int ligne, int colonne){
        if (CelluleJeu[ligne][colonne].recupererJeton() == null){
            return null;
        } else {        
        Jeton jetonARetourner = CelluleJeu[ligne][colonne].jetonCourant;
        CelluleJeu[ligne][colonne].jetonCourant = null;
        tasserGrille(colonne); // tasse la grille après avoir retité le jeton souhaité
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
