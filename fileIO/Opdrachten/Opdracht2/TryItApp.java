package Opdrachten.Opdracht2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TryItApp {
    public static void main(String[] args) {
        System.out.println(didThisPathWork("./fileIO/Opdrachten/Opdracht2/bijlage1.txt"));
        System.out.println(didThisPathWork("fileIO/Opdrachten/Opdracht2/bijlage1.txt"));
        System.out.println(didThisPathWork(".\\fileIO\\Opdrachten\\Opdracht2\\bijlage1.txt"));
        System.out.println(didThisPathWork("fileIO\\Opdrachten\\Opdracht2\\bijlage1.txt"));
    }

    private static boolean didThisPathWork(String pathString) {
        Path path = Paths.get(pathString);

        try (BufferedReader reader = new BufferedReader(new FileReader(pathString))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("Oops, something went wrong!");
            System.out.println(ex.getMessage());
            return false;
        }

        try (Stream<String> stream = Files.lines(path)) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
