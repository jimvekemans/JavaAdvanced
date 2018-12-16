package week2.ThreadingOefening2;

public class ReportGenerator extends Thread {
    private BankLine line;
    private int reportWait;

    public ReportGenerator(BankLine line, int reportWait) {
        this.line = line;
        this.reportWait = reportWait;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(reportWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("########### REPORT ###############");
            System.out.println(line);
            System.out.println("##################################");

        }
    }
}
