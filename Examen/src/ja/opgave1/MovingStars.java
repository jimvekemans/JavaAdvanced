package ja.opgave1;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MovingStars {
    public static void main(String[] args) {
        List<Star> stars = new ArrayList<>();
        stars.add(new Star(9, 1, 0, 2));
        stars.add(new Star(7, 0, -1, 0));
        stars.add(new Star(3, -2, -1, 1));
        stars.add(new Star(6, 10, -2, -1));
        stars.add(new Star(2, -4, 2, 2));
        stars.add(new Star(-6, 10, 2, -2));
        stars.add(new Star(1, 8, 1, -1));
        stars.add(new Star(1, 7, 1, 0));
        stars.add(new Star(-3, 11, 1, -2));
        stars.add(new Star(7, 6, -1, -1));
        stars.add(new Star(-2, 3, 1, 0));
        stars.add(new Star(-4, 3, 2, 0));
        stars.add(new Star(10, -3, -1, 1));
        stars.add(new Star(5, 11, 1, -2));
        stars.add(new Star(4, 7, 0, -1));
        stars.add(new Star(8, -2, 0, 1));
        stars.add(new Star(15, 0, -2, 0));
        stars.add(new Star(1, 6, 1, 0));
        stars.add(new Star(8, 9, 0, -1));
        stars.add(new Star(3, 3, -1, 1));
        stars.add(new Star(0, 5, 0, -1));
        stars.add(new Star(-2, 2, 2, 0));
        stars.add(new Star(5, -2, 1, 2));
        stars.add(new Star(1, 4, 2, 1));
        stars.add(new Star(-2, 7, 2, -2));
        stars.add(new Star(3, 6, -1, -1));
        stars.add(new Star(5, 0, 1, 0));
        stars.add(new Star(-6, 0, 2, 0));
        stars.add(new Star(5, 9, 1, -2));
        stars.add(new Star(14, 7, -2, 0));
        stars.add(new Star(-3, 6, 2, -1));

        for (int i = 0; i <= 3; i++) {
            new StarWriter(Paths.get("resources/output/" + i + ".txt"), deepCopy(stars)).start();
            for (Star star : stars) {
                star.move();
            }
        }
    }

    private static List<Star> deepCopy(List<Star> stars) {
        List<Star> copy = new ArrayList<>(stars.size());
        for (Star star : stars) {
            copy.add(new Star(star));
        }
        return copy;
    }
}
