package CasinoLab1Tests;

import io.zipcode.Model.Player;
import io.zipcode.Model.Roulette;
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
}
