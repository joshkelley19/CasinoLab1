package io.zipcode.Model;

import io.zipcode.View.Display;

import java.util.List;

/**
 * Created by zacharywasserman on 10/12/16.
 */
public class War
{
    Deck deck = new Deck();
    Display display = new Display();

    public String getWinner(Card playersCard, Card dealersCard)
    {
        if(cardValue(playersCard) > cardValue(dealersCard))
        {
            display.youWin();
            return "player";
        }
        if(cardValue(playersCard) == cardValue(dealersCard))
        {
            display.tie();
            dealCards();
            return null;
        }
        else
        {
            display.youLose();
            return "dealer";
        }
    }

    public String dealCards()
    {
        Card playersDraw = deck.dealCard();
        Card dealersDraw = deck.dealCard();
        display.displayCards(playersDraw, dealersDraw);
        return getWinner(playersDraw, dealersDraw);
    }

    public void warPayOut(List<Player> players, String winner)
    {
        for (Player player: players) {
            if (winner.equals("player")) {
                player.setBalance(player.getBet());
            }
            else
            {
                player.setBalance(-player.getBet());
            }
        }
    }

    public int cardValue(Card card)
    {
        if(card.getRank() == "ACE")
        {
            return 14;
        }
        if(card.getRank() == "2")
        {
            return 2;
        }
        if(card.getRank() == "3")
        {
            return 3;
        }
        if(card.getRank() == "4")
        {
            return 4;
        }
        if(card.getRank() == "5")
        {
            return 5;
        }
        if(card.getRank() == "6")
        {
            return 6;
        }
        if(card.getRank() == "7")
        {
            return 7;
        }
        if(card.getRank() == "8")
        {
            return 8;
        }
        if(card.getRank() == "9")
        {
            return 9;
        }
        if(card.getRank() == "10")
        {
            return 10;
        }
        if(card.getRank() == "JACK")
        {
            return 11;
        }
        if(card.getRank() == "QUEEN")
        {
            return 12;
        }
        if(card.getRank() == "KING")
        {
            return 13;
        }
        else{
            return 0;
        }
    }


}
