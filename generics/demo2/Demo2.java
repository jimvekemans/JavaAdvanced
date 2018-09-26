package demo2;

public class Demo2 {
    public static void main(String[] args) throws HabitatOvercrowdedException {
        //Habitat<String> stringHouse = new Habitat<>();
        Habitat<Snail> cochlea = new Habitat<>();
        //cochlea.addInhabitant(new Cat());
        cochlea.addInhabitant(new Snail());
    }
}
