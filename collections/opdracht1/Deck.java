package opdracht1;

import java.util.*;
import java.util.stream.Collectors;

public class Deck {
    //Deque is de beste oplossing voor een pak kaarten, er kan enkel de bovenste en onderste kaart worden afgehaald
    private Deque<Card> deckOfCards;

    public Deck() {
        deckOfCards = new ArrayDeque<>();
        ArrayList<Card> localCardList = new ArrayList<>();
        //Door alle Ranks en Suits loopen om alle combinaties 1 keer aan te maken bij elk nieuw pak kaarten
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
                localCardList.add(new Card(suit, rank));
            }
        }
        Collections.shuffle(localCardList);
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

    public List<String> getDeck() {
        return deckOfCards.stream()
                .map(Card::toString)
                .collect(Collectors.toList());
    }
}
