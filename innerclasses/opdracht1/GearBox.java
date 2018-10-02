package opdracht1;

import java.util.ArrayList;

public class GearBox {
    public final int MAXGEARS;
    boolean clutchIsIn;
    int currentGear;
    ArrayList<Gear> gearsList;

    public GearBox(int maxAmountOfGears) {
        MAXGEARS = maxAmountOfGears;
        gearsList = new ArrayList<>();
        for (int i = 1; i <= maxAmountOfGears; i++) {
            Gear localGear = new Gear(i);
            localGear.ratio = localGear.gearNumber * 5.3;
            addGear(localGear);
        }
    }

    void operateClutch(boolean in) {
        clutchIsIn = in;
    }

    void addGear(Gear gear) {
        gearsList.add(gear);
    }

    void changeGear(int newGear) {
        if (newGear <= MAXGEARS && clutchIsIn) {
            currentGear = newGear;
            System.out.println("Gear " + newGear + " selected.");
        } else {
            System.out.println("U R BrEakInG sHId");
            currentGear = 0;
        }
    }

    double wheelSpeed(int revs) {
        if (!clutchIsIn) {
            System.out.println("U R BrEakInG sHId");
            return 0;
        } else {
            return gearsList.get(currentGear).driveSpeed(revs);
        }
    }

    private class Gear {
        int gearNumber;
        double ratio;

        Gear(int gearNumber) {
            this.gearNumber = gearNumber;
        }

        double driveSpeed(int revs) {
            return ratio * revs;
        }
    }
}
