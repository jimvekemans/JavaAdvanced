package stream_oefening3;

import java.util.Arrays;
import java.util.List;

public class Challenge3 {
    public static void main(String[] args) {
        List<String> topNames = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        // 1. Druk alle namen van de lijst af in gesorteerde volgorde.
        // Zorg dat de eerste letter van een naam steeds met hoofdletter begint.
        System.out.println("Challenge 3 - stream 1");
        //topNames.sort();
        topNames.stream()
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .forEach(System.out::println);

        // 2. Druk alle namen af die beginnen met A (of a)
        // Zorg dat de eerste letter van een naam steeds met hoofdletter begint.
        // Verwachte output: Amelia Ava
        System.out.println("Challenge 3 - stream 2");
        topNames.stream()
                .filter(s -> s.substring(0, 1).equalsIgnoreCase("a"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase())
                .forEach(System.out::println);

        // 3. Hoeveel namen beginnen er met A
        // Verwachte output: 2
        System.out.println("Challenge 3 - stream 3");
        System.out.println("Aantal namen die beginnen met A: " + topNames.stream()
                .filter(s -> s.substring(0, 1).equalsIgnoreCase("a"))
                .count());

    }
}
