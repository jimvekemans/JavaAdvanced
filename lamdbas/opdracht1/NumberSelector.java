package opdracht1;

import java.util.function.Function;

public class NumberSelector {
    private NumberMachine numberMachine;

    public NumberSelector(NumberMachine numberMachine) {
        this.numberMachine = numberMachine;
    }

    void showEvenNumbers() {
        numberMachine.processNumbers(
                new NumberFilter() {
                    @Override
                    public boolean check(Integer number) {
                        return number % 2 == 0;
                    }
                }
        );
    }

    void showNumbersAbove(Integer testValue) {
        numberMachine.processNumbers(number -> number > testValue);
    }

    void printHexNumbers() {
        Function<Integer, String> integerToStringFunction = new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return null;
            }
        };
        numberMachine.convertNumbers(integerToStringFunction, 100);
    }

    /*TODO    Maak een derde methode printHexNumbers().
    Deze methode moet de integers printen in
    hexadecimale notatie, die steeds bestaat uit 4 karakters. (bv. 46 => 2E) Hier kan je geen gebruik maken
    maken van de NumberFilter, omdat deze een boolean moet returnen. Maak voor deze oefening een
    methode convertNumbers in NumberMachine, die een standaard functionele interface gebruikt die
    geschikt is voor deze methode. De methode geeft de hexadecimale waarden in een String als
    returnwaarde terug. De waarden zijn opnieuw gescheiden door een streepje -. Gebruik tenslotte de
    methode convertNumbers in combinatie met een lambda expressie om het gewenste resultaat te
    bekomen.
     */
}
