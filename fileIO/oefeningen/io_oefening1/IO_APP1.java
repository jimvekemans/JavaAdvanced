package oefeningen.io_oefening1;

import java.nio.file.Path;
import java.nio.file.Paths;

public class IO_APP1 {
    public static void main(String[] args) {
        //System.getProperties().stringPropertyNames().forEach(System.out::println);
        printSeparator("Om te starten");
        System.out.println(System.getProperty("user.home"));
        printSeparator("Paths: oefening 1");
        Path userHome = Paths.get(System.getProperty("user.home"));
        System.out.println("1. " + userHome);
        System.out.println("2. " + userHome.getClass());
        Path subPath = userHome.resolve("oefeningen\\io_oefening1\\Fase2");
        System.out.println("3. " + subPath);
        printSeparator("Paths: oefening 2");
        System.out.println(subPath.toString());
        System.out.println(subPath.getFileName());
        System.out.println(subPath.getName(0));
        System.out.println(subPath.getNameCount());
        System.out.println(subPath.subpath(0, 2));
        System.out.println(subPath.getParent());
        System.out.println(subPath.getRoot());
    }

    static void printSeparator(String kopNaam) {
        String separator = "-------------------------------------------------------";
        System.out.println(separator + "\r\n\t\t" + kopNaam + "\r\n" + separator);
    }
}

