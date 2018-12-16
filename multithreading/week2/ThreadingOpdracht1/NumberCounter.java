package week2.ThreadingOpdracht1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class NumberCounter implements Runnable {
    private Path file;
    private int number;

    public NumberCounter(Path file, int number) {
        this.file = file;
        this.number = number;
    }

    public long countNumberInFile() {
        //telt het aantal keren dat het private number voorkomt in het ingelezen IP-file
        long count = 0;
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                count += Arrays.stream(line.split("\\."))
                        .filter(s -> String.valueOf(number).equals(s))
                        .count();
            }
            return count;
        } catch (IOException e) {
            System.out.println("Cannot count numbers in file " + file.getFileName());
        }
        return 0;
    }


    @Override
    public void run() {
        this.countNumberInFile();
    }
}
