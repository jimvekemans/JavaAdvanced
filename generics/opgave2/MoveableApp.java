package opgave2;

public class MoveableApp {
    public static void main(String[] args) {
        Elephant elephant = new Elephant();
        elephant.move(Location.IN_THE_VILLAGE);
        System.out.println("Elephant: " + elephant.getCurrentLocation());

        ChessPiece chessPiece = new ChessPiece();
        chessPiece.move(new ChessBoardLocation('c', 5));
        System.out.println("ChessPiece: " +chessPiece.getCurrentLocation());
    }
}
