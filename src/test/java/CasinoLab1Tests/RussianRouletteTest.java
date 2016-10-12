package CasinoLab1Tests;

import io.zipcode.Model.Player;
import io.zipcode.Model.RussianRoulette;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by zacharywasserman on 10/12/16.
 */
public class RussianRouletteTest
{
    @Test
    public void loadGunTest()
    {
        RussianRoulette rr = new RussianRoulette();
        int actual = rr.loadGun();
        assertTrue(0 <= actual && actual <= 5);
    }
    @Test
    public void pullTriggerTest()
    {
        RussianRoulette rr = new RussianRoulette();
        boolean actual = rr.pullTrigger(0, 0);
        boolean expected = false;
        assertEquals("Should return false",expected, actual);
    }
    @Test
    public void pullTriggerTest2()
    {
        RussianRoulette rr = new RussianRoulette();
        boolean actual = rr.pullTrigger(0, 1);
        boolean expected = true;
        assertEquals("Should return true",expected, actual);
    }
    @Test
    public void removePlayerTest()
    {
        RussianRoulette rr = new RussianRoulette();
        List<Player> players= new ArrayList<Player>();
        Player player1 = new Player("Guts", 100);
        Player player2 = new Player("Griffith", 100);
        Player player3 = new Player("Casca", 100);
        Player player4 = new Player("Rickett", 100);
        Player player5 = new Player("Puck", 100);
        Player player6 = new Player("Gambino", 100);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        rr.removePlayer(players, 1);
        int actual = players.size();
        int expected = 5;
        assertEquals("Array size should be 5",actual, expected);
    }


}
