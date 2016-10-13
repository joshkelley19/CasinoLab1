package io.zipcode.Model;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zacharywasserman on 10/12/16.
 */
public class RussianRoulette
{

    public void playRR(List<Player> players)
    {
        fillRoster(players);
        Scanner input = new Scanner(System.in);
        Boolean keepGoing = true;
        int counter = 0;
        int bullet = loadGun();
        while (keepGoing == true)
        {
            System.out.println("");
            System.out.println(players.get(counter).getName() + "'s turn.");
            System.out.println("Press enter to pull the trigger.");
            String trigger = input.nextLine();
            keepGoing = pullTrigger(counter, bullet);
            counter++;
        }
        int losersAnte = losersBet(players, bullet);
        removePlayer(players, bullet);
        payOut(players, losersAnte);
        emptyRoster(players);
    }

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
            return false;
        }
        else
        {
            //System.out.println("-click-");
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

}
