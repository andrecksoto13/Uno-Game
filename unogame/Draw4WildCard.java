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
public class Draw4WildCard extends WildCard{
    
    public Draw4WildCard() {
        super();
    }
        
    
    @Override
    public String toString() {
        return "Draw 4 Wild";
    }
    
    @Override
     public boolean canPlayOn(Card c) {
            return true;
        } 
     @Override
    public void doSpeacialEffects(UnoModel m) {
            for (int i = 0; i < 4 ; i++){
        m.drawCardforPlayer(m.getPlayer(m.getNextTurn()));
    }
    }

 
    
    

}
