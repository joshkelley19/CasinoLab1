package io.zipcode;

import io.zipcode.View.*;
import io.zipcode.Model.*;

/**
 * Created by joshuakelley on 10/12/16.
 */
public class App {

    public static void main(String[] args) {
        Casino casino = new Casino();
        for (int i = 0; i < 2; i++) {
            casino.startGame();
        }
        casino.enterCasino();
    }

}
