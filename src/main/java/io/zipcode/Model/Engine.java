package io.zipcode.Model;

import java.util.ArrayList;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Engine {
    public ArrayList<Player> players = new ArrayList<>();

    public void createPlayer(String name,int balance){
        players.add(new Player(name,balance));
    }

    public int placeBet(int bet) throws InvalidBetException {
        if(bet<1) throw new InvalidBetException("");
        return bet;
    }

}
