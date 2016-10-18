package io.zipcode.Model;

import java.util.*;

/**
 * Created by kyle on 10/12/16.
 */
public class GoFish {

    //Fields -------------------------------------------------------

    public ArrayList<CardHandler> goFishPlayers = new ArrayList<>();
    public CardHandler hand;
    public Deck goFishDeck = new Deck();
    public ArrayList<Player> players;
    private CardHandler dealerHand;
    private boolean isRunning = true;
    int bet;

    //Constructor --------------------------------------------------
    public GoFish(List<Player> players) {
        for (Player p : players) {
            goFishPlayers.add(new CardHandler(p));
        }
    }

    //Methods --------------------------------------------------------

    public void setDealerHand() {
        int numberOfCards;
        if (goFishPlayers.size() > 2) {
            numberOfCards = 5;
        } else {
            numberOfCards = 7;
        }
        for (int i = 0; i <= numberOfCards; i++) {
            dealerHand.addCard(goFishDeck.dealCard());
        }
    }

    public void giveCards(List goFishCards) {
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

    public int getDeckSize() {
        return goFishDeck.getDeck().size();
    }

    public List<Card> playTheGame(String choice) {
        if (dealerHand.hasRankInHand(choice)) {
            dealerHand.removeCorrectCard(choice);
            this.hand.addCorrectCard(choice);
        } else {
            Card newCard = goFishDeck.dealCard();
            this.hand.addCard(newCard);
        }
        return hand.getHand();
    }

    public boolean determineWinner() {
        //players hand has more cards than other players hands, he is the winner
        //return that player as the winner
        if (goFishPlayers.get(0).getHand().size() > dealerHand.getHand().size()) {
            return true;
        } else {
            return false;
        }
    }

    public int determineWinnings(int bet) {
        int winnings;
        if (determineWinner() == true) {
            winnings = bet * 2;
        } else {
            winnings = bet - bet;
        }
        return winnings;
    }

}


//    public CardHandler playGoFish() throws NoSuchElementException {
//        while (goFishDeck.getDeck().size() > 0) {
//UI prompt will ask for input, variable will be "choice"
//            String choice = User.stringInput("Please enter a card");
//            if (dealerHand.hasRankInHand(choice)) {
//                dealerHand.removeCorrectCard(choice);
//                this.hand.addCorrectCard(choice);
//            } else {
//                Card newCard = goFishDeck.dealCard();
//                this.hand.addCard(newCard);
//            }
//              }
//              return this.hand;
//              }