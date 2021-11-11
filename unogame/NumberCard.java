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
public class NumberCard extends Card {

    private int number;

    public NumberCard(int n, String col) {
        super(col);
        number = n;
    }

    public int getnumber() {
        return number;
    }

    @Override
    public String toString() {
        return this.getColor() + " " + this.number;
    }

  @Override
   public boolean canPlayOn(Card c) {
        
        if ( c instanceof NumberCard){
            if ( ((NumberCard)c).number ==number) {
                return true;
            }
       
        } return super.canPlayOn(c);
    }

    @Override
    public void doSpeacialEffects(UnoModel m) {
     
    }
}