package io.zipcode.Model;

import io.zipcode.View.Casino;

/**
 * Created by jalisahewitt on 10/14/16.
 */
public class App {
    public static void main(String[] args) {
        Casino casino = new Casino();
        casino.startGame();
        casino.enterCasino();
    }
}
