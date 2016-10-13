package io.zipcode.Model;

/**
 * Created by jamescrawley on 10/13/16.
 */
public class CannotPlayCardException extends Exception {

    CannotPlayCardException () {
        super();
    }

    CannotPlayCardException (String message) {
        super(message);
    }
}
