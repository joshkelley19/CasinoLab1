package io.zipcode.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Engine {

    //Instance variables //
    private Roulette roulette;
    private Agram agram = new Agram();
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

    public List<Player> getPlayers () {
        return players;
    }


    public void initializeAgram (List<Integer> bets) {
        int i = 0;
        agram.playAgram(players);

        for (Player player : players) {
            player.setBet(bets.get(i));
            i++;
        }
    }

    public boolean playAgram(int cardIndex, int playerNum) {

        try {
            agram.playTrick(playerNum, cardIndex - 1);
            return true;

        } catch (CannotPlayCardException e) {
            return false;

        }
    }


    public void finishAgramRound() {

        agram.resolveRound();
        agram.prepNextRound();

    }

    public String getAgramHand (int playerNum) {

        return agram.printHand(playerNum);

    }

    public void settleAgramBets (List<Integer> bets) {

        for (int i = 0; i < players.size(); i++) {
            bets.set(i, agram.payout(players.get(i)));
        }

    }

    public int getAgramStartingPlayer () {

        return agram.getWonTrick();
    }

    public String getAgramLastPlayed () {

        StringBuilder result = new StringBuilder();
        Card lastPlayed = agram.getLastPlayed();

        result.append(lastPlayed.getRank());
        result.append(" of ");
        result.append(lastPlayed.getSuit());

        return  result.toString();
    }

    public String getAgramPlayedSuit () {

        return agram.getPlayedSuit();
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
