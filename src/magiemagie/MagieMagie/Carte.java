/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magiemagie.MagieMagie;

import java.util.ArrayList;

/**
 *
 * @author Administrateur
 */
public class Carte {
    
    public enum TypeCarte {
        
        BAVE_DE_CRAPAUD,
        AILE_DE_CHAUVE_SOURIS,
        LAPIS_LAZULI,
        MANDRAGORE,
        CORNE_DE_LICORNE
        
    
    }   
    protected ArrayList<Carte>cartes;
    protected TypeCarte type;
    protected String nom;
    
    
    @Override
    public String toString() {
        return this.type.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    public TypeCarte getType() {
        return type;
    }

    public void setType(TypeCarte type) {
        this.type = type;
    }

    public ArrayList<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(ArrayList<Carte> cartes) {
        this.cartes = cartes;
    }

    

   
    
}
