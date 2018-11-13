package opdracht1;

public enum CardRank {
    TWO("Two", 2),
    THREE("Three", 3),
    FOUR("Four", 4),
    FIVE("Five", 5),
    SIX("Six", 6),
    SEVEN("Seven", 7),
    EIGHT("Eight", 8),
    NINE("Nine", 9),
    TEN("Ten", 10),
    JACK("Jack", 11),
    QUEEN("Queen", 12),
    KING("King", 13),
    ACE("Ace", 14);

    private final String rankString;
    private final int rankValue;

    CardRank(String rankString, int rankValue) {
        this.rankString = rankString;
        this.rankValue = rankValue;
    }

    public String getRankString() {
        return rankString;
    }

    public int getRankValue() {
        return rankValue;
    }
}
