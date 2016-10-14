package io.zipcode.View;

import io.zipcode.Model.Engine;
import io.zipcode.Model.Player;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Casino {
    Engine engine = new Engine();
    UserInput ui = new UserInput();
    Display display = new Display();

    public void playRussianRoulette()
    {
        engine.playRussianRoulette();
        display.rrWelcome();
        do
        {
            display.rrTurn(engine.getPlayer(), engine.getRR().getCounter());
            ui.pressEnter();
        }while(engine.pullTrigger());
        engine.russianroulettePayOut();
    }
    public void playWar()
    {
        String answer;
        int bet;
        String winner;
        do
        {
            display.warWelcome();
            bet = requestBet();
            display.warTurn();
            ui.pressEnter();
            winner = engine.playWar();
            display.keepPlaying();
            answer = ui.getString();
            engine.warPayOut(bet, winner);
        }while(answer.toUpperCase().equals("YES"));

    }

    public static void main(String[] args)
    {
        Casino c = new Casino();
       // c.playRussianRoulette();
        c.playWar();
    }
}
