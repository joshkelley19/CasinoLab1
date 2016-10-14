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

    public static void agramWelcome() {
        System.out.println("Welcome to Agram. Each player will be dealt 6 cards. Player 1 will got first. \n" +
                "Each player will play a card of the same suit. If you do not have a card of \nthe same suit play " +
                "any card. You cannot win the trick with a card of the \nincorrect suit. The winner of the last " +
                "trick leads the next one. Win the \n6th and final trick to win the game.");
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


  public static void printAgram (String message) {
      System.out.println(message);
  }


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

  public static void baccaratBetType() {
    System.out.println("Please choose a type of bet:");
    System.out.println("bank");
    System.out.println("player");
  }

  public void baccaratWelcome(){
    System.out.println("Welcome to Baccarat!");
  }
}
