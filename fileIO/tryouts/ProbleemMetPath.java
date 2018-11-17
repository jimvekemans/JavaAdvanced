package tryouts;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ProbleemMetPath {
    public static void main(String[] args) {
        try {
            if (Files.exists(Paths.get("fileIO\\tryouts\\bijlage1.txt")))
                System.out.println("Bijlage gevonden");
            if (Files.exists(Paths.get(".\\fileIO\\tryouts\\bijlage1.txt")))
                System.out.println("Bijlage gevonden");
            if (Files.exists(Paths.get("fileIO/tryouts/bijlage1.txt")))
                System.out.println("Bijlage gevonden");
            if (Files.exists(Paths.get("./fileIO/tryouts/bijlage1.txt")))
                System.out.println("Bijlage gevonden");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
OUTPUT:
Bijlage gevonden
Bijlage gevonden
Bijlage gevonden
Bijlage gevonden
 */
