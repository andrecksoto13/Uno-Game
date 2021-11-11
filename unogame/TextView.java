/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogame;

import java.awt.AWTEventMulticaster;
import java.awt.peer.CanvasPeer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asoto154
 */
public class TextView {

    private UnoModel model;

    public TextView(UnoModel m) {
        model = m;

    }

    public void print() {

        for (int i = 0; i < model.players.size(); i++) {

            ArrayList<Card> hand = model.players.get(i).getHand();

            System.out.println("player " + (i + 1) + " hand" + ":");

            for (int j = 0; j < hand.size(); j++) {

                System.out.println(hand.get(j));

            }
        }

        while (model.getWinner()== -1) {

            System.out.println("-------------------------------------------");

            System.out.println("the top card is " + model.getPile(0));

            System.out.println("-------------------------------------------");

            int turn = model.whoseturn;
            Scanner keyboard = new Scanner(System.in);

            System.out.println("It is players " + turn + "'s turn");

            Player player = model.getPlayer(turn);

            for (int i = 0; i < player.getHand().size(); i++) {
                System.out.println(i + ": " + player.getHand().get(i));

            }

            boolean hasPlayableCard = false;

            while (hasPlayableCard == false) {
                for (int i = 0; i < player.getHand().size(); i++) {

                    if (player.getHand().get(i).canPlayOn(model.getPile(0))) {
                        hasPlayableCard = true;

                    }

                }
                if (hasPlayableCard == false) {

                    model.drawCard(player);
                }
            }

            System.out.println("What card do you want to play ?");

            int call = keyboard.nextInt();

            if (model.canPlayCard(player.getHand().get(call), turn)) {
                model.playCard(player.getHand().get(call), turn);

            } else {
                System.out.println("###############################");
                System.out.println("Cannot Play!!!!!!!!!");
                System.out.println("################################");
            }
            Card top = model.pile.get(0);
          
// wild card
            if (top instanceof WildCard && top.getColor().equals("Wild")) {
                System.out.println("What color would you like to play?");
                String color = keyboard.next();
                ((WildCard) top).setColor(color);
                System.out.println("***************************");
                System.out.println("You must put a " + color + "  card ");
                System.out.println("***************************");

            }
        }
        System.out.println("GAME OVER !!!!");

    }

}
