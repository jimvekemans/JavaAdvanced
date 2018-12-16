package opdracht1;

public enum CardSuit {
    HEARTS('H', 1),
    DIAMONDS('D', 2),
    CLUBS('C', 3),
    SPADES('S', 4);

    private final char suitChar;
    private final int suitValue;

    CardSuit(char suitChar, int value) {
        this.suitChar = suitChar;
        this.suitValue = value;
    }

    public char getSuitChar() {
        return suitChar;
    }

    public int getSuitValue() {
        return suitValue;
    }
}
