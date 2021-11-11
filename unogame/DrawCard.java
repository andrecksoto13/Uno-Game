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
public class DrawCard extends Card {

    public DrawCard(String col) {
        super(col);
    }

    public String toString() {
        return color + "Draw 2";
    }

    @Override
    public boolean canPlayOn(Card c) {
        if (c instanceof DrawCard) {
            return true;
        } else {

            return super.canPlayOn(c);
        }

    }

    @Override
    public void doSpeacialEffects(UnoModel m) {
        m.drawCardforPlayer(m.getPlayer(m.getNextTurn()));
        m.drawCardforPlayer(m.getPlayer(m.getNextTurn()));
    }

}
