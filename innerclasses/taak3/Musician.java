package taak3;

public class Musician {
    void play() {
        Instrument instrument = new Instrument() {
            @Override
            public void makeNoise() {
                System.out.println("REEEEEEEEEEEEEE");
            }
        };
        instrument.makeNoise();
    }
}