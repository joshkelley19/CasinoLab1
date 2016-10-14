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
    Display display = new Display();

    public void startGame() {
        Display.whatsYourName();
        String name = ui.getString();
        Display.howMuchMoney();
        int balance = ui.getInt();
        engine.createPlayer(name, balance);
    }

    public void enterCasino() {
        Display.welcomeMessage();
        String answer;
        ui.pressEnter();

        do {
            Display.requestGame();
            answer = ui.pressEnter();
        } while (gameChoice(answer));
        Display.leaveCasino();
    }

    public boolean gameChoice(String game) {
        //regex

        try {
            switch (interpretGame(game)) {

                case "SLOTS":
                    playSlots();
                    break;

                case "BLACKJACK":
                    playBlackjack();
                    break;

                case "ROULETTE":
                    playRoulette();
                    break;

                case "AGRAM":
                    playAgram();
                    break;

                case "BACCARAT":
                    playBaccarat();
                    break;

                case "QUIT":
                    return false;
                default:
                    System.out.println("We did not understand your request, please try again.");
                    return true;
            }
        } catch (InvalidBetException e) {
            Display.weakBet();

        } finally {
            return true;
        }
    }

    public void playBlackjack() {
        int bet;
        int hitStay;
        Display.blackjackWelcome();
        bet = requestBet();
        engine.playBlackjack();
        do {
            Display.hitOrStay();
            hitStay = ui.getInt();
        } while (!engine.loopPortion(hitStay));
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
                if (j > 0) {
                    Display.printAgram("The current suit is " + engine.getAgramPlayedSuit());
                }
                startingPlayer = engine.getAgramStartingPlayer();
                currentPlayer = (startingPlayer + j) % length;
                Display.printAgram("Player " + (currentPlayer + 1) + " select a card by number.");
                Display.printAgram(engine.getAgramHand(currentPlayer));
                while (!(engine.playAgram(ui.getInt(), currentPlayer))) {
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
        do {
            bet = requestBet();
            Display.result(engine.playSlots(bet));
            Display.playAgain();
            response = ui.getString();
        } while (response.toUpperCase().equals("YES"));
    }


    public void playBaccarat() {
        Display.baccaratWelcome();
        do {
            int bet = requestBet();
            Display.baccaratBetType();
            String betType = ui.getString();
            engine.setupBaccarat(bet, betType);
            Display.result(engine.playBaccarat());
            Display.printFinalScores(engine.printScores());
            Display.playAgain();
        } while (ui.getString().equalsIgnoreCase("yes"));
    }

    public void playRussianRoulette() {
        engine.playRussianRoulette();
        display.rrWelcome();
        do {
            display.rrTurn(engine.getPlayer(), engine.getRR().getCounter());
            ui.pressEnter();
        } while (engine.pullTrigger());
        engine.russianroulettePayOut();
    }

    public void playWar() {
        String answer;
        int bet;
        String winner;
        do {
            display.warWelcome();
            bet = requestBet();
            display.warTurn();
            ui.pressEnter();
            winner = engine.playWar();
            display.keepPlaying();
            answer = ui.getString();
            engine.warPayOut(bet, winner);
        } while (answer.toUpperCase().equals("YES"));

    }

    private String interpretGame(String game) {

        String result;
        String[] regexes = {"s((l){1,2}(o){1,2}|(o){1,2}(l){1,2})(t){1,2}s{1,2}", "b(l){1,2}a(ck|kc)ja(ck|kc)",
                "r(ou|uo)l{1,2}et{1,2}e{1,2}", "a{1,2}g{1,2}(ar|ra)m{1,2}", "go{1,2}\\s+(f|ph)(i|e){1,2}sh",
                "rus{1,2}(ia|ai)n{1,2}\\s+r(ou|uo)l{1,2}et{1,2}e{1,2}", "ba{1,2}(c|k){1,2}arat{1,2}",
                "wa{1,2}r{1,2}"};

        String[] games = {"SLOTS", "BLACKJACK", "ROULETTE", "AGRAM", "GO FISH",
                "RUSSIAN ROULETTE", "BACCARAT", "WAR"};

        for (int i = 0; i < 8; i++) {
            result = game.toLowerCase();
            result = result.replaceAll(regexes[i], games[i]);

            if (result.equals(games[i])) {
                System.out.println(result);
                return result;

            }
        }
        return "";
    }
}