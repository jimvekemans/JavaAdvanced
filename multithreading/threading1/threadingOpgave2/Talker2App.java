package threading1.threadingOpgave2;

import java.util.ArrayList;
import java.util.List;

public class Talker2App {
    public static void main(String[] args) {
        List<Talker2> runnables = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            runnables.add(new Talker2("Thread #" + (i + 1)));
        }
        runnables.forEach(Talker2::run);
    }
}
