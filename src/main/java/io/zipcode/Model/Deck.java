package io.zipcode.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adam on 10/12/16.
 */
public class Deck {
    static String[] ranks = {"ACE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"};
    static String [] suits = {"HEARTS", "SPADES", "DIAMONDS", "CLUBS"};
    List<Card> deck = new ArrayList<>();

    public Deck() {
        this.fillDeck();
        Collections.shuffle(this.deck);
    }

    public void fillDeck() {
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