package io.zipcode.Model;

import java.util.ArrayList;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Engine {
    //Instance variables //
    Roulette roulette;
    private ArrayList<Player> players = new ArrayList<>();
    private Slots slots = new Slots();
    private boolean isRunning=true;

    public void createPlayer(String name, int balance){
        players.add(new Player(name,balance));
    }

    private int placeBet(int bet) throws InvalidBetException {
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

    public int playSlots(int bet) throws InvalidBetException {
        if (bet < 1) throw new InvalidBetException("Invalid Bet Amount");
        players.get(0).setBet(bet);
        int[] symbols = slots.pull();
        int chance = slots.reel(symbols);
        int winnings = slots.gameOver(players.get(0).getBet(),chance,symbols[1]);
        players.get(0).setBalance(winnings);
        players.get(0).setBet(0);
        return winnings;
    }

}
