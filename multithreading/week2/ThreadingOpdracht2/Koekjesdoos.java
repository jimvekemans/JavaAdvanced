package week2.ThreadingOpdracht2;

public class Koekjesdoos {
    private int aantalKoekjes;

    public Koekjesdoos(int aantalKoekjes) {
        this.aantalKoekjes = aantalKoekjes;
    }

    public boolean neemKoekje() {
        if (aantalKoekjes > 0) {
            aantalKoekjes--;
            return true;
        }
        return false;
    }
}
