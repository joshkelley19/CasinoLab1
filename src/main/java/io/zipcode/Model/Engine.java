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

        int length = players.size();
        int startingPlayer = agram.getWonTrick();
        int currentPlayer;
        boolean validCard = false;

        currentPlayer = (startingPlayer + playerNum) % length;

        try {
            agram.playTrick(currentPlayer, cardIndex - 1);
            return true;

        } catch (CannotPlayCardException e) {
//            System.out.println("Error!");
            return false;

        }
    }


    public void finishAgramRound() {

        agram.resolveRound();
        agram.prepNextRound();

    }

    public String getAgramHand (int playerNum) {
        int length = players.size();
        int startingPlayer = agram.getWonTrick();
        int currentPlayer;
        currentPlayer = (startingPlayer + playerNum) % length;

        return agram.printHand(currentPlayer);

    }

}
