package io.zipcode.Model;

/**
 * Created by jamescrawley on 10/12/16.
 */

import java.util.*;

public class Agram {

    private boolean isRunning = true;
    private int roundCount = 1;
    private int wonTrick;
    private int playerCount;
    private String playedSuit = "";
    private Deck deck = new AgramDeck ();
    private CardHandler[] hands;
    private int[] trick;
    List<String> ranks = Arrays.asList("THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN","ACE");
    private List<Player> players;


    public int getWonTrick () {

        return wonTrick;
    }


    public String getPlayedSuit () {

        return playedSuit;
    }

    public int[] getTrick () {

        return trick;
    }

    public List<Player> getPlayers () {

        return players;
    }

    public CardHandler getHand (int index) {

        return hands[index];
    }


    public void playAgram(List<Player> players) {

        playerCount = players.size();
        hands = new CardHandler[playerCount];
        trick = new int[playerCount];
        this.players = players;

        for (int i = 0; i < playerCount; i++) {
            hands[i] = new CardHandler(players.get(i));
        }

        for (int i = 0; i < playerCount; i++) {
            for (int j = 0; j < 6; j++) {

                hands[i].addCard(deck.dealCard());
            }

        }

    }

    public void playAgram(List<Player> players, List<Card> setDeck) {

        deck.deck = setDeck;
        playerCount = players.size();
        hands = new CardHandler[playerCount];
        trick = new int[playerCount];
        this.players = players;
        roundCount = 1;

        for (int i = 0; i < playerCount; i++) {
            hands[i] = new CardHandler(players.get(i));
        }

        for (int i = 0; i < playerCount; i++) {
            for (int j = 0; j < 6; j++) {
                hands[i].addCard(deck.dealCard());
            }

        }

    }


    public void playTrick (int playerNum, int cardIndex) throws CannotPlayCardException {

        int cardVal;

        cardVal = getPlayedCard(hands[playerNum], cardIndex);
        trick[playerNum] = cardVal;

    }


    public boolean canPlaySuit (CardHandler hand) {

        if (playedSuit.equals("")) {
            return true;
        }

        for (Card card : hand.getHand()) {
            if (card.getSuit().equals(playedSuit)) {
                return true;
            }
        }

        return false;
    }


    public int getPlayedCard (CardHandler hand, int cardIndex) throws CannotPlayCardException {

        if (cardIndex > 6) {

            return playForNonHuman(hand);
        }

        Card card = hand.getHand().get(cardIndex);
        String suit = card.getSuit();

        if (playedSuit.equals("")) {

            playedSuit = suit;
            hand.getHand().remove(cardIndex);
            return ranks.indexOf(card.getRank()) + 3;

        } else if (!canPlaySuit(hand)) {

            hand.getHand().remove(cardIndex);
            return 0;

        } else {
            throw new CannotPlayCardException();
        }


    }

    private int playForNonHuman (CardHandler hand) {

        int index = 0;
        int lowest = 11;
        int cardVal;

        if (canPlaySuit(hand)) {
            for (Card card : hand.getHand()) {
                cardVal = ranks.indexOf(card.getRank()) + 3;
                if ((card.getSuit().equals(playedSuit) || playedSuit.equals("")) && cardVal < lowest) {
                    lowest = cardVal ;
                    index = hand.getHand().indexOf(card);
                }
            }
        } else {
            index = 0;
            lowest = 0;
        }

        playedSuit = (playedSuit.equals("")) ? hand.getHand().get(index).getSuit(): playedSuit;
        
        hand.getHand().remove(index);
        return lowest;
    }


    public void resolveRound () {

        int highest = 0;
        int i = 0;

        for (int cardVal : trick) {

            if (cardVal > highest) {
                highest = cardVal;
                wonTrick = i;
            }
            i++;
        }
    }


    public void prepNextRound () {

        playedSuit = "";
        roundCount++;

    }

    public String printHand (CardHandler hand) {

        StringBuilder result = new StringBuilder();

        for (Card card : hand.getHand()) {

            result.append(card.getRank());
            result.append(" of ");
            result.append(card.getSuit());
            result.append(", ");
        }

        result.delete(result.length() - 2, result.length());

        return result.toString();
    }

}

