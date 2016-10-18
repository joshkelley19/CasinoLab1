package io.zipcode.View;

import io.zipcode.Model.Card;
import io.zipcode.Model.CardHandler;

import java.util.List;

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
        System.out.println("What Table would you like to join?\nSlots\nBlackjack\nGoFish");
    }

    public static void requestBet() {
        System.out.println("How much would you like to bet?");
    }

    public static void leaveCasino() {
        System.out.println("Thanks for coming. We hope to see you again.");
    }

    public static void result(int winnings) {
        String result = (winnings > 0) ? "Congratulations! You have won $" + winnings + "!" : "I'm sorry! You lost $" + -winnings;
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

    //Go Fish display messages

    public static void goFishWelcome() {
        System.out.println("Welcome to Go Fish!");
        System.out.println("               _.'.__" +
                "                      _.'      .\n" +
                "':'.               .''   __ __  .\n" +
                "  '.:._          ./  _ ''     \"-'.__\n" +
                ".'''-: \"\"\"-._    | .                \"-\"._\n" +
                " '.     .    \"._.'                       \"\n" +
                "    '.   \"-.___ .        .'          .  :o'.\n" +
                "      |   .----  .      .           .'     (\n" +
                "       '|  ----. '   ,.._                _-'\n" +
                "        .' .---  |.\"\"  .-:;.. _____.----'\n" +
                "        |   .-\"\"\"\"    |      '\n" +
                "      .'  _'         .'    _'\n" +
                "     |_.-'            '-.'");
        System.out.println("Rules: You will be be given 7 cards taken from the deck!");
        System.out.println("You will be prompted to guess which card the dealer has");
        System.out.println("If you are correct that card will be added to your deck");
        System.out.println("If you are incorrect you go fishin' and draw a card from the deck");
        System.out.println("If you have more matching sets of 4 than the dealer then you win!");
    }

    public static void askForGoFishCard() {
        System.out.println("Please enter a card rank");
    }
    public static void displayGoFishHand(List<Card> hand){
        for(Card c: hand){
            System.out.println(c.getRank()+" of "+c.getSuit());
        }
    }
}
