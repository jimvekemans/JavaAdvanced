package threading2.oef2;

public class Teller {
    private String name;
    private BankLine line;

    public Teller(BankLine line, String name) {
        this.name = name;
        this.line = line;
    }
}
