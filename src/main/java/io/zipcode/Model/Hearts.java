package io.zipcode.Model;

/**
 * Created by jamescrawley on 10/12/16.
 */

import java.util.*;

public class Hearts {

    private boolean isRunning = true;
    private boolean heartsBroken = false;
    private int wonTrick;
    private String passDirection = "right";
    private String playedSuit = "SPADES";
    private Deck deck = new Deck ();
    private int[] points = {0, 0, 0, 0};
    private CardHandler[] playerOrder;
    private Card[] trick;
    private Map<Player, List<Card>> wonCard;
    private List<Player> playerNumber;

    public void playHearts(List<Player> players) {

    }

    public void playTrick () {

    }

    public void passCards (Card[] cards, CardHandler giving, CardHandler recieveing) {

    }

    private boolean canPlaySuit (CardHandler hand) {

        return false;
    }

    private boolean isBreakingHearts (Card card) {

        return false;
    }

    public Card getPlayedCard () {

        return null;
    }

    private void resolveTrick () {

    }

    private void resolveOrder () {

    }

    private void calculatePoints (List<Card> cards) {

    }

    private boolean didShootSun () {

        return false;
    }

    private boolean didShootMoon () {

        return false;
    }








}

