package demo5;

import demo1.GenericBox;
import demo2.Animal;
import demo2.Fish;
import demo2.LivingCreature;

public class Demo5 {
    public static void main(String[] args) {
        GenericBox<LivingCreature> livingCreatureBox = new GenericBox<>();
        livingCreatureBox.setItem(new LivingCreature());

        GenericBox<Animal> animalBox = new GenericBox<>();
        Animal animal = new Animal();
        animal.setSick(true);
        animalBox.setItem(animal);

        GenericBox<Fish> fishBox = new GenericBox<>();
        fishBox.setItem(new Fish());

        System.out.println(GenericBoxUtility.isSick(fishBox));
        System.out.println(GenericBoxUtility.isSick(animalBox));
        //System.out.println(GenericBoxUtility.isSick(livingCreatureBox));

        //System.out.println(GenericBoxUtility.displayBox(fishBox));
        System.out.println(GenericBoxUtility.displayBox(animalBox));
        System.out.println(GenericBoxUtility.displayBox(livingCreatureBox));
    }
}
