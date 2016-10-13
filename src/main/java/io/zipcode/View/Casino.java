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
                case "SLOTS": playSlots();break;
//                case "BLACKJACK": playBlackjack();break;
//                case "ROULETTE": playRoulette();break;
//                case "AGRAM": playAgram();break;
//                case "GO FISH": playGoFish();break;
//                case "RUSSIAN ROULETTE": playRussianRoulette();break;
//                case "BACCARAT": playBaccarat();break;
//                case "WAR": playWar();break;
                case "QUIT": return false;
                default:
                    System.out.println("We did not understand your request, please try again.");return true;
            }
        }catch (InvalidBetException e){
            Display.weakBet();
//        }catch (ZeroBalanceException z){
//
//        }catch (GameSizeException g){

        }finally {
            return true;
        }
    }

    public void playSlots(){
        int bet;
        String response;
        Display.slotsWelcome();
        do{
            bet = requestBet();
            Display.result(engine.playSlots(bet));
            Display.playAgain();
            response = ui.getString();
        }while (response.toUpperCase().equals("YES"));
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
