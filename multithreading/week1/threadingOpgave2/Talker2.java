package week1.threadingOpgave2;

public class Talker2 implements Runnable {

    String talkerId;

    public Talker2(String talkerId) {
        this.talkerId = talkerId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println(talkerId);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
