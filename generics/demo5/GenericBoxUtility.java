package demo5;

import demo1.GenericBox;
import demo2.Animal;
import demo2.Cat;

public class GenericBoxUtility {
    public static <T extends Animal> boolean isSick(GenericBox<T> animalBox) {
        return animalBox.getItem().isSick();
    }

    public static String displayBox(GenericBox<? super Animal> surpriseBox) {
        return surpriseBox.getItem().getClass().getSimpleName();
    }
}
