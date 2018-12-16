package threading2.opdracht2;

public class KoekjesEten {
    public static void main(String[] args) {
        Koekjesdoos koekjesdoos = new Koekjesdoos(50);
        Kind[] kinderen = {
                new Kind("Bram", koekjesdoos),
                new Kind("Sophie", koekjesdoos),
                new Kind("Elke", koekjesdoos),
                new Kind("Robin", koekjesdoos),
                new Kind("Martien", koekjesdoos),
                new Kind("Max", koekjesdoos)};
        for (int i = 0; i < kinderen.length; i++) {
            kinderen[i].start();
        }
        for (int i = 0; i < kinderen.length; i++) {
            try {
                kinderen[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("De kinderen aten: TODO (met een stream :-) ) koekjes");
    }
}
