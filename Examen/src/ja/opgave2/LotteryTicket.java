package ja.opgave2;

import java.time.LocalDateTime;
import java.util.List;

public class LotteryTicket {
    private String sellingPoint;
    private LocalDateTime dateTime;
    private boolean quickpick;
    private int ticketNumber;
    private List<Integer> chosenNumbers;

    public List<Integer> getChosenNumbers() {
        return chosenNumbers;
    }

    public void setChosenNumbers(List<Integer> chosenNumbers) {
        this.chosenNumbers = chosenNumbers;
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isQuickpick() {
        return quickpick;
    }

    public void setQuickpick(boolean quickpick) {
        this.quickpick = quickpick;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Override
    public String toString() {
        return "LotteryTicket{" +
                "sellingPoint='" + sellingPoint + '\'' +
                ", dateTime=" + dateTime +
                ", quickpick=" + quickpick +
                ", ticketNumber='" + ticketNumber + '\'' +
                '}';
    }
}
