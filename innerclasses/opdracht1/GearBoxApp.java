package opdracht1;

//import opdracht1.GearBox.Gear;

public class GearBoxApp {
    public static void main(String[] args) {
        /*
         *   <!-- Wanneer Gear niet private staat kan die op deze manier aangemaakt worden -->
         *   GearBox gearBox = new GearBox(2);
         *   Gear gear = gearBox.new Gear(1);
         *   gearBox.addGear(gear);
         *   gear = gearBox.new Gear(2);
         */
        GearBox gearBox = new GearBox(6);
        gearBox.operateClutch(true);
        gearBox.changeGear(1);
        gearBox.changeGear(100);
        gearBox.changeGear(3);
    }
}
