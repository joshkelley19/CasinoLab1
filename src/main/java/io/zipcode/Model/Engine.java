package io.zipcode.Model;

import io.zipcode.View.Display;

import java.util.ArrayList;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Engine {
    //Instance variables //
    Roulette roulette;

    public ArrayList<Player> players = new ArrayList<>();//player info passed through casino,can manipulate without passing in/returning

    public int playRoulette(int bet, int betType, int numberGuess) {
        roulette = new Roulette(players);
        roulette.placeBetType(0, betType);
        roulette.askforNumber(0, numberGuess);
        roulette.spinWheel();
        return roulette.payoff();
    }
}
