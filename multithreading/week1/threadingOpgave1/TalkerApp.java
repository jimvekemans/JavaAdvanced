package week1.threadingOpgave1;

import java.util.ArrayList;
import java.util.List;

public class TalkerApp {
    public static void main(String[] args) {
        List<Talker> runnables = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            runnables.add(new Talker("Thread #" + (i + 1)));
        }
        runnables.forEach(Talker::run);
    }
}
