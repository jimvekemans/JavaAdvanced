package ja.opgave1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class StarWriter extends Thread {

    public StarWriter(Path outputFile, List<Star> stars) {
        try (BufferedWriter writer = Files.newBufferedWriter(outputFile)) {
            //IntStream starXCoordinateStream = stars.stream().mapToInt(star -> star.getX());
            int smallestXCoordinate = stars.stream().mapToInt(star -> star.getX()).min().getAsInt();
            int largestXCoordinate = stars.stream().mapToInt(star -> star.getX()).max().getAsInt();

            //IntStream starYCoordinateStream = stars.stream().mapToInt(star -> star.getY());
            int smallestYCoordinate = stars.stream().mapToInt(star -> star.getY()).min().getAsInt();
            int largestYCoordinate = stars.stream().mapToInt(star -> star.getY()).max().getAsInt();

            for (int xCounter = 0; xCounter <= largestXCoordinate - smallestXCoordinate; xCounter++) {
                for (int yCounter = 0; yCounter <= largestYCoordinate - smallestYCoordinate; yCounter++) {
                    int currentX = xCounter;
                    int currentY = yCounter;
                    if (stars.stream().anyMatch(star -> star.getX() == currentX && star.getY() == currentY)) {
                        writer.write('#');
                    } else {
                        writer.write('.');
                    }
                }
                writer.newLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    // TODO implement thread

}
