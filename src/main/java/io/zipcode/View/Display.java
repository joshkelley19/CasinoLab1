package io.zipcode.View;

/**
 * Created by joshuakelley on 10/12/16.
 */
public class Display {
  public void welcome(){
    System.out.println("Welcome to Casino Mobile");
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
}
