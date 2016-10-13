package io.zipcode.View;

import io.zipcode.Model.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Casino {
    Engine engine = new Engine();
    UserInput ui = new UserInput();
//
//    public void startGame(){
//        Display.whatsYourName();
//        String name = ui.getString();
//        Display.howMuchMoney();
//        int balance = ui.getInt();
//        engine.createPlayer(name, balance);
//    }
//
//    public void enterCasino(){
//        Display.welcomeMessage();
//        String answer;
//        do{
//            Display.requestGame();
//            answer = ui.getString();
//        }while (gameChoice(answer));
//        Display.leaveCasino();
//    }
//
//    public boolean gameChoice(String game){
//        //regex
//        try{
//            switch (game.toUpperCase()){
//                case "SLOTS": playSlots();break;
//                case "BLACKJACK": playBlackjack();break;
//                case "ROULETTE": playRoulette();break;
//                case "AGRAM": playAgram();break;
//                case "GO FISH": playGoFish();break;
//                case "RUSSIAN ROULETTE": playRussianRoulette();break;
//                case "BACCARAT": playBaccarat();break;
//                case "WAR": playWar();break;
//                case "QUIT": return false;
//                default:
//                    System.out.println("We did not understand your request, please try again.");return true;
//            }
//        }catch (InvalidBetException e){
//            Display.weakBet();
//        }catch (ZeroBalanceException z){
//
//        }catch (GameSizeException g){
//
//        }finally {
//            return true;
//        }
//    }
//
//    private void playRoulette() {
//        int bet;
//        int betType;
//        int numberGuess = 1;
//        String response;
//        Display.welcomeToRoulette();
//        do{
//
//            Display.betType();
//            betType=ui.getString();
//            bet=requestBet();
//            if(betType==4){
//                numberGuess=ui.getInt();
//            }
//            Display.result(engine.playRoulette(bet,betType,numberGuess));
//            Display.playAgain();
//            response = ui.getString();
//        }while (response.toUpperCase()=="YES");
//    }
//
//    public void playSlots(){
//        int bet;
//        Display.slotsWelcome();
//        do{
//            bet = requestBet();
//            Display.result(engine.playSlots(bet));
//        }while (engine.isRunning());
//    }
//
//    public void playBaccarat(){
//        int bet;
//        Display.baccaratWelcome();
//        do{
//            bet = requestBet();
//            Display.Baccarat();
//            Display.result(engine.playBaccarat(bet));
//        }while (engine.gameRunning);
//    }
//
//    public void playBlackjack(){
//        int bet;
//        Display.blackjackWelcome();
//        do{
//            bet = requestBet();
//            Display.result(engine.playBlackjack(bet));
//        }while (engine.gameRunning);
//    }
//
    public void playAgram(){

        engine.createPlayer("John", 100);
        engine.createPlayer("Jen", 100);
        engine.createPlayer("Jeb", 100);
        engine.createPlayer("Joan", 100);

        List<Integer> bets = new ArrayList<Integer>();
        int length = engine.players.size();
        int startingPlayer;
        int currentPlayer;
        //Display.agramWelcome();

        for (int i = 0; i < length; i++) {
            bets.add(requestBet());
        }

        engine.initializeAgram(bets);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < length; j++) {
                if (j > 0 ) {
                    Display.print("The current suit is " + engine.getAgramPlayedSuit());
                }
                startingPlayer = engine.getAgramStartingPlayer();
                currentPlayer = (startingPlayer + j) % length;
                Display.print("Player " + (currentPlayer + 1) + " select a card by number.");
                Display.print(engine.getAgramHand(j));
                while(!(engine.playAgram(ui.getInt(), currentPlayer))) {
                    Display.print("You cannot play that card.");
                }
                Display.print("Player " + (currentPlayer + 1) + " played " + engine.getAgramLastPlayed());
            }
            engine.finishAgramRound();

        }

        engine.settleAgramBets(bets);

        for (int winnings : bets) {
            Display.result(winnings);
        }

    }
//
//    public void playGoFish(){
//        int bet;
//        Display.goFishWelcome();
//        do{
//            bet = requestBet();
//            Display.result(engine.playGoFish(bet));
//        }while (engine.gameRunning);
//    }
//
//    public void playRussianRoulette(){
//        int bet;
//        Display.russianRouletteWelcome();
//        do{
//            Display.pressEnter();
//            Display.result(engine.playRussianRoulette());
//        }while (engine.gameRunning);
//    }
//
//    public void playWar(){
//        int bet;
//        Display.warWelcome();
//        do{
//            bet = requestBet();
//            Display.result(engine.playWar(bet));
//        }while (engine.gameRunning);
//    }
//
    public int requestBet(){
        Display.requestBet();
        return ui.getInt();
    }

//    public static void main(String[] args) {
//        Casino casino = new Casino();
//
//        casino.startGame();
//        casino.enterCasino();
//    }
}
