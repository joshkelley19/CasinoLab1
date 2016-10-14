package io.zipcode.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshuakelley on 10/12/16.
 */
public class CardHandler {
    ArrayList<Card> hand = new ArrayList<>();
    Player player;

    public CardHandler(Player player){
        this.player=player;
    }

    public void addCard(Card card){
        hand.add(card);
    }

    protected boolean removeCard(Card card){
        return hand.remove(card);
    }//remove method returns boolean if taking object as param. returns object if taking index as param

    public List<Card> getHand(){
        return hand;
    }

    public Player getPlayer(){
        return player;
    }
}
