import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TicketSystem {
    static Map<String, User> userMap;
    static Map<String, Event> eventMap;
    static Map<String, Venue> venueMap;
    QueueService queueService;

    public TicketSystem(QueueService queueService) {
        this.queueService = queueService;
    }

    //initialisation block -- for info: http://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
    {
        userMap = new HashMap<>();
        eventMap = new HashMap<>();
        venueMap = new HashMap<>();
        UserMapper userMapper = new UserMapper();
        VenueMapper venueMapper = new VenueMapper();
        EventMapper eventMapper = new EventMapper();
        try {
            Files.readAllLines(Paths.get(".\\data\\userdata.txt"))
                    .stream()
                    .map(s -> userMapper.map(s.split(";")))
                    .forEach(user -> userMap.put(user.getId(), user));

            Files.readAllLines(Paths.get(".\\data\\eventdata.txt"))
                    .stream()
                    .map(s -> eventMapper.map(s.split(";")))
                    .forEach(event -> eventMap.put(event.getId(), event));

            Files.readAllLines(Paths.get(".\\data\\venuedata.txt"))
                    .stream()
                    .map(s -> venueMapper.map(s.split(";")))
                    .forEach(venue -> venueMap.put(venue.getId(), venue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static User getUser(String userId) {
        return userMap.get(userId);
    }

    static Event getEvent(String eventId) {
        return eventMap.get(eventId);
    }

    static Venue getVenue(String venueId) {
        return venueMap.get(venueId);
    }

    private static boolean isWithinAWeekFromNow(LocalDateTime dateTime) {
        return dateTime.minusWeeks(1).isBefore(LocalDateTime.now()) && dateTime.isAfter(LocalDateTime.now());
    }

    void addUser(User user) {
        if (!userMap.containsValue(user))
        userMap.put(user.getId(), user);
    }

    void addEvent(Event event) {
        if (!eventMap.containsValue(event))
        eventMap.put(event.getId(), event);
    }

    void addVenue(Venue venue) {
        if (!venueMap.containsValue(venue))
        venueMap.put(venue.getId(), venue);
    }

    void requestTicket(Event event, User user) {
        queueService.addToQueue(event.getId(), user);
    }

    User viewNext(String eventId) {
        User user = queueService.getNextInLine(eventId);
        System.out.println(user);
        return user;
    }

    void assignTickets(String eventId, int number) {
        Event event = getEvent(eventId);
        for (int i = 0; i < number; i++) {
            //TODO do I need a Ticket-class or what does a ticket look like? and how do I give these users one?
            User nextInLine = queueService.getNextInLine(eventId);
            nextInLine.assignTicket(new Ticket(nextInLine.getId(), eventId));
            //TODO should the queueservice be updated when assigning tickets?
        }
    }

    Event findEventByName(String eventName) {
        return eventMap.values()
                .stream()
                .filter(event -> event.getName().equalsIgnoreCase(eventName))
                .findFirst()
                .get();
    }

    void printSoldOutEvents() {
        eventMap.values()
                .stream()
                .filter(event -> event.attendees.size() >= event.getVenue().getCapacity())
                .forEach(System.out::println);
    }

    void printVenuesWithEventsThisWeek() {
        eventMap.values()
                .stream()
                .filter(event -> isWithinAWeekFromNow(event.getTime()))
                .map(Event::getVenue)
                .distinct()
                .forEach(System.out::println);
    }

}
