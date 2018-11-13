package opdracht1;

import java.util.Comparator;

/*
  Het sorteeralgoritme moet als volgt werken:
        eerst moeten alle harten (heart) zitten,
        daarna ruiten (diamond),
        klaveren (clubs) en tenslotte schoppen (spade).
  De kaarten van dezelfde ‘kleur’ (= harten,
  klaveren, ruiten of schoppen) zijn gesorteerd volgens waarde: 2, 3, …, J, Q, K, A.
*/
public class Card implements Comparator<Card>, Comparable<Card> {
    private CardSuit suit;
    private CardRank rank;

    public Card(CardSuit suit, CardRank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public int compare(Card thisCard, Card otherCard) {
        return thisCard.compareTo(otherCard);
    }

    public CardSuit getSuit() {
        return suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public String toString() {
        return rank.getRankString() + " of " + suit.toString();
    }

    @Override
    public int compareTo(Card otherCard) {
        int thisCardValue = rank.getRankValue();
        int otherCardValue = otherCard.getRank().getRankValue();
        CardSuit thisCardSuit = suit;
        CardSuit otherCardSuit = otherCard.getSuit();
        //if higher --> 1, lower --> -1, equal --> 0
        if (thisCardValue > otherCardValue) {
            return -1;
        } else if (thisCardValue < otherCardValue) {
            return 1;
        } else {
            return (thisCardSuit.equals(otherCardSuit)) ? 0 : 1;
        }
    }
}
