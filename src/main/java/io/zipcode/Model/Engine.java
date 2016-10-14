package io.zipcode.Model;

import io.zipcode.View.Display;
import io.zipcode.View.UserInput;

import java.util.ArrayList;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Engine {

    Blackjack blackjack = new Blackjack();

    public ArrayList<Player> players = new ArrayList<>();

    public void createPlayer(String name,int balance){
        players.add(new Player(name,balance));
    }

    public int placeBet(int bet) throws InvalidBetException {
        if(bet<1) throw new InvalidBetException("");
        return bet;
    }

    public void playBlackjack(){

        blackjack.clearBlackjackHandlers();
        blackjack.clearDealerHand();
        blackjack.fillCardHandler(players);
        roundBlackjack();

    }

    public boolean loopPortion(int hitStay){
        if(hitStay == 1){
            roundBlackjack();
            return blackjack.compare();
        }else{
            return blackjack.endGameCompare();
        }
    }

    public int blackjackWinnings(int bet){
        int winnings = 0;
        if(blackjack.getWinners().size() > 0){winnings += bet;}else if(blackjack.getLosers().size() > 0){winnings -= bet;}
        return winnings;
    }

    private void roundBlackjack(){

        blackjack.hitDealer();
        for(CardHandler x : blackjack.getBlackjackCardHandlers()){
            blackjack.hitPlayer(x);
        }
        Display.printDealerHand(blackjack);
        for(CardHandler y : blackjack.getBlackjackCardHandlers()){
            Display.printUserName(y.getPlayer());
            Display.printUserHand(y.getHand());
        }
    }

}
