package stream_oefening2;

import java.util.Random;

public class Challenge2 {
    public static void main(String[] args) {
        // maak een stream met 10 random gehele getallen tussen 0 en 30
        // bekijk hiervoor de methode ints(...) in de klasse Random
        // filter de getallen die deelbaar zijn door 3
        // en geef het maximum
        // gebruik eventueel peek() om een tussenresultaat van de stream te tonen

        int highestNumber = new Random()
                .ints(10)
                .filter(num -> num / 3 == 0)
                .max().getAsInt();


        System.out.println(highestNumber);

    }
}
