package opdracht1;

import java.util.ArrayList;
import java.util.function.Function;

/*
  De klasse NumberMachine bevat een lijst van integers die verwerkt moeten worden.
  De klasse heeft ook een methode processNumbers, die de lijst van integers zal gaan inspecteren
   en afhankelijk hiervan een selectie van getallen zal samenzetten in een String waarde
   (met telkens een streepje er tussen: bv. 1-2-3), die daarna als return waarde wordt gegeven.
  De manier waarop de integers verwerkt worden, wordt bepaald door een object dat de interface NumberFilter implementeert.
*/
public class NumberMachine {
    private ArrayList<Integer> numbers = new ArrayList<>();

    public NumberMachine(int[] numbers) {
        for (int i = 0; i < numbers.length; i++)
            this.numbers.add(numbers[i]);
    }

    public String processNumbers(NumberFilter filter) {
        StringBuilder result = new StringBuilder();
        for (int number : numbers) {
            if (filter.check(number)) {
                if (!result.equals("")) {
                    result.append("-");
                }
                result.append(number);
            }
        }
        return result.toString();
    }

    public String convertNumbers(Function<Integer, String> function, Integer number) {
        return function.apply(number);
    }
}
