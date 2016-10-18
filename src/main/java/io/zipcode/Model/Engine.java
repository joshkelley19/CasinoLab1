package io.zipcode.Model;

import io.zipcode.View.Display;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Engine {

    //Instance variables //
    Roulette roulette;
    GoFish gofish;
    public ArrayList<Player> players = new ArrayList<>();//player info passed through casino,can manipulate without passing in/returning

    public void createPlayer(String name,int balance){
        players.add(new Player(name,balance));
    }

    public int placeBet(int bet) throws InvalidBetException {
        if(bet<1) throw new InvalidBetException("");
        return bet;
    }

    public int playRoulette(int bet, int betType, int numberGuess) {
        roulette = new Roulette(players);

        roulette.getRouletteHandler(0).getPlayer().setBet(placeBet(bet));
        roulette.placeBetType(0, betType);
        roulette.askforNumber(0, numberGuess);
        roulette.spinWheel();
        return roulette.payoff();
    }
    public int playGoFish(int bet) throws Exception{
        placeBet(bet);
        gofish = new GoFish(players);
        gofish.giveCards(players);
        gofish.setDealerHand();
        return bet;
    }
    public int goFishWin(int bet){

        gofish.determineWinner();
        gofish.determineWinnings(bet);
        return bet;
    }
    public List goFishLoop(String rank){
        return gofish.playTheGame(rank);
    }


    public boolean goFishGameOver() {
        return gofish.getDeckSize()>0;
    }
}
