package opgave2;

public interface Moveable {
    <T> void move(T location);

    Location getCurrentLocation();
}
