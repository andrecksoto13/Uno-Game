/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogame;

import java.util.Random;

/**
 *
 * @author asoto154
 */
public abstract class Card {

    protected String color;

    public Card(String col) {
        color = col;
    }

    public String getColor() {
        return color;
    }
    
    public boolean canPlayOn(Card c) {
       
            return c.getColor().equals(this.getColor());
        
    }
    public abstract void doSpeacialEffects(UnoModel m);
}
