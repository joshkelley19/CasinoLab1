package io.zipcode.Model;

import io.zipcode.View.Display;
import io.zipcode.View.UserInput;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zacharywasserman on 10/12/16.
 */
public class RussianRoulette
{
    Display display = new Display();
    int counter = 0;
    int bullet= 0;
    public void loadGun()
    {
        Random rand = new Random();
        bullet = rand.nextInt(6);
        //return bullet;
    }

    public boolean pullTrigger(int counter, int bullet)
    {
        if (counter == bullet)
        {
            display.bang();
            return false;
        }
        else
        {
            display.click();
            this.counter++;
            return true;
        }
    }
    public int getBullet()
    {
        return bullet;
    }
    public void plusCounter(){
        counter++;
    }
    public int getCounter()
    {
        return counter;
    }

    public void removePlayer(List<Player> players, int loser)
    {
        players.remove(loser);
    }

    public int losersBet(List<Player>players, int loser)
    {
        return players.get(loser).getBalance();
    }

    public void payOut(List<Player> players, int losersAnte)
    {
        int ante = (losersAnte/5);
        for (int i = 0; i < players.size(); i++)
        {
            players.get(i).setBalance(ante);
        }
    }

    public void fillRoster(List<Player> players)
    {
        while(players.size() < 6)
        {
            Player shadyStranger = new Player("Shady Stranger", 10000);
            players.add(shadyStranger);
        }
    }

    public void emptyRoster(List<Player> players)
    {
        Iterator<Player> iter = players.iterator();
        while (iter.hasNext())
        {
            Player player = iter.next();
            if (player.getName().equals("Shady Stranger")){
                iter.remove();
            }
        }
        counter = 0;
    }
    public void russianRoulettePayOut(List<Player> players, int bullet)
    {
        int losersAnte = losersBet(players, bullet);
        removePlayer(players, bullet);
        payOut(players, losersAnte);
        emptyRoster(players);
    }

}
