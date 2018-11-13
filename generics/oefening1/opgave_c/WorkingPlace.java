package oefening1.opgave_c;

import oefening1.Motorized;
import oefening1.Vehicle;

public class WorkingPlace<T extends Vehicle & Motorized> {
    private T thingToFix;
    private int numberOfThingsFixed = 0;

    public boolean isEmpty() {
        return thingToFix == null;
    }

    public void startFixing(T vehicle) {
        if (!isEmpty()) {
            System.out.println("Already busy.");
        } else {
            this.thingToFix = vehicle;
        }
    }

    public void finished() {
        thingToFix = null;
        numberOfThingsFixed++;
    }

    public int getNumberOfThingsFixed() {
        return numberOfThingsFixed;
    }

}
