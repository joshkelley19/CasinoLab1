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
    private Deck deck = new Deck ();
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

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                hands[i].addCard(deck.dealCard());
            }

        }

        for (int i = 0; i < 6; i++) {
            playTrick(hands);
            resolveOrder();

        }


    }

    public void playAgram(List<Player> players, List<Card> setDeck) {

        deck.deck = setDeck;
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
            playTrick(hands);
            resolveOrder();
    }


    public void playTrick (CardHandler[] hands) {

        int cardVal;

        for (int i = 0; i < playerCount; i++) {
            cardVal = getPlayedCard(hands[i]);
            System.out.println(cardVal);
            playCard(cardVal, i);
        }

    }

    private void playCard (int cardVal, int index) {

            trick[index] = cardVal;

    }

    public boolean canPlaySuit (CardHandler hand) {

        if (playedSuit.equals("")) {
            playedSuit = hand.getHand().get(0).getSuit();
            return true;
        }

        for (Card card : hand.getHand()) {
            if (card.getSuit().equals(playedSuit)) {
                return true;
            }
        }

        return false;
    }


    public int getPlayedCard (CardHandler hand) {

        return playForNonHuman(hand);
    }

    private int playForNonHuman (CardHandler hand) {

        int index = 0;
        int lowest = 11;
        int cardVal;

        if (canPlaySuit(hand)) {
            for (Card card : hand.getHand()) {
                cardVal = ranks.indexOf(card.getRank()) + 3;
                if (card.getSuit().equals(playedSuit) && cardVal < lowest) {
                    lowest = cardVal ;
                    index = hand.getHand().indexOf(card);
                }
            }
        } else {
            index = 0;
            lowest = 0;
        }

        hand.getHand().remove(index);
        return lowest;
    }

    private void resolveOrder () {

    }

}

