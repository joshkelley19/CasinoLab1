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
        //int actual = rr.loadGun();
        //assertTrue(0 <= actual && actual <= 5);
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
        Player player1 = new Player("Guts", 10000);
        Player player2 = new Player("Griffith", 10000);
        Player player3 = new Player("Casca", 10000);
        Player player4 = new Player("Rickett", 10000);
        Player player5 = new Player("Puck", 10000);
        Player player6 = new Player("Gambino", 10000);
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
    @Test
    public void losersBetTest()
    {
        RussianRoulette rr = new RussianRoulette();
        List<Player> players= new ArrayList<Player>();
        Player player1 = new Player("Guts", 10000);
        Player player2 = new Player("Griffith", 10000);
        Player player3 = new Player("Casca", 10000);
        Player player4 = new Player("Rickett", 10000);
        Player player5 = new Player("Puck", 10000);
        Player player6 = new Player("Gambino", 10000);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        int expected = rr.losersBet(players, 0);
        int actual = 10000;
        assertEquals(expected, actual);
    }
    @Test
    public void payOut()
    {
        RussianRoulette rr = new RussianRoulette();
        List<Player> players= new ArrayList<Player>();
        Player player1 = new Player("Guts", 10000);
        Player player2 = new Player("Griffith", 10000);
        Player player3 = new Player("Casca", 10000);
        Player player4 = new Player("Rickett", 10000);
        Player player5 = new Player("Puck", 10000);
        Player player6 = new Player("Gambino", 10000);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        rr.payOut(players, 10000);
        rr.removePlayer(players, 2);
        int actual = player1.getBalance();
        int expected = 12000;
        assertEquals("expected should be 12000",expected, actual);
    }
    @Test
    public void fillRosterTest(){
        RussianRoulette rr = new RussianRoulette();
        List<Player> players = new ArrayList<Player>();
        rr.fillRoster(players);
        int actual = players.size();
        int expected = 6;
        assertEquals(expected, actual);
    }
    @Test
    public void fillRosterTest2()
    {
        RussianRoulette rr = new RussianRoulette();
        List<Player> players = new ArrayList<Player>();
        Player player1 = new Player("Guts", 10000);
        Player player2 = new Player("Griffith", 10000);
        Player player3 = new Player("Casca", 10000);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        rr.fillRoster(players);
        int actual = players.size();
        int expected = 6;
        assertEquals(expected, actual);
    }
    @Test
    public void emptyRosterTest()
    {
        RussianRoulette rr = new RussianRoulette();
        List<Player> players = new ArrayList<Player>();
        Player player1 = new Player("Guts", 10000);
        Player player2 = new Player("Shady Stranger", 10000);
        Player player3 = new Player("Shady Stranger", 10000);
        Player player4 = new Player("Shady Stranger", 10000);
        Player player5 = new Player("Shady Stranger", 10000);
        Player player6 = new Player("Shady Stranger", 10000);
        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);
        players.add(player5);
        players.add(player6);
        rr.emptyRoster(players);
        int actual = players.size();
        int expected = 1;
        assertEquals(expected, actual);
    }


}
