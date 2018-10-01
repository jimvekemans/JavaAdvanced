package opdracht1;

import java.util.ArrayList;

public class GearBox {
    private final int MAXGEARS;
    boolean clutchIsIn;
    ArrayList<Gear> gearsList;

    public GearBox(int gears) {
        MAXGEARS = gears;
        gearsList = new ArrayList<>();
        for (int i = 0; i <= gears && i <= MAXGEARS; i++) {
            gearsList.add(new Gear(i));
        }
    }

    void operateClutch(boolean in) {
        clutchIsIn = in;
    }

    void addGear(Gear gear) {
        gearsList.add(gear);
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
