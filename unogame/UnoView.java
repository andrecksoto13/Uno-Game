/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unogame;

import apcscvm.DefaultControl;
import apcscvm.View;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import apcscvm.GraphicsUtilityFunctions;
import java.awt.Font;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import sun.java2d.pipe.Region;

/**
 *
 * @author asoto154
 */
public class UnoView extends DefaultControl<UnoModel> implements View<UnoModel> {

    private Player player;
    private int width;
    private int height;
    private int timer;
    private int numberofcards;
    private int messageduration;
    private BufferedImage unocardset;

    public UnoView(Player p) {

        player = p;
        messageduration = 150;
        numberofcards = p.getHand().size();
        try {
            unocardset = ImageIO.read(new File("uno-card-deck.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(UnoView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void board(Graphics g, int x, int y, int w, int h) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.GRAY);
        Font f = GraphicsUtilityFunctions.getFont(h / 12);

        GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "   Welcome to UNO ! ", f, w / 6, h / 10, w / 3, h / 10);

    }

    public void paintWildWindow(Graphics g, int x, int y, int w, int h) {

        ArrayList<Color> colors = new ArrayList<>();

        colors.add(Color.black);
        colors.add(Color.blue);
        colors.add(Color.GREEN);
        colors.add(Color.PINK);

        Color c = colors.get((timer / 4) % colors.size());

        g.setColor(c);

        Font f = GraphicsUtilityFunctions.getFont(h / 8);

        GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "Pick A Color ", f, x, y, w, (-h / 2) + h / 4);

        g.setColor(Color.red);
        g.fillRect(x, y, w, h / 4);
        g.setColor(Color.blue);
        g.fillRect(x, y + h / 4, w, h / 4);
        g.setColor(Color.yellow);
        g.fillRect(x, y + 2 * (h / 4), w, h / 4);
        g.setColor(Color.green);
        g.fillRect(x, y + 3 * (h / 4), w, h / 4);

    }

    public void paintAfterWild(Graphics g, UnoModel m, int x, int y, int w, int h) {

        g.setColor(stringToColor(m.getPile(0).getColor()));
        Font f = GraphicsUtilityFunctions.getFont(h / 10);

        GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "Color is " + m.getPile(0).getColor(), f, x, y, w, h);

    }

