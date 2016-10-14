package CasinoLab1Tests;

import io.zipcode.Model.Player;
import io.zipcode.Model.Roulette;
import io.zipcode.Model.RouletteHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 10/12/16.
 */
public class RouletteHandlerTest {

    List<Player> players = new ArrayList<Player>();
    RouletteHandler rlh1;
    @Before
    public void initialize() {
        players.add(new Player("adam", 100));
        players.add(new Player("john", 100));
        players.add(new Player("steve", 100));

        rlh1 = new RouletteHandler(players.get(0));
    }

    @Test
    public void setBetTypeAndPayoffTest1() {
        rlh1.setBetTypeAndPayoff(4);
        RouletteHandler.BetType expected = RouletteHandler.BetType.ONE_NUMBER;
        RouletteHandler.BetType actual = rlh1.getBetType();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setChosenNumberTest() {
        rlh1.setChosenNumber(15);
        int expected = 15;
        int actual = rlh1.getChosenNumber();

        Assert.assertEquals("Able to set number guess.", expected, actual);
    }

    @Test
    public void setBetTypeAndPayoffTest2() {
        rlh1.setBetTypeAndPayoff(4);
        int expected = 35;
        int actual = rlh1.getPayoff();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPlayerTest() {
        String expected = "adam";
        String actual = rlh1.getPlayer().getName();

        Assert.assertEquals(expected, actual);
    }

}
