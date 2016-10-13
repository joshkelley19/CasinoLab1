package io.zipcode.Model;

/**
 * Created by jamescrawley on 10/13/16.
 */
public class AgramDeck extends Deck {

    static {
        ranks = new String[] {"THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "ACE"};
        suits = new String[] {"HEARTS", "SPADES", "DIAMONDS", "CLUBS"};
    }

    public AgramDeck () {
        super();
        Card removeCard = null;
        for (Card card : deck) {
            if (card.getSuit().equals("SPADES") && card.getRank().equals("ACE")) {
                removeCard = card;
                break;
            }
        }
        deck.remove(removeCard);
    }

    @Override
    public void fillDeck() {
        for(String suit: suits) {
            for(String rank: ranks) {
                deck.add(new Card(suit, rank));
            }
        }
    }

}
