package io.zipcode.Model;

import io.zipcode.Model.*;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Heron on 10/13/16.
 */
public class BlackjackTest {

    @Test
    public void hitPlayerTest(){
        Player playerA = new Player("Heron", 25);
        Blackjack blackjack = new Blackjack();
        CardHandler cardHandlerA = new CardHandler(playerA);
        blackjack.hitPlayer(cardHandlerA);
        int actual = cardHandlerA.getHand().size();
        int expected = 1;
        Assert.assertEquals("A card was added to hand", actual, expected);
    }

    @Test
    public void checkTotalTest(){
        Card cardA = new Card("HEARTS", "TWO");
        Card cardB = new Card("SPADES", "ACE");
        Card cardC = new Card("HEARTS", "ACE");
        List<Card> tempList = new ArrayList<>();
        tempList.add(cardA);
        tempList.add(cardB);
        tempList.add(cardC);
        Blackjack blackjack = new Blackjack();
        int actual = blackjack.checkTotal(tempList);
        int expected = 14;
        Assert.assertEquals("The total is accurate", actual, expected);

    }

    @Test
    public void hitDealerTest(){
        Blackjack blackjack = new Blackjack();
        blackjack.hitDealer();
        blackjack.hitDealer();
        int actual = blackjack.getDealerHand().size();
        int expected = 2;
        Assert.assertEquals("The dealer hand is hit", actual, expected);
    }

    @Test
    public void dealerOverdrawnTest(){
        Blackjack blackjack = new Blackjack();
        for(int i=0; i<= 22; i++){blackjack.hitDealer();}
        boolean actual = blackjack.compare();
        Assert.assertEquals("The dealer overdrew and ended game.", actual, true);
    }

    @Test
    public void dealerUnder21Test(){
        Blackjack blackjack = new Blackjack();
        boolean actual = blackjack.compare();
        Assert.assertEquals("Dealer is under 21", actual, false);
    }

    @Test
    public void endGameTest(){
        Blackjack blackjack = new Blackjack();
        boolean actual = blackjack.endGameCompare();
        Assert.assertEquals("Game ends when compare", actual, true);
    }

    @Test
    public void fillCardHandlerTest(){
        Player playerA = new Player("Heron", 25);
        List<Player> tempList = new ArrayList<>();
        tempList.add(playerA);
        Blackjack blackjack = new Blackjack();
        blackjack.fillCardHandler(tempList);
        int actual = blackjack.getBlackjackCardHandlers().size();
        Assert.assertEquals("A player was given a CardHandler in the array", actual, 1);
    }

}
