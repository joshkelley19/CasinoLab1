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

    public int loadGun()
    {
        Random rand = new Random();
        int bullet = rand.nextInt(6);
        return bullet;
    }

    public boolean pullTrigger(int counter, int bullet)
    {
        if (counter == bullet)
        {
            //System.out.println("-Bang!-");
            display.bang();
            return false;
        }
        else
        {
            //System.out.println("-click-");
            display.click();
            return true;
        }
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
    }
    public void RussianRoulettePayOut(List<Player> players, int bullet)
    {
        int losersAnte = losersBet(players, bullet);
        removePlayer(players, bullet);
        payOut(players, losersAnte);
        emptyRoster(players);
    }

}
