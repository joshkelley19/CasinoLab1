package io.zipcode.Model;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Player {
    private final String name;
    private int balance;
    private int bet=0;

    public Player(String name, int balance){
        this.name=name;this.balance=balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance += balance;
    }

    public int getBet() {
        return bet;
    }

    public boolean setBet(int bet) {
        if(bet>balance)return false;
        this.bet = bet;
        return true;
    }

    public String getName(){
        return name;
    }

}
