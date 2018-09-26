package demo4;

import demo2.Cat;
import demo3.Habitat;

public class CatShelter implements Habitat<Cat> {
    private Cat inhabitant;

    @Override
    public void addInhabitant(Cat inhabitant) {
        this.inhabitant = inhabitant;
    }

    @Override
    public void removeInhabitant(Cat inhabitant) {
        if (this.inhabitant.equals(inhabitant)) {
            this.inhabitant = null;
        }
    }

    @Override
    public Cat catchInhabintant() {
        return inhabitant;
    }

    @Override
    public int getNumberOfInhabitants() {
        return 1;
    }
}
