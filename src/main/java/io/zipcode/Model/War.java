package io.zipcode.Model;

/**
 * Created by zacharywasserman on 10/12/16.
 */
public class War
{
    public void playWar()
    {
        Deck deck = new Deck();
        Card playersDraw = deck.dealCard();
        Card dealersDraw = deck.dealCard();

    }
    public Player getWinner(Card playersCard, Card dealersCard)
    {
        if(cardValue(playersCard) > cardValue(dealersCard))
        {
            return 
        }
        if(cardValue(playersCard) == cardValue(dealersCard))
        {

        }
        else
        {

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
