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
        enterCasino();
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
//                case "SLOTS": playSlots();break;
//                case "BLACKJACK": playBlackjack();break;
                case "ROULETTE": playRoulette();break;
//                case "AGRAM": playAgram();break;
                case "GOFISH": playGoFish();break;
//                case "RUSSIAN ROULETTE": playRussianRoulette();break;
//                case "BACCARAT": playBaccarat();break;
//                case "WAR": playWar();break;
                case "QUIT": return false;
                default:
                    System.out.println("We did not understand your request, please try again.");return true;
            }
        }catch (InvalidBetException e){
            Display.weakBet();
        //}catch (ZeroBalanceException z){

        //}catch (GameSizeException g){

        }finally {
            return true;
        }
    }

    private void playRoulette() {
        int bet;
        int betType;
        int numberGuess = 1;
        String response;
        Display.rouletteWelcome();
        do{
            Display.rouletteAskBetType();
            betType=ui.getInt();
            bet=requestBet();
            if(betType==4){
                numberGuess=ui.getInt();
            }
            Display.result(engine.playRoulette(bet,betType,numberGuess));
            //Display.playAgain();
            response = ui.getString();
        }while (response.toUpperCase()=="YES");
    }
    private void playGoFish() throws Exception{
        Display.goFishWelcome();
        int bet = engine.playGoFish(requestBet());
        do{
            Display.askForGoFishCard();
            Display.displayGoFishHand(engine.goFishLoop(ui.getString()));
        }while (engine.goFishGameOver());
        engine.goFishWin(bet);
    }

    public int requestBet(){
        Display.requestBet();
        return ui.getInt();
    }
}
