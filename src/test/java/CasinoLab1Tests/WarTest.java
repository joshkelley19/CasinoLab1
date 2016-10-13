package CasinoLab1Tests;

import io.zipcode.Model.Card;
import io.zipcode.Model.Player;
import io.zipcode.Model.War;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by zacharywasserman on 10/12/16.
 */
public class WarTest {
    @Test
    public void cardValueTest()
    {
        War war = new War();
        Card card = new Card("HEARTS", "ACE");
        int expected =  war.cardValue(card);
        int actual = 14;
        assertEquals("Returned in should be 14",expected, actual);
    }
    @Test
    public void getWinnerWinTest()
    {
        War war = new War();
        Card playerCard = new Card("HEARTS", "ACE");
        Card dealerCard = new Card("CLUBS", "KING");
        String expected = war.getWinner(playerCard, dealerCard);
        String actual = "player";
        assertEquals("Returned should be player", expected, actual);
    }
    @Test
    public void getWinnerLoseTest()
    {
        War war = new War();
        Card playerCard = new Card("HEARTS", "TWO");
        Card dealerCard = new Card("CLUBS", "KING");
        String expected = war.getWinner(playerCard, dealerCard);
        String actual = "dealer";
        assertEquals("Returned should be dealer", expected, actual);
    }
    @Test
    public void getWinnerTieTest()
    {
        War war = new War();
        Card playerCard = new Card("HEARTS", "KING");
        Card dealerCard = new Card("CLUBS", "KING");
        String expected = war.getWinner(playerCard, dealerCard);
        String actual = null;
        assertEquals("Returned should be null", expected, actual);
    }
    @Test
    public void warPayOutWinTest()
    {
        War war = new War();
        List<Player> players = new ArrayList<Player>();
        Player player = new Player("Guts", 10000);
        players.add(player);
        player.setBet(500);
        war.warPayOut(players, "player");
        int expected = 10500;
        int actual = player.getBalance();
        assertEquals("returned should be 10500",expected, actual);

    }
    @Test
    public void warPayOutLoseTest()
    {
        War war = new War();
        List<Player> players = new ArrayList<Player>();
        Player player = new Player("Guts", 10000);
        players.add(player);
        player.setBet(500);
        war.warPayOut(players, "dealer");
        int expected = 9500;
        int actual = player.getBalance();
        assertEquals("Returned should be 9500", expected, actual);

    }
}
