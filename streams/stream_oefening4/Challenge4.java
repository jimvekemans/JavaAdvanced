package stream_oefening4;

import stream_oefening4.Person.Gender;

import java.util.Arrays;
import java.util.List;

public class Challenge4 {
    public static void main(String[] args) {
        List<Person> personen = Arrays.asList(
                new Person("Sofie", 23, Gender.FEMALE),
                new Person("Adam", 31, Gender.MALE),
                new Person("Bastiaan", 25, Gender.MALE),
                new Person("Berend", 22, Gender.MALE),
                new Person("Aagje", 27, Gender.FEMALE)
        );
        // 1. Geef de gemiddelde leeftijd van alle personen
        // Verwachte output:  Gemiddelde leeftijd: 25.6
        System.out.println(
                "Gemiddelde leeftijd: " +
                        personen.stream()
                                .mapToDouble(p -> p.getAge())
                                .average()
        );


        // 2. Hoeveel mannen staan er in de lijst
        // Verwachte output: Aantal mannen: 3
        System.out.println(
                "Aantal mannen: " +
                        personen.stream()
                                .filter(p -> p.getGender() == Gender.MALE)
                                .count());

        // 3. Hoeveel mannen ouder dan 24 staan er in de lijst
        // Verwachte output: Aantal mannen boven 24: 2
        System.out.println(
                "Aantal mannen boven 24: " +
                        personen.stream()
                                .filter(p -> p.getGender() == Gender.MALE)
                                .filter(p -> p.getAge() > 24)
                                .count()
        );

        // 4. Geef de gemiddelde leeftijd van alle mannen
        // Gemiddelde leeftijd mannen: 26.0
        System.out.println(
                "Gemiddelde leeftijd: " +
                        personen.stream()
                                .filter(p -> p.getGender() == Gender.MALE)
                                .mapToDouble(p -> p.getAge())
                                .average()
        );

        // 5. Maak een nieuwe persoon met als naam de eerste letter van iedere persoon in de lijst
        // en als leeftijd de som van alle leeftijden
        // Maak gebruik van de methode .reduce()


    }
}
