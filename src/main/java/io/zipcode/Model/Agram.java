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

        List<Card> playerHand = hand.getHand();

        if (playedSuit.equals("")) {
            return true;
        }

        for (Card card : playerHand) {
            if (card.getSuit().equals(playedSuit)) {
                return true;
            }
        }

        return false;
    }


    public int getPlayedCard (CardHandler hand, int cardIndex) throws CannotPlayCardException {

        List<Card> playerHand = hand.getHand();

        if (cardIndex > 6) {

            return playForNonHuman(hand);
        }

        Card card = playerHand.get(cardIndex);
        String suit = card.getSuit();

        if (playedSuit.equals("")) {

            playedSuit = suit;
            playerHand.remove(cardIndex);
            return ranks.indexOf(card.getRank()) + 3;

        } else if (playedSuit.equals(suit)) {

            playerHand.remove(cardIndex);
            return ranks.indexOf(card.getRank()) + 3;

        } else if (!canPlaySuit(hand)) {

            playerHand.remove(cardIndex);
            return 0;

        } else {
            throw new CannotPlayCardException("You cannot play this card.");
        }


    }

    private int playForNonHuman (CardHandler hand) {

        int index = 0;
        int lowest = 11;
        int cardVal;
        List<Card> playerHand = hand.getHand();

        if (canPlaySuit(hand)) {
            for (Card card : playerHand) {
                cardVal = ranks.indexOf(card.getRank()) + 3;
                if ((card.getSuit().equals(playedSuit) || playedSuit.equals("")) && cardVal < lowest) {
                    lowest = cardVal ;
                    index = playerHand.indexOf(card);
                }
            }
        } else {
            index = 0;
            lowest = 0;
        }

        playedSuit = (playedSuit.equals("")) ? playerHand.get(index).getSuit(): playedSuit;

        playerHand.remove(index);
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

    public String printHand (int index) {

        StringBuilder result = new StringBuilder();
        List<Card> hand = hands[index].getHand();

        for (Card card : hand) {

            result.append(card.getRank());
            result.append(" of ");
            result.append(card.getSuit());
            result.append(", ");
        }

        result.delete(result.length() - 2, result.length());

        return result.toString();
    }

    public int payout (Player player) {

        int bet = player.getBet();
        int balance = player.getBalance();

        if (players.indexOf(player) == wonTrick) {
            player.setBalance(balance + bet);
            return bet;
        } else {
            player.setBalance(balance - bet);
            return -bet;
        }

    }

}

