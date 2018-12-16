package week2.ThreadingOpdracht2;

public class Kind extends Thread {
    private int aantalKoekjes;
    private Koekjesdoos koekjesdoos;
    private String naam;

    public Kind(String naam, Koekjesdoos koekjesdoos) {
        this.koekjesdoos = koekjesdoos;
        this.naam = naam;
    }

    @Override
    public void run() {
        while (koekjesdoos.neemKoekje()) {
            aantalKoekjes++;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(naam + " at " + aantalKoekjes + " koekjes");
    }

    public int getAantalKoekjes() {
        return aantalKoekjes;
    }
}
