package io.zipcode.Model;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by zacharywasserman on 10/12/16.
 */
public class RussianRoulette {

    public void playRR(List<Player> players) {
        Scanner input = new Scanner(System.in);
        Boolean keepGoing = true;
        int counter = 0;
        int bullet = loadGun();
        while (keepGoing == true) {
            System.out.println("");
            System.out.println(players.get(counter).getName());
            System.out.println("Press enter to pull the trigger");
            String trigger = input.nextLine();
            keepGoing = pullTrigger(counter, bullet);
            counter++;
        }
        int losersAnte = losersBet(players, bullet);
        removePlayer(players, bullet);
        payOut(players, losersAnte);
    }

    public int loadGun() {
        Random rand = new Random();
        int bullet = rand.nextInt(6);
        return bullet;
    }

    public boolean pullTrigger(int counter, int bullet) {
        if (counter == bullet) {
            //System.out.println("-Bang!-");
            return false;
        } else {
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




}

