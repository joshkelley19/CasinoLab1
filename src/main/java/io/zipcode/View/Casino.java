package io.zipcode.View;

import io.zipcode.Model.Engine;
import io.zipcode.Model.InvalidBetException;

import java.util.ArrayList;
import java.util.List;

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

    public void playAgram() {

        List<Integer> bets = new ArrayList<Integer>();
        int length = engine.getPlayers().size();
        int startingPlayer;
        int currentPlayer;
        Display.agramWelcome();

        for (int i = 0; i < length; i++) {
            bets.add(requestBet());
        }

        engine.initializeAgram(bets);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < length; j++) {
                if (j > 0 ) {
                    Display.printAgram("The current suit is " + engine.getAgramPlayedSuit());
                }
                startingPlayer = engine.getAgramStartingPlayer();
                currentPlayer = (startingPlayer + j) % length;
                Display.printAgram("Player " + (currentPlayer + 1) + " select a card by number.");
                Display.printAgram(engine.getAgramHand(currentPlayer));
                while(!(engine.playAgram(ui.getInt(), currentPlayer))) {
                    Display.printAgram("You cannot play that card.");
                }
                Display.printAgram("Player " + (currentPlayer + 1) + " played " + engine.getAgramLastPlayed());
            }
            engine.finishAgramRound();

        }

        engine.settleAgramBets(bets);

        for (int winnings : bets) {
            Display.result(winnings);
        }

    }

    public int requestBet() {
        Display.requestBet();
        return ui.getInt();
    }

    private void playRoulette() {
        int bet;
        int betType;
        int numberGuess = 1;
        String response;
        Display.rouletteWelcome();
        do {
            Display.rouletteAskBetType();
            betType = ui.getInt();
            bet = requestBet();
            if (betType == 4) {
                numberGuess = ui.getInt();
            }
            Display.result(engine.playRoulette(bet, betType, numberGuess));
            Display.playAgain();
            response = ui.getString();
        } while (response.toUpperCase().equals("YES"));
    }

    public void playSlots() {
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

}
