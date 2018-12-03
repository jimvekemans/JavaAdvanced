import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketSystemTest {
    TicketSystem sut;

    @BeforeEach
    void setUp() {
        sut = new TicketSystem(new QueueService());
    }

    @Test
    void getUser() {
    }

    @Test
    void getEvent() {
    }

    @Test
    void getVenue() {
    }

    @Test
    void requestTicket() {
    }

    @Test
    void viewNext() {
    }

    @Test
    void findEventByName() {
    }

    @AfterEach
    void tearDown() {
        sut = null;
    }

}