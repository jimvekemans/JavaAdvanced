package opdracht1;

public enum CardSuit {
    HEARTS('H'),
    CLUBS('C'),
    SPADES('S'),
    DIAMONDS('D');

    private final char suitChar;

    CardSuit(char suitChar) {
        this.suitChar = suitChar;
    }

    public char getSuitChar() {
        return suitChar;
    }
}
