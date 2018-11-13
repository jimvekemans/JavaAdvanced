package opdracht1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Deck {
    private Deque<Card> deckOfCards;

    public Deck() {
        deckOfCards = new ArrayDeque<>();
        ArrayList<Card> localCardList = new ArrayList<>();
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                localCardList.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(localCardList);
        //localCardList.forEach(deckOfCards::add);
        deckOfCards.addAll(localCardList);
    }

    public int getDeckSize() {
        return deckOfCards.size();
    }

    public Card dealCard() {
        return (getDeckSize() > 0) ?
                deckOfCards.getFirst() :
                null;
    }
}
