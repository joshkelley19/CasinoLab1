package io.zipcode.Model;

import java.util.*;

/**
 * Created by adam on 10/12/16.
 */
public class Roulette {
    // Fields --------------------------------------
    private Map<Integer, String> wheel;
    private List<Player> winners;
    private boolean isRunning;
    private String color;
    private int number;
    // ---------------------------------------------

    // Constructor ----------------------------------
    public Roulette(List<Player> players) {
        this.wheel = new HashMap<Integer, String>();
        this.winners = new ArrayList<Player>();
        this.fillWheel();
    }
    // ----------------------------------------------

    public void playRoulette() { // Core method to run the game
        while(isRunning) {

        }
    }

    private void fillWheel() {
        wheel.put(1, "RED"); wheel.put(3, "RED"); wheel.put(5, "RED");
        wheel.put(7, "RED"); wheel.put(9, "RED"); wheel.put(12, "RED");
        wheel.put(14, "RED"); wheel.put(16, "RED"); wheel.put(18, "RED");
        wheel.put(19, "RED"); wheel.put(21, "RED"); wheel.put(23, "RED");
        wheel.put(25, "RED"); wheel.put(27, "RED"); wheel.put(30, "RED");
        wheel.put(32, "RED"); wheel.put(34, "RED"); wheel.put(36, "RED");

        wheel.put(2, "BLACK"); wheel.put(4, "BLACK"); wheel.put(6, "BLACK");
        wheel.put(8, "BLACK"); wheel.put(10, "BLACK"); wheel.put(11, "BLACK");
        wheel.put(13, "BLACK"); wheel.put(15, "BLACK"); wheel.put(17, "BLACK");
        wheel.put(20, "BLACK"); wheel.put(22, "BLACK"); wheel.put(24, "BLACK");
        wheel.put(26, "BLACK"); wheel.put(28, "BLACK"); wheel.put(29, "BLACK");
        wheel.put(31, "BLACK"); wheel.put(33, "BLACK"); wheel.put(35, "BLACK");
    }

    public void spinWheel() {
        Random rand = new Random();
        int stop = rand.nextInt(36)+1;
        this.number = stop;
        this.color = this.wheel.get(stop);
    }

    public String getColor() {
        return this.color;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Map<Integer, String> getWheel() {
        return this.wheel;
    }

    public void takeBets() {

    }
}
