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

    protected void addCard(Card card){
        hand.add(card);
    }

    protected boolean removeCard(Card card){
        return hand.remove(card);
    }//remove method returns boolean if taking object as param. returns object if taking index as param

    protected List<Card> getHand(){
        return hand;
    }

    protected Player getPlayer(){
        return player;
    }
}
