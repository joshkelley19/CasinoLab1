package io.zipcode.View;

import io.zipcode.Model.Engine;
import io.zipcode.Model.InvalidBetException;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Casino {
    Engine engine = new Engine();
    UserInput ui = new UserInput();

    public void startGame(){
        Display.whatsYourName();
        String name = ui.getString();
        Display.howMuchMoney();
        int balance = ui.getInt();
        engine.createPlayer(name, balance);
    }

    public void enterCasino(){
        Display.welcomeMessage();
        String answer;
        do{
            Display.requestGame();
            answer = ui.getString();
        }while (gameChoice(answer));
        Display.leaveCasino();
    }

    public boolean gameChoice(String game){
        //regex
        try{
            switch (game.toUpperCase()){

                case "BLACKJACK": playBlackjack();break;

                case "QUIT": return false;
                default:
                    System.out.println("We did not understand your request, please try again.");return true;
            }
        }catch (InvalidBetException e){
            Display.weakBet();

        }finally {
            return true;
        }
    }

    public void playBlackjack(){
        int bet;
        int hitStay;
        Display.blackjackWelcome();
        bet = requestBet();
        engine.playBlackjack();
        do{
            Display.hitOrStay();
            hitStay = ui.getInt();
        }while (!engine.loopPortion(hitStay));
        Display.result(engine.blackjackWinnings(bet));
    }

    public int requestBet(){
        Display.requestBet();
        return ui.getInt();
    }

    public static void main(String[] args) {
        Casino casino = new Casino();

        casino.startGame();
        casino.enterCasino();
    }
}
