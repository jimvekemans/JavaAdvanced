import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TicketSystem {
    static Map<String, User> userMap;
    static Map<String, Event> eventMap;
    static Map<String, Venue> venueMap;
    QueueService queueService;

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

    public TicketSystem(QueueService queueService) {
        this.queueService = queueService;
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

    static boolean isWithinAWeekFromNow(LocalDateTime dateTime) {
        return dateTime.minusWeeks(1).isBefore(LocalDateTime.now()) && dateTime.isAfter(LocalDateTime.now());
    }

    static void addUser(User user) {
        if (!userMap.containsValue(user))
            userMap.put(user.getId(), user);
    }

    static void addEvent(Event event) {
        if (!eventMap.containsValue(event))
            eventMap.put(event.getId(), event);
    }

    static void addVenue(Venue venue) {
        if (!venueMap.containsValue(venue))
            venueMap.put(venue.getId(), venue);
    }

    static Event findEventByName(String eventName) {
        return eventMap.values()
                .stream()
                .filter(event -> event.getName().equalsIgnoreCase(eventName))
                .findFirst()
                .get();
    }

    static void printSoldOutEvents() {
        eventMap.values()
                .stream()
                .filter(event -> event.attendees.size() >= event.getVenue().getCapacity())
                .forEach(System.out::println);
    }

    static List<Event> getEventsThatUserHasTicketFor(User user) {
        return user.getUserTickets()
                .stream()
                .map(ticket -> findEventByName(ticket.eventId))
                .collect(Collectors.toList());
    }

    static void printVenuesWithEventsThisWeek() {
        eventMap.values()
                .stream()
                .filter(event -> isWithinAWeekFromNow(event.getTime()))
                .map(Event::getVenue)
                .distinct()
                .forEach(System.out::println);
    }

    void requestTicket(Event event, User user) {
        queueService.addToQueue(event.getId(), user);
    }

    void assignTickets(String eventId, int number) {
        Event event = getEvent(eventId);
        for (int i = 0; i < number; i++) {
            User nextInLine = queueService.getNextInLine(eventId);
            nextInLine.assignTicket(new Ticket(nextInLine.getId(), eventId));
            queueService.removeFromQueue(eventId);
        }
    }

    User viewNext(String eventId) {
        User user = queueService.getNextInLine(eventId);
        System.out.println(user);
        return user;
    }
}
