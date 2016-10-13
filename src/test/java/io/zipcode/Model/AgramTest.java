package io.zipcode.Model;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

/**
 * Created by James Crawley on 10/12/16.
 */
public class AgramTest {


    Agram game = new Agram();
    List<Player> players = new ArrayList<Player>();
    Player[] playArr = {new Player("John", 100), new Player("Jack", 100), new Player("Jen", 100), new Player("Jez", 100)};
    String[] ranks = {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN","ACE"};
    String [] suits = {"HEARTS", "SPADES", "DIAMONDS", "CLUBS"};
    List<Card> deck = new ArrayList<Card>();

    @Test
    public void wonTrickTest () {

        for(int i=0; i<ranks.length; i++) {
            for(int j=0; j<suits.length; j++) {
                deck.add(new Card(suits[j], ranks[i]));
            }
        }

        players = Arrays.asList(playArr);
        game.playAgram(players, deck);
        for (int i = 0; i < 4; i++) {
            try {
                game.playTrick(i, 7);
            } catch (CannotPlayCardException e) {
                System.out.println("Error");
            }
        }

        assertEquals("Player 4 should have won the trick", 3, game.getWonTrick());

    }


    @Test
    public void playedSuitTest () {

        for(int i=0; i<ranks.length; i++) {
            for(int j=0; j<suits.length; j++) {
                deck.add(new Card(suits[j], ranks[i]));
            }
        }

        players = Arrays.asList(playArr);
        game.playAgram(players, deck);
        for (int i = 0; i < 4; i++) {
            try {
                game.playTrick(i, 7);
            } catch (CannotPlayCardException e) {
                System.out.println("Error");
            }
        }

        assertEquals("The played suit should be hearts", "HEARTS", game.getPlayedSuit());

    }


    @Test
    public void trickTest () {

        for(int i=0; i<ranks.length; i++) {
            for(int j=0; j<suits.length; j++) {
                deck.add(new Card(suits[j], ranks[i]));
            }
        }

        players = Arrays.asList(playArr);
        game.playAgram(players, deck);
        for (int i = 0; i < 4; i++) {
            try {
                game.playTrick(i, 7);
            } catch (CannotPlayCardException e) {
                System.out.println("Error");
            }
        }


        int[] expected = {3, 5, 6, 8};

        assertArrayEquals("The trick should contain 3,︎ 5, 6, 8︎", expected, game.getTrick());

    }

    @Test
    public void playersTest () {

        for(int i=0; i<ranks.length; i++) {
            for(int j=0; j<suits.length; j++) {
                deck.add(new Card(suits[j], ranks[i]));
            }
        }

        players = Arrays.asList(playArr);
        game.playAgram(players, deck);
        for (int i = 0; i < 4; i++) {
            try {
                game.playTrick(i, 7);
            } catch (CannotPlayCardException e) {
                System.out.println("Error");
            }
        }


        assertEquals("The list of players should match up︎", players, game.getPlayers());

    }

    @Test
    public void canPlaySuitTest () {

        for(int i=0; i<ranks.length; i++) {
            for(int j=0; j<suits.length; j++) {
                deck.add(new Card(suits[j], ranks[i]));
            }
        }

        players = Arrays.asList(playArr);
        game.playAgram(players, deck);
        for (int i = 0; i < 4; i++) {
            try {
                game.playTrick(i, 7);
            } catch (CannotPlayCardException e) {
                System.out.println("Error");
            }
        }


        assertTrue("The hand should be able to play the correct suit︎", game.canPlaySuit(game.getHand(0)));

    }

}
