package opdracht1;

import java.util.Comparator;

//Ik heb zowel Comparator als Comparable geimplementeerd voor dit nadien nog te kunnen gebruiken bij sorteren in streams
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
        int thisCardRankValue = rank.getRankValue();
        int otherCardRankValue = otherCard.getRank().getRankValue();
        int thisCardSuitValue = suit.getSuitValue();
        int otherCardSuitValue = otherCard.getSuit().getSuitValue();

        // -1 = andere kaart lager plaatsen
        //  0 = andere kaart niet plaatsen
        //  1 = andere kaart hoger plaatsen
        if (thisCardSuitValue > otherCardSuitValue
                || (thisCardSuitValue == otherCardSuitValue && thisCardRankValue > otherCardRankValue)) {
            return -1;
        } else if (thisCardSuitValue < otherCardSuitValue
                || (thisCardSuitValue == otherCardSuitValue && thisCardRankValue < otherCardRankValue)) {
            return 1;
        } else {
            return 0;
        }
    }
}