    public void paintCard(Graphics g, Card c, int x, int y, int w, int h) {

        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(Color.black);
        g.drawRect(x, y, w, h);

        Font f = GraphicsUtilityFunctions.getFont(h / 4);
        int ycord;

        if (c instanceof NumberCard) {
            if (c.getColor().equals("red")) {
                ycord = 0;
                int xcord = 0;
                for (int i = 0; i < 13; i++) {

                    xcord = 64 * ((NumberCard) c).getnumber();

                }
                BufferedImage card = unocardset.getSubimage(xcord, ycord, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("yellow")) {
                ycord = 96;
                int xcord = 0;
                for (int i = 0; i < 13; i++) {
                    xcord = 64 * ((NumberCard) c).getnumber();
                }
                BufferedImage card = unocardset.getSubimage(xcord, ycord, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("green")) {
                ycord = 96 * 2;
                int xcord = 0;
                for (int i = 0; i < 13; i++) {
                    xcord = 64 * ((NumberCard) c).getnumber();
                }
                BufferedImage card = unocardset.getSubimage(xcord, ycord, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("blue")) {

                ycord = 96 * 3;
                int xcord = 0;

                for (int i = 0; i < 13; i++) {
                    xcord = 64 * ((NumberCard) c).getnumber();
                }
                BufferedImage card = unocardset.getSubimage(xcord, ycord, 64, 97);
                g.drawImage(card, x, y, null);

            }
//            g.setColor(stringToColor(c.getColor()));
//
//            GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, ((NumberCard) c).getnumber() + "", f, x, y, w, h);

        } else if (c instanceof ReverseCard) {
            if (c.getColor().equals("red")) {
                BufferedImage card = unocardset.getSubimage(64 * 11, 0, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("yellow")) {
                BufferedImage card = unocardset.getSubimage(64 * 11, 96 * 1, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("green")) {
                BufferedImage card = unocardset.getSubimage(64 * 11, 96 * 2, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("blue")) {
                BufferedImage card = unocardset.getSubimage(64 * 11, 96 * 3, 64, 96);
                g.drawImage(card, x, y, null);

            }

//            g.setColor(stringToColor(c.getColor()));
//            GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "R", f, x, y, w, h);
        } else if (c instanceof DrawCard) {

            if (c.getColor().equals("red")) {

                BufferedImage card = unocardset.getSubimage(64 * 12, 0, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("yellow")) {
                BufferedImage card = unocardset.getSubimage(64 * 12, 96 * 1, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("green")) {
                BufferedImage card = unocardset.getSubimage(64 * 12, 96 * 2, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("blue")) {
                BufferedImage card = unocardset.getSubimage(64 * 12, 96 * 3, 64, 97);
                g.drawImage(card, x, y, null);

            }
//            g.setColor(stringToColor(c.getColor()));
//            GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "D2", f, x, y, w, h);

        } else if (c instanceof SkipCard) {

            if (c.getColor().equals("red")) {
                BufferedImage card = unocardset.getSubimage(64 * 10, 0, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("yellow")) {
                BufferedImage card = unocardset.getSubimage(64 * 10, 96 * 1, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("green")) {
                BufferedImage card = unocardset.getSubimage(64 * 10, 96 * 2, 64, 97);
                g.drawImage(card, x, y, null);

            } else if (c.getColor().equals("blue")) {
                BufferedImage card = unocardset.getSubimage(64 * 10, 96 * 3, 64, 97);
                g.drawImage(card, x, y, null);

            }

//             g.setColor(stringToColor(c.getColor()));
//            GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "S", f, x, y, w, h);
        } else if (c instanceof WildCard) {

            if (c instanceof Draw4WildCard) {

                BufferedImage card = unocardset.getSubimage(64 * 13, 96 * 4, 64, 98);
                g.drawImage(card, x, y, null);

//                g.setColor(stringToColor(c.getColor()));
//                GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "W4", f, x, y, w, h);
            } else {

                BufferedImage card = unocardset.getSubimage(64 * 13, 0, 64, 97);
                g.drawImage(card, x, y, null);

//                g.setColor(stringToColor(c.getColor()));
//                GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "W", f, x, y, w, h);
            }

        }
    }

    public Color stringToColor(String s) {
        if (s.equals("blue")) {
            return Color.BLUE;

        } else if (s.equals("red")) {
            return Color.RED;

        } else if (s.equals("yellow")) {
            return Color.YELLOW;
        } else if (s.equals("green")) {
            return Color.GREEN;
        }
        return Color.BLACK;
    }

    public void paintPileCard(Graphics g, UnoModel m, int x, int y, int w, int h) {

        Card hand = m.pile.get(0);

        paintCard(g, hand, x, y, 64, 96);

    }

    public void paintendGame(Graphics g, UnoModel m, int x, int y, int w, int h) {
        
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.black);
        colors.add(Color.blue);
        colors.add(Color.GREEN);
        colors.add(Color.PINK);

        Color c = colors.get((timer / 4) % colors.size());

        g.setColor(c);

        Font f = GraphicsUtilityFunctions.getFont(h / 7);

        GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, " End of Game: Player: " + (m.getWinner() + 1) + " Won ! ", f, 0, 0, w, h);

    }

    public void paintPlayersHand(Graphics g, int x, int y, int handW, int handH) {

        ArrayList<Card> hand = player.getHand();

        for (int i = 0; i < hand.size(); i++) {

            paintCard(g, hand.get(i), x + (handW / hand.size() * i), y, 64, 96);

        }

    }

    @Override
    public void handleMouseClick(UnoModel m, int eventAge, MouseEvent me) {

        super.handleMouseClick(m, eventAge, me);

        if (m.pile.get(0).getColor().equals("Wild")) {

            int colorselected = 0;

            if (me.getY() > height / 8 && me.getY() < height / 8 + height / 2) {

                if (me.getX() > 3 * (width / 4) && me.getX() < (3 * (width / 4)) + (width / 6)) {

                    colorselected = ((me.getY() - height / 8) / ((height / 2) / 4));

                    if (colorselected == 0) {
                        WildCard c = (WildCard) (m.pile.get(0));
                        c.setColor("red");

                    } else if (colorselected == 1) {
                        WildCard c = (WildCard) (m.pile.get(0));
                        c.setColor("blue");

                    } else if (colorselected == 2) {
                        WildCard c = (WildCard) (m.pile.get(0));
                        c.setColor("yellow");

                    } else if (colorselected == 3) {
                        WildCard c = (WildCard) (m.pile.get(0));
                        c.setColor("green");

                    }
                    m.setToNextTurn();
                }
            }

        } else if (me.getY() > height * 3 / 4 && me.getY() < height * 3 / 4 + height / 6) {

            if (me.getX() > width / 12 && me.getX() < width / 12 + player.getHand().size() * (width / 18)) {

                int cardselected = (me.getX() - width / 12) / (width / 18);
                Card picked = player.getHand().get(cardselected);

                if (m.canPlayCard(player.getHand().get(cardselected), m.whoseturn)) {
                    if (m.getPlayer(m.whoseturn) == player) {

                        m.playCard(player.getHand().get(cardselected), m.whoseturn);
                        numberofcards = numberofcards - 1;;
                    }
                }
            }
        }
    }

    @Override
    public void paint(UnoModel m, Graphics g, int w, int h) {

        if ((m.getWinner() == -1)) {

            width = w;
            height = h;
            timer = timer + 1;

            board(g, w, h, w, h);
            paintPlayersHand(g, w / 12, h * 3 / 4, player.getHand().size() * (w / 18), h / 6);
            paintPileCard(g, m, w / 4, h / 4, w / 8, h / 6);

            if (m.pile.get(0).getColor().equals("Wild") && player == m.getPlayer(m.whoseturn)) {
                paintWildWindow(g, 3 * (w / 4), h / 8, w / 6, h / 2);

            }

            if (m.getPile(0) instanceof WildCard && !(m.getPile(0).getColor().equals("Wild"))) {
                paintAfterWild(g, m, 0, 0, w, h);
            }

            g.setColor(Color.WHITE);
            Font f = GraphicsUtilityFunctions.getFont(h / 20);
            GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "It is player's " + (m.whoseturn + 1) + " turn !!", f, w / 4, 0, h / 10, w / 10);

            if (numberofcards < player.getHand().size()) {
                g.setColor(Color.red);
                Font fo = GraphicsUtilityFunctions.getFont(h / 15);

                GraphicsUtilityFunctions.drawStringWithFontInRectangle(g, "Number of cards drawn: " + (player.getHand().size() - numberofcards), fo, (w / 8) * 4, h / 5 * 3, h / 10, w / 10);

                messageduration = messageduration - 1;
                System.out.println(messageduration);

                if (messageduration == 0) {

                    numberofcards = player.getHand().size();
                    messageduration = 50;

                }
            }

        } else {

            paintendGame(g, m, w / 2, h / 5, w / 2, h / 2);

        }

    }
}
