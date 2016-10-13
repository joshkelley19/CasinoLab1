package io.zipcode.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Engine {
    public ArrayList<Player> players = new ArrayList<>();
    Agram agram = new Agram();

    public void createPlayer(String name,int balance){
        players.add(new Player(name,balance));
    }

    public int placeBet(int bet) throws InvalidBetException {
        if(bet<1) throw new InvalidBetException("");
        return bet;
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

}
