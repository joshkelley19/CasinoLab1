package io.zipcode.View;

import io.zipcode.Model.Player;

import java.util.List;
import io.zipcode.Model.Blackjack;
import io.zipcode.Model.Card;
import io.zipcode.Model.Player;




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

  public static void baccaratWelcome(){
    System.out.println("Welcome to Baccarat!");
  }
  public void rrTurn(List<Player> players, int counter)
  {
    System.out.println("");
    System.out.println(players.get(counter).getName() + "'s turn.");
    System.out.println("Press enter to pull the trigger:");
  }
  public void warTurn(){ System.out.println("Press enter to draw:"); }
  public void bang() {System.out.println("-Bang!-"); }
  public void click() {System.out.println("-click-"); }

  public void tie()
  {
    System.out.println("");
    System.out.println("Tie");
    System.out.println("War initiated!");
  }
  public void rrWelcome(){
    System.out.println("        (_/-------------_______________________)\n" +
            "          `|  /~~~~~~~~~~\\                       |\n" +
            "           ;  |--------(-||______________________|\n" +
            "           ;  |--------(-| ____________|\n" +
            "           ;  \\__________/'\n" +
            "         _/__         ___;\n" +
            "      ,~~    |  __--~~     Welcome to Russian Roulette:\n" +
            "     '        ~~| (  |     its a blast!\n" +
            "    '      '~~  `____'\n" +
            "   '      '\n" +
            "  '      `\n" +
            " '       `\n" +
            "'--------`");

  };
  public void keepPlaying()
  {
    System.out.println("Do you want to keep playing?: yes/no");
  }
  public void displayCards(Card playersCard, Card dealersCard)
  {
    System.out.println("");
    System.out.println("You drew a " +playersCard.getRank()+" of "+playersCard.getSuit());
    System.out.println("Dealer drew a " +dealersCard.getRank()+" of "+dealersCard.getSuit());
  }
  public void warWelcome()
  {
    System.out.println("                     ______\n" +
            "                   .-\"      \"-.\n" +
            "                  /            \\\n" +
            "                 |              |\n" +
            "                 |,  .-.  .-.  ,|\n" +
            "                 | )(__/  \\__)( |\n" +
            "                 |/     /\\     \\|       War:\n" +
            "       (@_       (_     ^^     _)       war never changes\n" +
            "  _     ) \\_______\\__|IIIIII|__/__________________________\n" +
            " (_)@8@8{}<________|-\\IIIIII/-|___________________________>\n" +
            "        )_/        \\          /\n" +
            "       (@           `--------` \n" +
            "\n");
  }
}


