package demo3;

import demo2.Fish;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aquarium implements Habitat<Fish> {
    private static final Random RANDOM = new Random();
    private List<Fish> fishes = new ArrayList<>();

    @Override
    public void addInhabitant(Fish inhabitant) {
        fishes.add(inhabitant);
    }

    @Override
    public void removeInhabitant(Fish inhabitant) {
        fishes.remove(inhabitant);
    }

    @Override
    public Fish catchInhabintant() {
        return fishes.get(RANDOM.nextInt(getNumberOfInhabitants()));
    }

    @Override
    public int getNumberOfInhabitants() {
        return fishes.size();
    }
}
