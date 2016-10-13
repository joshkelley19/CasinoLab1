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
    System.out.println("What would you like to do?\nSlots\nBlackjack\nRoulette\nAgram\nGo Fish\nRussian Roulette\nBaccarat\nWar\n\nQuit");
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
  // Roulette Display -------------------------
  public static void rouletteWelcome() {
    System.out.println("Welcome to Roulette!");
  }

  public static void rouletteAskBetType() {
    System.out.println("Please choose a type of bet:");
    System.out.println("[1] One - Twelve");
    System.out.println("[2] Thirteen - Twenty-four");
    System.out.println("[3] Twenty-five - Thirty-six");
    System.out.println("[4] One Number");
  }

  public static void rouletteAskForNumber() {
    System.out.print("Please enter a number: ");
  }

  public static void roulettePrintWheel(String color, int number) {
    System.out.println("Wheel value:");
    System.out.println("Color: " + color + ", Number: " + number);
  }
  // ------------------------------------------
  public static void playAgain(){
    System.out.print("Would you like to play again? Yes or No: ");
  }
}
