package oefeningen.io_oefening2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;

public class IO_APP2 {

    public static void main(String[] args) {
        Path inputFilePath = Paths.get(".\\resources\\bijlage1.txt");
        Path outputFilePath = Paths.get(".\\outputFiles\\oef2fileio.txt");
        try (
                BufferedReader bufferedReader = Files.newBufferedReader(inputFilePath);
                BufferedWriter bufferedWriter = Files.newBufferedWriter(outputFilePath)
        ) {
            Set<String> allLines = bufferedReader
                    .lines()
                    .collect(Collectors.toSet());
            for (String line : allLines) {
                bufferedWriter.write(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
