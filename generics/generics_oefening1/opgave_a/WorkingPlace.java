package generics_oefening1.opgave_a;

import generics_oefening1.Motorized;

public class WorkingPlace<T extends Motorized> {
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
Motorized objecten te herstellen (dus wel WorkingPlace<Motorized>, WorkingPlace<Car>,
WorkingPlace<CircularSaw> maar niet WorkingPlace<Bike> of WorkingPlace<Vehicle>)
 */