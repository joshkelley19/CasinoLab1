package io.zipcode.View;

import java.util.Scanner;

/**
 * Created by joshuakelley on 10/11/16.
 */
public class UserInput {
    Scanner scanner = new Scanner(System.in);

    protected String getString(){
      return scanner.next();
    }

    protected int getInt(){
      return scanner.nextInt();
    }

    protected String pressEnter(){return scanner.nextLine();}
}
