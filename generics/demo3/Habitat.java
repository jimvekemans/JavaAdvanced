package demo3;

import demo2.Animal;

public interface Habitat<A extends Animal> {
    void addInhabitant(A inhabitant);

    void removeInhabitant(A inhabitant);

    A catchInhabintant();

    int getNumberOfInhabitants();
}
