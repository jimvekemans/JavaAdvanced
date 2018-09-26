package demo1;

public class GenericBoxesApp {
    public static void main(String[] args) {
        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setItem("elephant");
        System.out.println(stringBox.getItem());

        GenericBox<Long> longBox = new GenericBox<>();
        longBox.setItem(123569L);
        System.out.println(longBox.getItem());

        GenericBox<Person> personBox = new GenericBox<>();
        personBox.setItem(new Person("Johnny Depp", 55));
        System.out.println(personBox.getItem().getName());
    }
}
