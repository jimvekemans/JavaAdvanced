package examen_opgave2;

import java.util.Arrays;

public class PassPhraseValidatorTester {

    public static void main(String[] args) {
        PassPhraseValidator<Integer> validIntegerPassPhrase = new PassPhraseValidator<>(Arrays.asList(12, 18, 15, 32));
        validIntegerPassPhrase.start();
        PassPhraseValidator<Integer> invalidIntegerPassPhrase = new PassPhraseValidator<>(Arrays.asList(12, 18, 15, 18, 32));
        invalidIntegerPassPhrase.start();
        PassPhraseValidator<String> validStringPassPhrase = new PassPhraseValidator<>(Arrays.asList("kat", "olifant", "wombat", "ooievaar"));
        validStringPassPhrase.start();
        PassPhraseValidator<String> invalidStringPassPhrase = new PassPhraseValidator<>(Arrays.asList("kat", "wombat", "kat", "olifant", "wombat", "ooievaar", "kat"));
        invalidStringPassPhrase.start();

        System.out.println(validIntegerPassPhrase.getPassPhrase() + " valid: " + validIntegerPassPhrase.isValid());

        System.out.println(invalidIntegerPassPhrase.getPassPhrase() + " valid: " + invalidIntegerPassPhrase.isValid());

        System.out.println(validStringPassPhrase.getPassPhrase() + " valid: " + validStringPassPhrase.isValid());

        System.out.println(invalidStringPassPhrase.getPassPhrase() + " valid: " + invalidStringPassPhrase.isValid());


    }
}
