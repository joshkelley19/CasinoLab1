package io.zipcode.View;

import io.zipcode.Model.Engine;

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
        do
        {
            display.rrTurn(engine.getPlayer(), engine.getRR().getCounter());
            ui.pressEnter();
            System.out.println(engine.getRR().getCounter());
            System.out.println(engine.getRR().getBullet());
            //engine.getRR().plusCounter();
        }while(engine.pullTrigger());
        engine.russianroulettePayOut();
    }

    public static void main(String[] args) {
        Casino c = new Casino();
        c.playRussianRoulette();
    }
}
