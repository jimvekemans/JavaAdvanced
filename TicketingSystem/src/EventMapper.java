import java.time.LocalDateTime;

public class EventMapper implements Mapper<Event> {

    @Override
    public Event map(String[] inputFields) {
        int dayOfMonth = Integer.parseInt(inputFields[1].substring(0, 2));
        int month = Integer.parseInt(inputFields[1].substring(2, 4));
        int year = Integer.parseInt(inputFields[1].substring(4, 6));
        int hour = Integer.parseInt(inputFields[1].substring(6, 8));
        int minute = Integer.parseInt(inputFields[1].substring(8, 10));
        LocalDateTime localDateTime = LocalDateTime.of(year, month, dayOfMonth, hour, minute);
        String eventName = inputFields[2];
        String eventDescription = inputFields[3];
        double eventPrice = Double.parseDouble(inputFields[4]);
        String eventId = inputFields[0];
        String venueId = inputFields[5];
        Event localEvent = new Event(
                eventName,
                localDateTime,
                eventDescription,
                eventPrice
        );
        localEvent.setId(eventId);
        //HashMaps van TicketSystem static instellen voor geheugenbesparing en om static references te kunnen gebruiken
        localEvent.setVenue(TicketSystem.getVenue(venueId));
        return localEvent;
    }
}
