/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogame;

import java.util.ArrayList;

/**
 *
 * @author asoto154
 */
public class Player {
     
  private ArrayList<Card> hand ;

    public ArrayList<Card> getHand() {
        return hand;
    }
   public Player(ArrayList<Card> h){
       hand = h;
       
   }
   public void removeCard(Card c) {
       
       hand.remove(c);
       
   }
   
   public void addCard(Card c){
       hand.add(c);
       
    
}

   
    
}
