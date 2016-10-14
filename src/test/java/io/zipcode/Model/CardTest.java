package io.zipcode.Model;

import io.zipcode.Model.*;
import org.junit.Test;
import org.junit.Assert;


/**
 * Created by Heron on 10/12/16.
 */
public class CardTest {

    @Test
    public void changeCardRank(){
        Card myCard = new Card("suitA", "rankA");
        myCard.setRank("rankB");
        String actual = myCard.getRank();
        String expected = "rankB";
        Assert.assertEquals("Rank has been changed", actual, expected);
    }
}
