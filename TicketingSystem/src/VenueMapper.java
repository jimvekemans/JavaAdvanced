public class VenueMapper implements Mapper<Venue> {
    @Override
    public Venue map(String[] inputFields) {
        Venue localVenue;
        String venueId = inputFields[0];
        String venueName = inputFields[1];
        String venueStreet = inputFields[2];
        String venueStrNumber = inputFields[3];
        String venueZipCode = inputFields[4];
        String venueCity = inputFields[5];
        int venueCapacity = Integer.parseInt(inputFields[6]);
        //TODO moeten straat en huisnummer samengenomen worden?
        localVenue = new Venue(
                venueName,
                venueStreet,
                venueZipCode,
                venueCity,
                venueCapacity
        );
        return null;
    }
}
