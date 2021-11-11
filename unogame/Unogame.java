/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogame;

import apcscvm.CVMProgram;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asoto154
 */
public class Unogame {

    private static void text() {
        UnoModel m = new UnoModel(2);
        TextView v = new TextView(m);
        v.print();
    }

    private static void view() {
        
        System.out.println("How many players do you want to play");
      
        
        
        Scanner keyboard = new Scanner(System.in);
        
        int amountplayers = keyboard.nextInt();
        
        
        
        UnoModel m = new UnoModel(amountplayers);
     
        
        
        for (int i = 0; i < amountplayers; i++){

        UnoView v = new UnoView(m.getPlayer(i));
        
        CVMProgram program = new CVMProgram("Player " + (i +1), 800, 600, v, v, m);
        program.start();
        }
    }

    public static void main(String[] args) {
        // text();
        view();
    }

}
