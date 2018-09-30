package opgave2;

public class Elephant implements Moveable {
    Location location = Location.IN_THE_FOREST;

    @Override
    public void move(Location location) {
        this.location = location;
    }

    @Override
    public Location getCurrentLocation() {
        return location;
    }
}
