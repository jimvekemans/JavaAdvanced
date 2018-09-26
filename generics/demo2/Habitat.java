package demo2;

public class Habitat<A extends Animal> {
    private A inhabitant;

    public void addInhabitant(A inhabitant) throws HabitatOvercrowdedException {
        if (inhabitant != null) {
            throw new HabitatOvercrowdedException("Habitat full.");
        }
        this.inhabitant = inhabitant;
    }
}
