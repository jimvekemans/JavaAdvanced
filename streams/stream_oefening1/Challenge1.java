package stream_oefening1;

import java.util.Arrays;
import java.util.List;

public class Challenge1 {
    public static void main(String[] args) {
        List<String> tombolaNummers = Arrays.asList("A12", "a20", "B120", "b72", "d53", "D42", "d50", "F12");
        // print alle tombolanummers die starten met D (of d) gesorteerd, steeds met de eerste letter in uppercase
        // Gewenste output: D42 D50 D53
        tombolaNummers.stream().filter(s -> s.substring(0, 1).equalsIgnoreCase("d"))
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .mapToInt(input -> Integer.parseInt(input.substring(1)))
                .max();

        for (int i = 0; i < tombolaNummers.size(); i++) {
            if (tombolaNummers.get(i).substring(0, 1) == "d" || tombolaNummers.get(i).substring(0, 1) == "D")
                System.out.println(tombolaNummers.get(i));
        }

    }
}
