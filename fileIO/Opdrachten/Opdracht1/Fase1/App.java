package Opdrachten.Opdracht1.Fase1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        //System.getProperties().stringPropertyNames().forEach(System.out::println);
        printSeparator("Om te starten");
        System.out.println(System.getProperty("user.home"));
        printSeparator("Paths: oefening 1");
        Path userHome = Paths.get(System.getProperty("user.home"));
        System.out.println("1. " + userHome);
        System.out.println("2. " + userHome.getClass());
        Path subPath = userHome.resolve("Opdrachten\\Opdracht1\\Fase2");
        System.out.println("3. " + subPath);
        printSeparator("Paths: oefening 2");
    }

    static void printSeparator(String kopNaam) {
        String separator = "-------------------------------------------------------";
        System.out.println(separator + "\r\n\t\t" + kopNaam + "\r\n" + separator);
    }
}

