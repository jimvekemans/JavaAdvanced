package lambda_opdracht1;

import java.util.function.Function;

/*
  Maak een klasse NumberSelector met als member variabele een NumberMachine object.
  Dit object wordt aan de constructor meegegeven en daar ook in de member variabele opgeslagen.
*/
public class NumberSelector {
    private NumberMachine numberMachine;

    public NumberSelector(NumberMachine numberMachine) {
        this.numberMachine = numberMachine;
    }

    /*
      Definieer in deze klasse de methode showEvenNumbers().
      Zorg dat deze methode de methode processNumbers van het NumberMachine object oproept en
      de NumberFilter op die manier implementeert zodat enkel even getallen afgeprint zullen worden.
      Doe dit door gebruik te maken van een anonieme geneste klasse.
    */
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

    /*
      Maak nu een tweede methode: showNumbersAbove(), eveneens in de NumberSelector klasse.
      Deze methode krijgt een integer als parameter mee en zal opnieuw de processNumbers methode gebruiken,
       maar deze keer om enkel getallen uit te printen die boven het meegegeven getal liggen.
      Definieer de instantie van NumberFilter met behulp van een lambda expressie.
    */
    void showNumbersAbove(Integer testValue) {
        numberMachine.processNumbers(number -> number > testValue);
    }

    /*
      Maak tenslotte een derde methode printHexNumbers().
      Deze methode moet de integers printen in hexadecimale notatie, die steeds bestaat uit 4 karakters (bv. 46 => 2E).
      Hier kan je geen gebruik maken maken van de NumberFilter, omdat deze een boolean moet returnen.
      Maak voor deze oefening een methode convertNumbers in NumberMachine,
       die een standaard functionele interface gebruikt die geschikt is voor deze methode.
      De methode geeft de hexadecimale waarden in een String als returnwaarde terug.
      De waarden zijn opnieuw gescheiden door een streepje -.
      Gebruik tenslotte de methode convertNumbers in combinatie met een lambda expressie om het gewenste resultaat te bekomen.
      //TODO wtf bedoelen ze met deze tekst
   */
    void printHexNumbers() {
        Function<Integer, String> integerToStringFunction = integer -> String.valueOf(integer.hashCode());
        numberMachine.convertNumbers(integerToStringFunction, 100);
    }
}
