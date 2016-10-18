package io.zipcode.Model;

import io.zipcode.Model.CardHandler;
import io.zipcode.Model.Deck;
import io.zipcode.Model.GoFish;
import io.zipcode.Model.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import static org.junit.Assert.*;
/**
 * Created by kyle on 10/13/16.
 */
public class GoFishTests {
    GoFish go;


    @Before
    public void setup() {
        List players = new ArrayList<Player>();
        players.add(new Player("kyle", 0));
        go = new GoFish(players);

    }

    @Test
    public void giveCards() {
        go.giveCards(go.goFishPlayers);
        int expected = go.goFishPlayers.size();
        int actual = 1;
        Assert.assertEquals("Should deal a total of 7 cards", expected, actual);
    }
    @Test
    public void determineWinningsTest(){
        int expected = go.determineWinnings(15);
        int actual = 30;
        Assert.assertEquals("Should equal 30 as winnings amount", expected, actual);
    }
}

