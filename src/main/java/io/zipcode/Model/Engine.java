package io.zipcode.Model;

import io.zipcode.View.UserInput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class Engine {
    public ArrayList<Player> players = new ArrayList<>();//player info passed through casino,can manipulate without passing in/returning
    RussianRoulette rr = new RussianRoulette();
    War war = new War();

    public List getPlayer()
    {
      return players;
    }

    public void playRussianRoulette()
    {
        //int bullet = rr.loadGun();
        rr.loadGun();
        boolean keepGoing = true;
        rr.fillRoster(players);
    }
    public boolean pullTrigger()
    {
        return rr.pullTrigger(rr.getCounter(), rr.getBullet());
    }
    public void russianroulettePayOut()
    {
        rr.russianRoulettePayOut(players, rr.getBullet());
    }
    public RussianRoulette getRR()
    {
        return rr;
    }
    public void plusCounter()
    {
        rr.plusCounter();
    }
    public void playWar()
    {

    }
}
