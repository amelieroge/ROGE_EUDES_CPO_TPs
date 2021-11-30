/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_roge_eudes;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Anais
 */
 public class CelluleGraphique extends JButton {
    Cellule celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/Image/celluleVide.png"));
    ImageIcon img_desintegrateur = new javax.swing.ImageIcon(getClass().getResource("/Image/desintegrateur.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/Image/trouNoir.png"));
    ImageIcon img_jJaune = new javax.swing.ImageIcon(getClass().getResource("/Image/jetonJaune.png"));
    ImageIcon img_jRouge = new javax.swing.ImageIcon(getClass().getResource("/Image/jetonRouge.png"));
    
    public CelluleGraphique (Cellule uneCellule) {
        celluleAssociee = uneCellule ;
        
    }
    
    @Override
    public void paintComponent (Graphics G){
        super.paintComponent(G);
        
        if (celluleAssociee.presenceTrouNoir()==true){
            System.out.println("zerefghj");
            setIcon(img_trouNoir);
        }
        else if (celluleAssociee.presenceDesintegrateur()){
            setIcon(img_desintegrateur);
        }
        else {
            String couleur_jeton = celluleAssociee.lireCouleurDuJeton();
            switch (couleur_jeton){
                case "vide" :
                    setIcon(img_vide);
                    break;
                case "rouge" : 
                    setIcon(img_jRouge);   
                    break;
                case "jaune" : 
                    setIcon(img_jJaune);
                    break;
            }
        }
    }
}
