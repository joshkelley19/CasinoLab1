package CasinoLab1Tests;

import io.zipcode.Model.Player;
import io.zipcode.Model.Roulette;
import io.zipcode.Model.RouletteHandler;
import io.zipcode.Model.ValueOutOfRangeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 10/12/16.
 */
public class RouletteTest {

    Roulette rl;
    @Before
    public void initialize() {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("adam", 100)); players.add(new Player("john", 100)); players.add(new Player("marty", 100));
        rl = new Roulette(players);
    }

    @Test
    public void fillWheelTest() {
        int expected = 36;
        int actual = rl.getWheel().size();

        Assert.assertEquals("Wheel should hold 36 values.", expected, actual);
    }

    @Test
    public void getColorTest() {
        rl.spinWheel();
        String actual = rl.getColor();
        Assert.assertTrue(actual.equals("BLACK") || actual.equals("RED"));
    }

    @Test
    public void getNumberTest() {
        rl.spinWheel();
        int actual = rl.getNumber();

        Assert.assertTrue(actual > 0 && actual < 37);
    }

    @Test
    public void placeBetTest() {
        rl.placeBetType(0, 4);
        RouletteHandler.BetType expected = RouletteHandler.BetType.ONE_NUMBER;
        RouletteHandler.BetType actual = rl.getRouletteHandler(0).getBetType();

        Assert.assertEquals("Able to place bet type.", expected, actual);
    }

    @Test
    public void askForNumberTest() {
        rl.placeBetType(0, 4);
        rl.askforNumber(0, 5);

        int expected = 5;
        int acutal = rl.getRouletteHandler(0).getChosenNumber();

        Assert.assertEquals("Able to get number from user.", expected, acutal);
    }

    @Test (expected = ValueOutOfRangeException.class)
    public void askForNumberTest2() {
        rl.placeBetType(0, 4);
        rl.askforNumber(0, 100);
    }

    @Test
    public void payoffTest() {
        rl.placeBetType(0, 1);
        rl.spinWheel();
        rl.getRouletteHandler(0).getPlayer().setBet(10);
        int actual = rl.payoff();
        Assert.assertTrue(actual==-10 || actual==20);
    }
}
