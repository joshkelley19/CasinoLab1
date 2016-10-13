package io.zipcode.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static com.sun.tools.doclint.Entity.empty;

/**
 * Created by kyle on 10/12/16.
 */
public class GoFish extends Engine {
    private ArrayList<CardHandler> goFishPlayers = new ArrayList<>();
    private CardHandler hand;
    private Deck goFishDeck = new Deck();
    private ArrayList<Integer> playerBets = new ArrayList<Integer>();
    private List<Player> players;
    private CardHandler dealerHand;

    public List<Player> getPlayers() {
        return players;
    }

    public CardHandler getHand(int indexNum) {
        return hand;
    }

    public void playGoFish(ArrayList<Player> players) {
        for (Player p : players) {
            goFishPlayers.add(new CardHandler(p));
        }
    }

    public void giveCards(ArrayList<CardHandler> goFishCards) {
        int numberOfCards;
        if (goFishPlayers.size() > 2) {
            numberOfCards = 5;
        } else {
            numberOfCards = 7;
        }
        int loop = numberOfCards * goFishCards.size();
        for (int i = 0; i < loop; i++) {
            goFishPlayers.get(i % goFishPlayers.size()).addCard(goFishDeck.dealCard());
        }
    }

    public CardHandler playGoFish() throws NoSuchElementException {
        while (goFishDeck.deck.size() > 0) {
            //UI prompt will ask for input, variable will be "choice"
            String choice = User.stringInput("Please enter a card");
            if (dealerHand.searchRankInHand(choice)) {
                dealerHand.removeCorrectCard(choice);
                this.hand.addCorrectCard(choice);
            } else {
                Card newCard = goFishDeck.dealCard();
                this.hand.addCard(newCard);
            }
        }
        return this.hand;
    }
}
