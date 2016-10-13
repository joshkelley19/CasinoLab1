package io.zipcode.Model;

import java.util.*;

/**
 * Created by Heron on 10/12/16.
 */
public class Blackjack {

    private boolean gameOver = false;

    private Deck blackjackDeck = new Deck();
    private List<CardHandler> blackjackCardHandlers = new ArrayList<>();
    private List<Card> dealerHand = new ArrayList<Card>();

    private List<Player> winners = new ArrayList<>();
    private List<Player> tied = new ArrayList<>();
    private List<Player> losers = new ArrayList<>();


    public boolean getGameOver(){
        return gameOver;
    }

    public List<Player> getWinners(){
        return winners;
    }
    public List<Player> getTied(){
        return tied;
    }
    public List<Player> getLosers(){
        return losers;
    }

    public void clearDealerHand(){
        dealerHand.clear();
    }
    public List<Card> getDealerHand(){
        return dealerHand;
    }
    public List<CardHandler> getBlackjackCardHandlers(){
        return blackjackCardHandlers;
    }

    public void hitPlayer(CardHandler a){
        a.addCard(blackjackDeck.dealCard());
    }

    public int checkTotal(List<Card> x){
        int total = 0;

        for(Card cards : x){
            if(cards.getRank().equals("TWO")){
                total+=2;
            }else if(cards.getRank().equals("THREE")){
                total+=3;
            }else if(cards.getRank().equals("FOUR")){
                total+=4;
            }else if(cards.getRank().equals("FIVE")){
                total+=5;
            }else if(cards.getRank().equals("SIX")){
                total+=6;
            }else if(cards.getRank().equals("SEVEN")){
                total+=7;
            }else if(cards.getRank().equals("EIGHT")){
                total+=8;
            }else if(cards.getRank().equals("NINE")){
                total+=9;
            }else if(cards.getRank().equals("TEN")){
                total+=10;
            }else if(cards.getRank().equals("JACK")){
                total+=10;
            }else if(cards.getRank().equals("QUEEN")){
                total+=10;
            }else if(cards.getRank().equals("KING")){
                total+=10;
            }else if(cards.getRank().equals("ACE")){
                if(total > 10){total += 1;}else {
                    total += 11;
                }
            }else{System.out.println("error, card value wrong");}
        }

        return total;
    }

    // MUST HIT DEALER LAST
    public boolean hitDealer(){
        if(checkTotal(dealerHand) < 18) {
            dealerHand.add(blackjackDeck.dealCard());
        }else{
            gameOver = true;
        }
        return gameOver;
    }

    public boolean compare(){

        checkDealerOverdrawn();
        checkDealer21();

        return gameOver;

    }
    private void checkDealerOverdrawn(){
        if(checkTotal(dealerHand) > 21) {
            for (CardHandler x : blackjackCardHandlers) {
                if(checkTotal(x.getHand()) < 22) {
                    winners.add(x.getPlayer());
                }else {
                    tied.add(x.getPlayer());
                }
            }
            gameOver = true;
        }
    }
    private void checkDealer21(){
        for (CardHandler x : blackjackCardHandlers) {
            if (checkTotal(dealerHand) == 21) {
                if (checkTotal(x.getHand()) == 21) {
                    tied.add(x.getPlayer());
                }else if(checkTotal(x.getHand()) < 21){
                    winners.add(x.getPlayer());
                }else {
                    losers.add(x.getPlayer());
                }
                gameOver = true;
            }
        }
    }
    public boolean endGameCompare(){
        for (CardHandler x : blackjackCardHandlers){
            if(checkTotal(x.getHand()) > checkTotal(dealerHand)){
                winners.add(x.getPlayer());
            }else if(checkTotal(x.getHand()) == checkTotal(dealerHand)){
                tied.add(x.getPlayer());
            }else {
                losers.add(x.getPlayer());
            }
        }
        return gameOver = true;
    }

    public void fillCardHandler(List<Player> thePlayers){
        for(Player x : thePlayers){
            blackjackCardHandlers.add(new CardHandler(x));
        }
    }

    // ???
    /* public void playBlackjack(){

    }

    public void printDealerHand(){
        System.out.println(dealerHand.get(0));
        System.out.println("[?]");
        for(int i=2; i<dealerHand.size(); i++){
            System.out.println(dealerHand.get(i));
        }
    }
    public void printUserHand(List<String> x){
        for(int i=0; i<x.size(); i++){
            System.out.println(x.get(i));
        }
    }
    */

}
