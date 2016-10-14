package io.zipcode.Model;

import io.zipcode.Model.*;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Heron on 10/12/16.
 */
public class CardHandlerTest {

    @Test
    public void createCardHandler(){
        Player playerA = new Player("Heron", 20);
        CardHandler cardHandler = new CardHandler(playerA);
        String actual = cardHandler.getPlayer().getName();
        String expected = "Heron";
        Assert.assertEquals("CardHolder's player name is Heron", actual, expected);
    }

    @Test
    public void addCardTest(){
        Player playerA = new Player("Me", 15);
        CardHandler cardHandler = new CardHandler(playerA);
        Card card = new Card("suitA", "rankA");
        cardHandler.addCard(card);
        int actual = cardHandler.getHand().size();
        int expected = 1;
        Assert.assertEquals("A card was added to the hand.", actual, expected);
    }

}
