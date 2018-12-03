import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketSystemTest {
    TicketSystem sut;
    User testUser;
    Event testEvent;
    Venue testVenue;

    @BeforeEach
    void setUp() {
        sut = new TicketSystem(new QueueService());
        testUser = TicketSystem.getUser("U-000002");
        testEvent = TicketSystem.getEvent("QUE-00002");
        testVenue = TicketSystem.getVenue("V-0002");
    }

    @Test
    void requestTicket() {
        int sizeBeforeRequest = sut.queueService.getQueue(testEvent.getId()).size();
        sut.requestTicket(testEvent, testUser);
        int sizeAfterRequest = sut.queueService.getQueue(testEvent.getId()).size();
        Assertions.assertTrue(sizeBeforeRequest == sizeAfterRequest + 1);
    }

    @Test
    void viewNext() {
    }

    @Test
    void assignTickets() {

    }

    @Test
    void findEventByName() {
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

}