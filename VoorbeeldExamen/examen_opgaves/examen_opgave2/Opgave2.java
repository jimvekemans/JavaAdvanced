package examen_opgave2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Opgave2 {
    public static void main(String[] args) {
        Path passWordFilePath = Paths.get("VoorbeeldExamen/examen_resources/opgave2/passphrases.txt");
        try {
            System.out.println(Files.readAllLines(passWordFilePath)
                    .stream()
                    .map(string -> new PassPhraseValidator<String>(Arrays.asList(string.split(" "))))
                    .filter(validator -> validator.isValid())
                    .count());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
