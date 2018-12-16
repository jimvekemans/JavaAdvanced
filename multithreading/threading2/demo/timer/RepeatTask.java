package threading2.demo.timer;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class RepeatTask {
    public static void main(String[] args) {
        TimerTask repeatedTask = new TimerTask() {
            public void run() {
                System.out.println("Task performed on " + LocalDateTime.now());
            }
        };
        Timer timer = new Timer("Timer");
        long delay = 5000L;
        long period = 10000L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
        System.out.println("Timer started " + LocalDateTime.now());
    }
}
