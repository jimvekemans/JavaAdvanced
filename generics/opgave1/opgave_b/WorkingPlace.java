package opgave1.opgave_b;

import opgave1.Vehicle;

public class WorkingPlace<T extends Vehicle> {
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

/*
Pas de generieke klasse WorkingPlace aan zodat je WorkingPlace-objecten kan maken om
Vehicle-objecten te herstellen (dus wel WorkingPlace<Car> en WorkingPlace<Vehicle>)
 */