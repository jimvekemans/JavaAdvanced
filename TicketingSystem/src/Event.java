import java.time.LocalDateTime;
import java.util.ArrayList;

public class Event {
    private static int count = 0;
    ArrayList<User> attendees;
    private String name;
    private LocalDateTime time;
    private String description;
    private double price;
    private String id;
    private Venue venue;

    {
        count++;
    }

    public Event(String name, LocalDateTime time, String description, double price) {
        this.name = name;
        this.time = time;
        this.description = description;
        this.price = price;

        this.id = generateId();
    }

    private String generateId() {
        StringBuilder builder = new StringBuilder(this.name.substring(0, 4));
        builder.append("-");
        builder.append(String.format("%4d", count));
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addAttendee(User user) {
        attendees.add(user);
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
