package io.zipcode.Model;

import java.util.Scanner;

public class User {

        public static String stringInput(String prompt) {
            System.out.println(prompt);
            Scanner scanner = new Scanner(System.in);
            String out = scanner.next();
            return out;
        }
    public static int integerInput(String prompt) {
        String userInput = stringInput(prompt);
        int userIntegerInput = Integer.parseInt(userInput);
        return userIntegerInput;
    }
    }
