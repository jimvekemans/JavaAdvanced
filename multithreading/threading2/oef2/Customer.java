package threading2.oef2;

public class Customer {
    private static final int MIN_SERVICE_TIME = 1000;
    private static final int MAX_SERVICE_TIME = 10000;
    private String name;
    private int serviceTime;
    private long lineInTime;


    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
