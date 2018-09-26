package demo4;

import demo2.Animal;
import demo3.Habitat;

public class AnimalUtility {
    public static <E extends Animal> void moveAnimals(E animalToMove, Habitat<E> fromHabitat, Habitat<E> toHabitat) {
        fromHabitat.removeInhabitant(animalToMove);
        toHabitat.addInhabitant(animalToMove);
    }

    public static boolean possibleProblem(Habitat<?> habitat) {
        for (int i = 0; i < 5; i++) {
            Animal animal = habitat.catchInhabintant();
            if (animal.isSick()) {
                return true;
            }
        }
        return false;
    }
}
