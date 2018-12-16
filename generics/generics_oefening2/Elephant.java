package generics_oefening2;

public class Elephant implements Moveable {
    Location location = Location.IN_THE_FOREST;

    @Override
    public <T> void move(T location) {

    }

    @Override
    public Location getCurrentLocation() {
        return location;
    }
}
