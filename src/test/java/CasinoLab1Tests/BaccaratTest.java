package CasinoLab1Tests;

import io.zipcode.Model.Baccarat;
import io.zipcode.Model.Card;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by jalisahewitt on 10/13/16.
 */
public class BaccaratTest {

    Baccarat b;
    @Before

    public void setUp(){
        b = new Baccarat(5, "bank");
    }

    @Test
    public void firstDealTest(){
        b.firstDeal();
        int expected = 2;
        int actual = b.getPlayerHand().size();
        assertEquals("The plays hand should have a length of two", expected, actual);
    }

    @Test
    public void sumTest(){
        int expected = 15;
        int actual = b.sum(5,10);
        assertEquals("Sum should be 15", expected, actual);

    }

    @Test
    public void checkPlayerSumTest(){
        Card x = new Card("HEARTS", "NINE");
        Card y = new Card("HEARTS", "FIVE");
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(x);
        cards.add(y);
        b.setPlayerHand(cards);
        int actual= b.CheckplayerSum();
        int expected = 4;
        assertEquals("Sum should be 14 minus 10 which equals 4", expected, actual);

    }

    @Test
    public void checkDealerSum(){
        Card x = new Card("HEARTS", "ACE");
        Card y = new Card("HEARTS", "TWO");
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(x);
        cards.add(y);
        b.setDealerHand(cards);
        int actual= b.CheckDealerSum();
        int expected = 2;
        assertEquals("Sum should be 14 minus 10 which equals 2", expected, actual);

    }

    @Test
    public void playersThirdCardTest(){
        Card x = new Card("HEARTS", "NINE");
        Card y = new Card("HEARTS", "FIVE");
        Card i = new Card("HEARTS", "ACE");
        Card j = new Card("HEARTS", "TWO");
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> cards1 = new ArrayList<>();
        cards.add(x);
        cards.add(y);
        cards1.add(i);
        cards1.add(j);
        b.setPlayerHand(cards);
        b.setDealerHand(cards1);
        b.playersThirdCard();
        int expected = 3;
        int actual = b.getPlayerHand().size();
            assertEquals("Should have added third card to player", expected, actual);

    }

    @Test
    public void dealersThirdCardTest(){
        Card x = new Card("HEARTS", "NINE");
        Card y = new Card("HEARTS", "FIVE");
        Card k = new Card("HEARTS", "SEVEN");
        Card i = new Card("HEARTS", "ACE");
        Card j = new Card("HEARTS", "TWO");
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> cards1 = new ArrayList<>();
        cards.add(x);
        cards.add(y);
        cards.add(k);
        cards1.add(i);
        cards1.add(j);
        b.setPlayerHand(cards);
        b.setDealerHand(cards1);
        b.DealersThirdCard();
        int expected = 3;
        int actual = b.getDealerHand().size();
        assertEquals("Should have added third card to dealer", expected, actual);

    }

    @Test
    public void dealersThirdCard2Test(){
        Card x = new Card("HEARTS", "NINE");
        Card y = new Card("HEARTS", "FIVE");
        Card i = new Card("HEARTS", "ACE");
        Card j = new Card("HEARTS", "TWO");
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Card> cards1 = new ArrayList<>();
        cards.add(x);
        cards.add(y);
        cards1.add(i);
        cards1.add(j);
        b.setPlayerHand(cards);
        b.setDealerHand(cards1);
        b.DealersThirdCard();
        int expected = 3;
        int actual = b.getDealerHand().size();
        assertEquals("Should have added third card to dealer", expected, actual);


    }







}
