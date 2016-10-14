package io.zipcode.View;

import io.zipcode.Model.Card;
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
    System.out.println("");
    System.out.println(players.get(counter).getName() + "'s turn.");
    System.out.println("Press enter to pull the trigger:");
  }
  public void warTurn(){ System.out.println("Press enter to draw:"); }
  public void bang() {System.out.println("-Bang!-"); }
  public void click() {System.out.println("-click-"); }
  public void youWin()
  {
    System.out.println("");
    System.out.println("You Win");
  }
  public void youLose()
  {
    System.out.println("");
    System.out.println("You Lose");
  }
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
