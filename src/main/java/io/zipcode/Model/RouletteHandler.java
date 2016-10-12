package io.zipcode.Model;

/**
 * Created by adam on 10/12/16.
 */
public class RouletteHandler {

    public enum BetType {
        ONE_TO_TWELVE,
        THIRTEEN_TO_TWENTYFOUR,
        TWENTYFIVE_THIRTYSIX,
        ONE_NUMBER
    }

    // Fields ------------------------
    private Player player;
    private BetType betType;
    private int payoff;
    // -------------------------------

    // Constructor ---------------------------
    public RouletteHandler(Player player) {
        this.player = player;
    }
    // ---------------------------------------

    public void setBetTypeAndPayoff(int playerChoice) {
        switch (playerChoice) {
            case 1:
                this.betType = BetType.ONE_TO_TWELVE;
                this.payoff = 2;
                break;
            case 2:
                this.betType = BetType.THIRTEEN_TO_TWENTYFOUR;
                this.payoff = 2;
                break;
            case 3:
                this.betType = BetType.TWENTYFIVE_THIRTYSIX;
                this.payoff = 2;
                break;
            case 4:
                this.betType = BetType.ONE_NUMBER;
                this.payoff = 35;
        }
    }

    public BetType getBetType() {
        return this.betType;
    }

    public int getPayoff() {
        return this.payoff;
    }

    public Player getPlayer() {
        return this.player;
    }
}
