/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogame;

/**
 *
 * @author asoto154
 */
public class WildCard extends Card {
    

    public WildCard() {
        super("Wild");
    }
    @Override
     public String toString() {
        return "Wild";
    }
     
     public void setColor(String c){
         color = c;
     }
    @Override
      public boolean canPlayOn(Card c) {

  
            return true;
        
    }

    @Override
    public void doSpeacialEffects(UnoModel m) {
    
    }
 
}
    
 
