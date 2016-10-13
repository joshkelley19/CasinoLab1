package CasinoLab1Tests;

import io.zipcode.Model.CardHandler;
import io.zipcode.Model.Deck;
import io.zipcode.Model.GoFish;
import io.zipcode.Model.Player;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import static org.junit.Assert.*;
/**
 * Created by kyle on 10/13/16.
 */
public class GoFishTests {
    private ArrayList<CardHandler> cardHandlerArrayList = new ArrayList<>();
    private CardHandler hand;
    private Deck goFishTestDeck = new Deck();
    private ArrayList<Integer> testBets = new ArrayList<Integer>();
    private List<Player> players;
    private CardHandler dealerHand;
    Player kyle = new Player("kyle", 0);

    @Before
    public void setup(){
        

    }
}
