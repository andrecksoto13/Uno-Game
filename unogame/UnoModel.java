/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogame;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author asoto154
 */
public class UnoModel {

    ArrayList<Card> deck;
    ArrayList<Card> pile;
    ArrayList<Player> players;
    int whoseturn;
    boolean clockwise;

    public UnoModel(int numberOfPlayers) {

        deck = new ArrayList<>();

        String[] colors = {"red", "blue", "yellow", "green"};

        for (int i = 0; i < colors.length; i++) {

            for (int j = 0; j < 10; j++) {

                deck.add(new NumberCard(j, colors[i]));

                if (j != 0) {
                    deck.add(new NumberCard(j, colors[i]));

                }

            }
            for (int j = 0; j < 2; j++) {
                deck.add(new SkipCard(colors[i]));
                deck.add(new ReverseCard(colors[i]));
                deck.add(new DrawCard(colors[i]));

            }

        }

        for (int i = 0; i < 4; i++) {
            deck.add(new WildCard());
            deck.add(new Draw4WildCard());

        }
        Collections.shuffle(deck);

        players = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers; i++) {
            ArrayList<Card> hand = new ArrayList<>();
            for (int j = 0; j< 7 ; j++) {

                Card c = deck.remove(0);
                hand.add(c);
            }

            Player player = new Player(hand);
            players.add(player);

        }

        clockwise = true;

        pile = new ArrayList<>();

        int firstCorrect = 0;

        while (!(deck.get(firstCorrect) instanceof NumberCard) && !(deck.get(firstCorrect) instanceof ReverseCard)) {

            firstCorrect++;

        }
        if (deck.get(firstCorrect) instanceof ReverseCard) {
            clockwise = false;
        }
        pile.add(deck.remove(firstCorrect));
        
        drawCardsIfNeccesary();
    }

    public boolean canPlayCard(Card c, int playerNum) {

        if (playerNum != whoseturn) {
            return false;

        }
        if (!c.canPlayOn(pile.get(0))) {

            return false;
        }
        return true;

    }

    public void playCard(Card c, int playerNum) {

        if (canPlayCard(c, playerNum)) {

            players.get(playerNum).removeCard(c);
            pile.add(0, c);
            c.doSpeacialEffects(this);
            if(!(c instanceof WildCard)){
                setToNextTurn();
                
            }

            
            
        }
    }
    
    public void drawCardsIfNeccesary(){
        boolean hasPlayableCard = false;

            while (hasPlayableCard == false ) {
                for (int i = 0; i < players.get(whoseturn).getHand().size(); i++) {

                    if ( players.get(whoseturn).getHand().get(i).canPlayOn(getPile(0))) {
                        hasPlayableCard = true;

                    }

                }
                if (hasPlayableCard == false) {

                    drawCard( players.get(whoseturn));
                }
            }
      
    }
    
    public void setToNextTurn(){
        whoseturn= getNextTurn();
        drawCardsIfNeccesary();
        
    }

    public Card getPile(int pil) {
        return pile.get(0);

    }

    public Player getPlayer(int p) {
        return players.get(p);
    }

    public int getNextTurn() {
        
        if (clockwise == true) {
            if (whoseturn == players.size() - 1) {

                return 0;
            } else {
                return whoseturn + 1;
            }

        } else {
            if (whoseturn == 0) {

                return players.size() - 1;

            }
            return whoseturn - 1;
        }
    }

    public void drawCardforPlayer(Player p) {
        Card c = deck.remove(0);
        p.addCard(c);

    }

    public int getWinner() {
      for (int i = 0; i < players.size(); i++){
          
          if (players.get(i).getHand().size() == 0){
              return i;
          }

        }
        return -1;

    }

    public void drawCard(Player p) {
        Card c = deck.remove(0);
        p.addCard(c);

    }

}
