package io.zipcode.Model;

/**
 * Created by jamescrawley on 10/12/16.
 */

import java.util.*;

public class Agram {

    private boolean isRunning = true;
    private int roundCount = 1;
    private int wonTrick;
    private String playedSuit = "CLUBS";
    private Deck deck = new Deck ();
    private CardHandler[] hands;
    private int[] trick;
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

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 13; j++) {
//                hands[0].addCard(deck.dealCard());
//            }
//
//        }
//
//        for (int i = 0; i < 6; i++) {
//           passCards();
//            playTrick();
//            resolveTrick();
//            resolveOrder();
//
//        }
//
//        for (int i = 0; i < 4; i ++) {
//            calculatePoints();
//        }

    }

    public void playAgram(List<Player> players, List<Card> setDeck) {

//        deck.deck = setDeck;

//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 6; j++) {
//                hands[0].addCard(deck.dealCard());
//            }
//
//        }

//            playTrick();
//            resolveOrder();
//

    }


    public void playTrick (CardHandler[] hands) {

//        Card card;

//        for (int i = 0; i < 4; i++) {
//            card = getPlayedCard(hand[i]);
//            playCard(card, i);
//        }

    }

    private void playCard (Card card, int index) {

//            trick[index] = card;

    }

    public boolean canPlaySuit (CardHandler hand) {

        return false;
    }


    public Card getPlayedCard (CardHandler hand) {

//        if (canPlaySuit(hand)) {
//            play first card that matches suit
//        } else {
//            play first card
//        }

        return null;
    }


    private void resolveOrder () {

    }

}

