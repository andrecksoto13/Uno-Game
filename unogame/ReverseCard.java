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
public class ReverseCard extends Card {

    public ReverseCard(String col) {
        super(col);
    }

    @Override
    public String toString() {
        return color+ "Reverse";
    }

    @Override
    public boolean canPlayOn(Card c) {

        if (c instanceof ReverseCard) {

            return true;
        } else {

            return super.canPlayOn(c);
        }
    }

    @Override
    public void doSpeacialEffects(UnoModel m) {
        m.clockwise = !m.clockwise;
    }
}


