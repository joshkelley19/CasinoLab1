package io.zipcode.Model;

import java.util.ArrayList;

/**
 * Created by jalisahewitt on 10/13/16.
 */
public class Baccarat{
    ArrayList<Card> playerHand= new ArrayList<>();
    ArrayList<Card> dealerHand= new ArrayList<>();
    boolean isRunning = true;
    Deck deck = new Deck();
    int result;
    int bet;
    String bettedOn;


    public Baccarat(int bet, String bettedOn){
        this.bet=bet;
        this.bettedOn = bettedOn.toLowerCase();
    }

    public int value(Card c){
        if(c.getRank() == "ACE" || c.getRank() == "JACK" || c.getRank() == "QUEEN" || c.getRank() == "KING" || c.getRank() == "TEN"){
            int value = 0;
            return value;
        }else if(c.getRank() == "TWO"){
            int value = 2;
            return value;
        }else if(c.getRank() == "THREE"){
            int value = 3;
            return value;
        }else if(c.getRank() == "FOUR"){
            int value = 4;
            return value;
        }else if(c.getRank() == "FIVE"){
            int value = 5;
            return value;
        }else if(c.getRank() == "SIX"){
            int value = 6;
            return value;
        }else if(c.getRank() == "SEVEN"){
            int value = 7;
            return value;
        }else if(c.getRank() == "EIGHT"){
            int value = 8;
            return value;
        }else {
            int value = 9;
            return value;
        }

    }

    public void firstDeal(){
        for(int i=0; i<2;i++) {
            playerHand.add(deck.dealCard());
            dealerHand.add(deck.dealCard());
        }
    }

    public int sum(int x, int y){
        int sum= x+y;
        return sum;
    }

    public int CheckplayerSum(){
        int firstCard = value(playerHand.get(0));
        int secondCard = value(playerHand.get(1));
        int firstSum= sum(firstCard, secondCard);
        if(firstSum > 10){
            int finalSum = firstSum - 10;
            return finalSum;

        }else{
            int finalSum = firstSum;
            return finalSum;
        }

    }

    public int CheckDealerSum(){
        int firstCard = value(dealerHand.get(0));
        int secondCard = value(dealerHand.get(1));
        int firstSum= sum(firstCard, secondCard);
        if(firstSum > 9){
            int finalSum = firstSum - 10;
            return finalSum;
        }else{
            int finalSum = firstSum;
            return finalSum;
        }
    }

    public int finalScorePlayer(){
        if(playerHand.size()==3){
            int thirdCardValue = value(playerHand.get(2));
            int morefinalSum = sum(CheckplayerSum(),thirdCardValue);
            if(morefinalSum > 9){
                int evenMoreFinalSum = morefinalSum -10;
                return evenMoreFinalSum;
            }else{
                return morefinalSum;
            }
        }else{
            return CheckplayerSum();
        }
    }

    public int finalScoreDealer(){
        if(dealerHand.size()==3){
            int thirdCardValue = value(dealerHand.get(2));
            int morefinalSum = sum(CheckDealerSum(),thirdCardValue);
            if(morefinalSum > 9){
                int evenMoreFinalSum = morefinalSum -10;
                return evenMoreFinalSum;
            }else{
                return morefinalSum;
            }
        }else{
            return CheckDealerSum();
        }
    }

    public boolean playersThirdCard(){
        if(CheckplayerSum()<6){
            if(CheckDealerSum() <8){
                playerHand.add(deck.dealCard());
            }else{
                getWinner();
            }
        }
        return isRunning;
    }

    public void DealersThirdCard(){

        int a = 4;
        int b = 3;
        int q = 7;
        int r = 6;
        int y = 5;
        int sumOfDealer = CheckDealerSum();

        if(playerHand.size()<3){
            if(sumOfDealer < 6){
                dealerHand.add(deck.dealCard());
            }
            }else{
            int playersThirdCardValue = value(playerHand.get(2));
            switch(playersThirdCardValue){
                case 0: if(sumOfDealer<a){
                    dealerHand.add(deck.dealCard());}
                    break;
                case 8: if(sumOfDealer<b){
                    dealerHand.add(deck.dealCard());}
                    break;
                case 6: if(sumOfDealer<q){
                    dealerHand.add(deck.dealCard());}
                    break;
                case 7: if(sumOfDealer<q){
                    dealerHand.add(deck.dealCard());}
                    break;
                case 4: if(sumOfDealer<r){
                    dealerHand.add(deck.dealCard());}
                    break;
                case 5: if(sumOfDealer<r){
                    dealerHand.add(deck.dealCard());}
                    break;
                case 2: if(sumOfDealer<y){
                    dealerHand.add(deck.dealCard());}
                    break;
                case 3: if(sumOfDealer<y){
                    dealerHand.add(deck.dealCard());}
                    break;

            }
        }

    }

    public void getWinner(){
        if(finalScoreDealer() > finalScorePlayer()){
            if(bettedOn.equals("bank")){

                setResult(bet);
                isRunning = false;
            }else{
                setBetLoser(bet);
                setResult(bet);
                isRunning = false;

            }

        }else if(finalScorePlayer() > finalScoreDealer()){
            if(bettedOn.equals("player")){
                setBetWinner(bet);
                setResult(bet);
                isRunning = false;
            }else{
                setBetLoser(bet);
                setResult(bet);
                isRunning = false;
            }
        }else{
            setResult(0);
            isRunning = false;
        }
    }

    public boolean isRunning() {
        return isRunning;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public ArrayList<Card> getDealerHand() {
        return dealerHand;
    }

    public void setPlayerHand(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public void setDealerHand(ArrayList<Card> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public int getResult() {
        return result;
    }

    private void setResult(int result) {
        this.result = result;
    }

    public void setBetWinner(int bet) {
        this.bet = bet;
    }
    public void setBetLoser(int bet) {
        this.bet = 0-bet;
    }
}
