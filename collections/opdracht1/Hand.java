package opdracht1;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Hand {
    TreeSet<Card> cardsInHand;

    {
        cardsInHand = new TreeSet<>();
    }

    public void addCard(Card card) {
        if (cardsInHand != null) {
            cardsInHand.add(card);
        }
    }

    public List<String> showHand() {
        return cardsInHand.stream()
                .map(Card::toString)
                .collect(Collectors.toList());
    }

    public boolean hasColor(CardSuit cardSuit) {
        return cardsInHand.stream()
                .anyMatch(card -> card.getSuit() == cardSuit);
    }
}
