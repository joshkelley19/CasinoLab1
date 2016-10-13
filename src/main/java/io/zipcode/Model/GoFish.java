package io.zipcode.Model;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by kyle on 10/12/16.
 */
public class GoFish extends Engine {
    public ArrayList<CardHandler> goFishPlayers = new ArrayList<>();
    public Deck goFishDeck = new Deck();
    private ArrayList<Integer> playerBets = new ArrayList<Integer>();

    public void start(ArrayList<Player> players) {
        for (Player p : players) {
            goFishPlayers.add(new CardHandler(p));
        }
    }

    public void giveCards(ArrayList<CardHandler> goFishCards) {
        int numberOfCards;
        if (goFishPlayers.size() > 2) {
            numberOfCards = 5;
        } else {
            numberOfCards = 7;
        }
        int loop = numberOfCards * goFishCards.size();
        for (int i = 0; i < loop; i++) {
            goFishPlayers.get(i % goFishPlayers.size()).addCard(goFishDeck.dealCard());
        }
    }
    public static String stringInput(String prompt) {
        System.out.println(prompt);
        Scanner scanner = new Scanner(System.in);
        String out = scanner.next();
        return out;
    }
    public static int betInput(String prompt) {
        String userInput = stringInput(prompt);
        int userIntegerInput = Integer.parseInt(userInput);
        return userIntegerInput;
    }

}
