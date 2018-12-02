import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketSystem {
    static Map<String, User> userMap;
    static Map<String, Event> eventMap;
    static Map<String, Venue> venueMap;
    static List<User> userList;
    static List<Event> eventList;
    static List<Venue> venueList;
    QueueService queueService;

    public TicketSystem(QueueService queueService) {
        this.queueService = queueService;
        init();
    }

    //initialisation block -- for info: http://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
    static void init() {
        userList = new ArrayList<>();
        eventList = new ArrayList<>();
        venueList = new ArrayList<>();
        userMap = new HashMap<>();
        eventMap = new HashMap<>();
        venueMap = new HashMap<>();
        UserMapper userMapper = new UserMapper();
        VenueMapper venueMapper = new VenueMapper();
        EventMapper eventMapper = new EventMapper();
        try {
            Files.readAllLines(Paths.get(".\\TicketingSystem\\data\\userdata.txt"))
                    .stream()
                    .map(s -> userMapper.map(s.split(";")))
                    .forEach(user -> userMap.put(user.getId(), user));

            Files.readAllLines(Paths.get(".\\TicketingSystem\\data\\eventdata.txt"))
                    .stream()
                    .map(s -> eventMapper.map(s.split(";")))
                    .forEach(event -> eventMap.put(event.getId(), event));

            Files.readAllLines(Paths.get(".\\TicketingSystem\\data\\venuedata.txt"))
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
        return LocalDateTime.now().isBefore(dateTime.minusWeeks(1));
    }

    void addUser(User user) {
        userList.add(user);
        userMap.put(user.getId(), user);
    }

    void addEvent(Event event) {
        eventList.add(event);
        eventMap.put(event.getId(), event);
    }

    void addVenue(Venue venue) {
        venueList.add(venue);
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

    /*
       Schrijf een methode assignTickets(eventID, number) in TicketSystem.
       Deze methode zal de eerste X personen (X = number) in de wachtrij van het meegegeven event een ticket toewijzen.
       Probeer zelf te achterhalen wat er precies moet gebeuren om het hele systeem up-to-date te houden.
       Denk hierbij bv. aan de gastenlijst van het event.
     */
    void assignTickets(String eventId, int number) {
        Event event = getEvent(eventId);
        for (int i = 0; i < number; i++) {
            //TODO do I need a Ticket-class or what does a ticket look like? and how do I give these users one?
            //TODO should the queueservice be updated when assigning tickets?
        }
    }

    Event findEventByName(String eventName) {
        return eventList.stream()
                .filter(event -> event.getName().equalsIgnoreCase(eventName))
                .findFirst().get();
    }

    void printSoldOutEvents() {
        eventList.stream()
                .filter(event -> event.attendees.size() >= event.getVenue().getCapacity())
                .forEach(System.out::println);
    }

    void printVenuesWithEventsThisWeek() {
        eventList.stream()
                .filter(event -> isWithinAWeekFromNow(event.getTime()))
                .map(Event::getVenue)
                .distinct()
                .forEach(System.out::println);
    }

}
