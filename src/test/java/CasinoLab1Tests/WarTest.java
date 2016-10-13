package CasinoLab1Tests;

import io.zipcode.Model.Card;
import io.zipcode.Model.War;
import org.junit.Test;

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
        assertEquals(expected, actual);
    }
}
