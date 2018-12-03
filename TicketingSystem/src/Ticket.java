import java.util.Random;

public class Ticket {
    String userId;
    String eventId;
    //Ticketformat: <random><userId><random><eventId><random>
    //VB:                       YEA-801-YYE-333-EET
    String ticketId;

    protected Ticket(String userId, String eventId) {
        this.userId = userId;
        this.eventId = eventId;
        this.ticketId = generateTicketId(userId, eventId);
    }

    public static String generateTicketId(String userId, String eventId) {
        //Het is blijkbaar dikke miserie om een Character object(wrapper) naar char(primitief type) te krijgen
        Character[] characterArr = new Random()
                .ints(9, 65, 91)
                .mapToObj(num -> ((char) num))
                .toArray(Character[]::new);

        char[] charArr = new char[characterArr.length];
        for (int i = 0; i < characterArr.length; i++) {
            charArr[i] = characterArr[i].charValue();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(charArr, 0, 3);
        sb.append("-");
        sb.append(userId.split("-")[1]);
        sb.append("-");
        sb.append(charArr, 3, 3);
        sb.append("-");
        sb.append(eventId);
        sb.append("-");
        sb.append(charArr, 6, 3);

        return sb.toString();
    }


}
