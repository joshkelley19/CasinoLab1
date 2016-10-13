package io.zipcode.Model;

/**
 * Created by joshuakelley on 10/13/16.
 */
public class Slots {
    public enum Symbols{
        BlankSpace(0), JACK(1), QUEEN(2), KING(3), ACE(4), DOLLARSIGN(5), DIAMOND(6), SEVEN(7), BELL(8), BAR(9), GRAPE(10), PEAR(11), ORANGE(12), MELON(13), CHERRY(14), JACKPOT(15);

        Symbols(int i) {
        }

    }
    static final Symbols[] symbols = Symbols.values();


    public int[] pull(){
        int[] selectedSymbols=new int[3];
        for(int i=0;i<3;i++){
            selectedSymbols[i] = (int)Math.floor(Math.random()*15);
            if (selectedSymbols[i]==0)selectedSymbols[i]+=1;
            System.out.print(symbols[selectedSymbols[i]]+" | ");
        }
        return selectedSymbols;
    }

    public int reel(int[] symbols){
        boolean match1 = symbols[1]==symbols[0];
        boolean match2 = symbols[1]==symbols[2];
        if(match1&&match2){
            return 1;
        }else if(match1||match2){
            return 2;
        }else return 0;
    }

    public int gameOver(int bet, int chance, int middleSymbol){
        int winnings = -bet;
        switch (chance){
            case 0:break;
            case 1: winnings*=-(middleSymbol*50);break;
            case 2: winnings*=-(middleSymbol*5);break;
        }
        return winnings;
    }
}
