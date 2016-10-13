package io.zipcode.View;

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

}
