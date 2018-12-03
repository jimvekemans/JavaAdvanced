package threadingOpgave1;

public class Talker extends Thread {

    String talkerId;

    public Talker(String talkerId) {
        this.talkerId = talkerId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                System.out.println(talkerId);
            } catch (InterruptedException e) {
                System.out.println("Something went wrong");
                e.printStackTrace();
            }
        }
    }
}
