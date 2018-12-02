public class Ticket {
    String userId;
    String eventId;
    //Ticketformat: <random><userId><random><eventId><random>
    //VB:                       YEA801YYE333EET
    String ticketId;

    protected Ticket(String userId, String eventId) {
        this.userId = userId;
        this.eventId = eventId;
        this.ticketId = generateTicketId(userId, eventId);
    }

    public static String generateTicketId(String userId, String eventId) {
        return null;
    }


}
