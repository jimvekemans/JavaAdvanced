import java.util.Random;

public class TicketingApp {
    public static void main(String[] args) {
        //Het is blijkbaar dikke miserie om een Character object(wrapper) naar char(primitief type) te krijgen
        String userId = "U-243";
        String eventId = "E-102";

        Character[] characterArr = new Random()
                .ints(9, 65, 91)
                .mapToObj(num -> ((char) num))
                .toArray(Character[]::new);

        char[] charArr = String.valueOf(characterArr).toCharArray();

        System.out.print("Character[]: ");
        for (Character character : characterArr) {
            System.out.print(character);
        }

        System.out.println();

        System.out.print("char[]: ");
        for (char character : charArr) {
            System.out.print(character);
        }
    }
}
