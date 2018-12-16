package demo4;

import demo2.Cat;
import demo2.Fish;
import demo3.Aquarium;

public class Demo4 {
    public static void main(String[] args) {
        CatShelter catShelter = new CatShelter();
        Cat felix = new Cat();
        catShelter.addInhabitant(felix);
        Aquarium bigAquarium = new Aquarium();
        Fish nemo = new Fish();
        Fish dory = new Fish();
        Fish whale = new Fish();
        bigAquarium.addInhabitant(nemo);
        bigAquarium.addInhabitant(dory);
        bigAquarium.addInhabitant(whale);
        System.out.println(bigAquarium.getNumberOfInhabitants());

        //AnimalUtility.moveAnimals(felix, catShelter, bigAquarium);

        Aquarium smallAquarium = new Aquarium();
        AnimalUtility.moveAnimals(nemo, bigAquarium, smallAquarium);
        System.out.println(smallAquarium.getNumberOfInhabitants());
        System.out.println(bigAquarium.getNumberOfInhabitants());

        nemo.setSick(true);
        System.out.println(AnimalUtility.possibleProblem(smallAquarium));
    }
}
