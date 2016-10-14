package io.zipcode.Model;

import java.util.*;

/**
 * Created by adam on 10/12/16.
 */
public class Roulette {
    // Fields --------------------------------------
    private Map<Integer, String> wheel;
    private List<RouletteHandler> rouletteHandlers;
    private String color;
    private int number;
    // ---------------------------------------------

    // Constructor ---------------------------------
    public Roulette(List<Player> players) {
        this.wheel = new HashMap<Integer, String>();
        this.fillWheel();
        this.rouletteHandlers = new ArrayList<RouletteHandler>();
        for(Player player : players) {
            rouletteHandlers.add(new RouletteHandler(player));
        }
    }
    // ---------------------------------------------

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

    public RouletteHandler getRouletteHandler(int handlerIndex) {
        return this.rouletteHandlers.get(handlerIndex);
    }

    public Map<Integer, String> getWheel() {
        return this.wheel;
    }

    public boolean placeBetType(int playerIndex, int betOption) {
        this.rouletteHandlers.get(playerIndex).setBetTypeAndPayoff(betOption);
        if(betOption==4) {
            return false;
        }
        return true;
    }

    public void askforNumber(int playerIndex, int guess) throws ValueOutOfRangeException {
        if(guess < 1 || guess > 36) {
            throw new ValueOutOfRangeException();
        }
        this.rouletteHandlers.get(playerIndex).setChosenNumber(guess);
    }

    public int payoff() {
        switch (this.rouletteHandlers.get(0).getBetType()) {
            case ONE_TO_TWELVE:
                if(this.number >= 1 && this.number <= 12) {
                    Player player = this.rouletteHandlers.get(0).getPlayer();
                    player.setBalance(player.getBalance()+(player.getBet()*this.rouletteHandlers.get(0).getPayoff()));
                    return this.rouletteHandlers.get(0).getPlayer().getBet()*this.rouletteHandlers.get(0).getPayoff();
                } else {
                    Player player = this.rouletteHandlers.get(0).getPlayer();
                    player.setBalance(player.getBalance()-(player.getBet()));
                    return this.rouletteHandlers.get(0).getPlayer().getBet()*-1;
                }
            case THIRTEEN_TO_TWENTYFOUR:
                if(this.number >= 13 && this.number <= 24) {
                    Player player = this.rouletteHandlers.get(0).getPlayer();
                    player.setBalance(player.getBalance()+(player.getBet()*this.rouletteHandlers.get(0).getPayoff()));
                    return this.rouletteHandlers.get(0).getPlayer().getBet()*this.rouletteHandlers.get(0).getPayoff();
                } else {
                    Player player = this.rouletteHandlers.get(0).getPlayer();
                    player.setBalance(player.getBalance()-(player.getBet()));
                    return this.rouletteHandlers.get(0).getPlayer().getBet()*-1;
                }
            case TWENTYFIVE_THIRTYSIX:
                if(this.number >= 25 && this.number <= 36) {
                    Player player = this.rouletteHandlers.get(0).getPlayer();
                    player.setBalance(player.getBalance()+(player.getBet()*this.rouletteHandlers.get(0).getPayoff()));
                    return this.rouletteHandlers.get(0).getPlayer().getBet()*this.rouletteHandlers.get(0).getPayoff();
                } else {
                    Player player = this.rouletteHandlers.get(0).getPlayer();
                    player.setBalance(player.getBalance()-(player.getBet()));
                    return this.rouletteHandlers.get(0).getPlayer().getBet()*-1;
                }
            case ONE_NUMBER:
                if(this.number==this.rouletteHandlers.get(0).getChosenNumber()) {
                    Player player = this.rouletteHandlers.get(0).getPlayer();
                    player.setBalance(player.getBalance()+(player.getBet()*this.rouletteHandlers.get(0).getPayoff()));
                    return this.rouletteHandlers.get(0).getPlayer().getBet()*this.rouletteHandlers.get(0).getPayoff();
                } else {
                    Player player = this.rouletteHandlers.get(0).getPlayer();
                    player.setBalance(player.getBalance()-(player.getBet()));
                    return this.rouletteHandlers.get(0).getPlayer().getBet()*-1;
                }
            default:
                return -99999;
        }
    }
}
