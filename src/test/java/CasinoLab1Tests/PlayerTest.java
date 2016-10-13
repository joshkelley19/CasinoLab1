package CasinoLab1Tests;


import io.zipcode.Model.*;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by Heron on 10/12/16.
 */
public class PlayerTest {

    @Test
    public void setPlayerBalance() {
        Player myplayer = new Player("Me", 20);
        myplayer.setBalance(50);
        int actual = myplayer.getBalance();
        int expected = 70;
        Assert.assertEquals("The player balance changes", actual, expected);
    }

    @Test
    public void setPlayerBet(){
        Player myPlayer = new Player("Heron", 10);
        myPlayer.setBet(5);
        int actual = myPlayer.getBet();
        int expected = 5;
        Assert.assertEquals("The bet has been set", actual, expected);
    }

}
