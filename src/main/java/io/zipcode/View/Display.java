package io.zipcode.View;

import io.zipcode.Model.Blackjack;
import io.zipcode.Model.Card;
import io.zipcode.Model.Player;

import java.util.*;

/**
 * Created by joshuakelley on 10/12/16.
 */
public class Display {
  public static void whatsYourName() {
    System.out.println("What is your name?");
  }

  public static void howMuchMoney() {
    System.out.println("How much money you got on you?");
  }

  public static void welcomeMessage() {
    System.out.println("Welcome to the Mobile Casino!");
  }

  public static void slotsWelcome() {
    System.out.println("Welcome to Slots.");
  }

  public static void requestGame() {
    System.out.println("What Table would you like to join?\nSlots\nBlackjack");
  }

  public static void requestBet(){
    System.out.println("How much would you like to bet?");
  }

  public static void leaveCasino() {
    System.out.println("Thanks for coming. We hope to see you again.");
  }

  public static void result(int winnings){
    String result = (winnings>0)?"Congratulations! You have won $"+winnings+"!":"I'm sorry! You lost $"+-winnings;
    System.out.println(result);
  }

  public static void weakBet() {
    System.out.println("Your bet is inadequate");
  }

  // BLACKJACK =================================================

  public static void blackjackWelcome(){
    System.out.println("Welcome to Blackjack!");
    System.out.println("Place your bet:");
  }

  public static void printDealerHand(Blackjack x){
    System.out.println("Dealer's Hand");
    System.out.println("==============");
    System.out.println(x.getDealerHand().get(0).getRank());
    System.out.println("[?]");
    for(int i=2; i<x.getDealerHand().size(); i++){
      System.out.println(x.getDealerHand().get(i).getRank());
    }
    System.out.println("==============");
  }

  public static void printUserName(Player x){
    System.out.println(x.getName() + "'s Hand");
  }

  public static void printUserHand(List<Card> x){
    System.out.println("==============");
    for(int i=0; i<x.size(); i++){
      System.out.println(x.get(i).getRank());
    }
    System.out.println("==============");
  }

  public static void hitOrStay(){
    System.out.println("==============");
    System.out.println("Press [1] to hit, or [2] to stay.");
  }

  public static void youWin(){
    System.out.println("======@@@@======");
    System.out.println("Congratulations, you win!");
    System.out.println("======@@@@======");
  }
  public static void youTie(){
    System.out.println("======@@@@======");
    System.out.println("It's a tie!");
    System.out.println("======@@@@======");
  }
  public static void youLose(){
    System.out.println("======@@@@======");
    System.out.println("Sorry, you lost.");
    System.out.println("======@@@@======");
  }

}


