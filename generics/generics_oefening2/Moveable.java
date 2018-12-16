package generics_oefening2;

public interface Moveable {
    <T> void move(T location);

    Location getCurrentLocation();
}
