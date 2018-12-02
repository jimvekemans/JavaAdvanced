package collectionFactories;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PhoneNrFactory {
    static List<Integer> generatePhoneNumbers(String numberPrefix, int amountOfNumbers) {
        return generatePhoneNumbers(Integer.parseInt(numberPrefix), amountOfNumbers);
    }

    static List<Integer> generatePhoneNumbers(int numberPrefix, int amountOfNumbers) {
        return new Random()
                .ints(amountOfNumbers, 460000000, 490000000)
                .mapToObj(number -> number)
                .collect(Collectors.toList());
    }
}
