package io.zipcode.View;

import io.zipcode.Model.Player;

import java.util.List;

/**
 * Created by joshuakelley on 10/12/16.
 */
public class Display {
  public void welcome(){
    System.out.println("Welcome to Casino Mobile");
  }
  public void rrTurn(List<Player> players, int counter)
  {
    System.out.println(players.get(counter).getName() + "'s turn.");
    System.out.println("Press enter to pull the trigger:");
  }
  public void warTurn(){ System.out.println("Press enter to draw:"); }
  public void bang() {System.out.println("-Bang!-"); }
  public void click() {System.out.println("-click-"); }
  public void youWin() {System.out.println("You Win"); }
  public void youLose() {System.out.println("You Lose"); }
  public void tie()
  {
    System.out.println("Tie");
    System.out.println("War initiated!");
  }
}
