public class Venue {
    private static int count = 0;

    private String name;
    private String street;
    private String zipCode;
    private String city;
    private int capacity;
    private String id;

    {
        count++;
    }

    public Venue(String name, String street, String zip, String city, int cap) {
        this.name = name;
        this.street = street;
        this.zipCode = zip;
        this.city = city;
        this.capacity = cap;

        this.id = generateId();
    }

    private String generateId() {
        StringBuilder builder = new StringBuilder("V-");
        builder.append(String.format("%4d", count));
        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
