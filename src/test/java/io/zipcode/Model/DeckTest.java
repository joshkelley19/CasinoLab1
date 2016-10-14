package io.zipcode.Model;

import io.zipcode.Model.*;
import org.junit.Test;
import org.junit.Assert;
import java.util.*;

/**
 * Created by Heron on 10/12/16.
 */
public class DeckTest {

    @Test
    public void makeDeck(){
        Deck myDeck = new Deck();
        List<Card> temp = myDeck.getDeck();
        for(Card i : temp){
            System.out.println(i.getRank() + " " + i.getSuit());
        }
        System.out.println(myDeck.getDeck().size() + " cards");
    }

    @Test
    public void dealCard(){
        Deck myDeck = new Deck();
        List<Card> original = myDeck.getDeck();
        myDeck.dealCard();
        int actual = 51;
        Assert.assertEquals("One card was removed from deck.", actual, (original.size()));
    }

}
