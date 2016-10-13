package io.zipcode.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adam on 10/12/16.
 */
public class Deck {
    protected String[] ranks = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
    protected String [] suits = {"HEARTS", "SPADES", "DIAMONDS", "CLUBS"};
    private List<Card> deck = new ArrayList<>();

    public Deck() {
        this.fillDeck();
        Collections.shuffle(this.deck);
    }

    private void fillDeck() {
        for(int i=0; i<suits.length; i++) {
            for(int j=0; j<ranks.length; j++) {
                deck.add(new Card(suits[i], ranks[j]));
            }
        }
    }

    private void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        return this.deck.remove(0);
    }
}