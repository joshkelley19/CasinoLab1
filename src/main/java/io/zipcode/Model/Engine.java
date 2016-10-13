package io.zipcode.Model;

import java.util.ArrayList;

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

    public void initializeAgram () {
        agram.playAgram(players);
    }

    public int playAgram(int cardIndex, int playerNum) {

        int length = players.size();
        int startingPlayer = agram.getWonTrick();
        int currentPlayer;
        boolean validCard = false;

        currentPlayer = (startingPlayer + playerNum) % length;
        while (!validCard) {
            try {
                agram.playTrick(currentPlayer, cardIndex);
                validCard = true;

            } catch (CannotPlayCardException e) {

            }
        }

        return 0;
    }

    public void finishAgramRound() {

        agram.resolveRound();
        agram.prepNextRound();

    }

    public void getAgramHand (int playerNum) {
        int length = players.size();
        int startingPlayer = agram.getWonTrick();
        int currentPlayer;
        currentPlayer = (startingPlayer + playerNum) % length;

        agram.printHand(currentPlayer);

    }

}
