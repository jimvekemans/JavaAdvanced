package threading2.opdracht1;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class IpAddressesProcessor {
    public synchronized static int getAantalKoekjes() {
        return 0;
    }

    public static void main(String[] args) {
        Path directoryPath = Paths.get(".\\resources\\testdata");
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directoryPath)) {

        } catch (IOException ioe) {

        }
        long result = new NumberCounter(Paths.get("resources/testdata/ip_addresses_20181201.csv"), 130).countNumberInFile();
        System.out.println(result);
    }
}
