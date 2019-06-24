package generics_oef_1;

public class TestWorkingPlaces {
    public static void main(String[] args) {

        //------------------------------------------------------
        //          CHECKS VOOR WORKPLACE IN OPGAVE A
        //------------------------------------------------------

        // Classes die Motorized niet overerven
        //generics_oef_1.opgave_a.WorkingPlace<Bike> bikeWorkingPlaceA = new generics_oef_1.opgave_a.WorkingPlace<>();
        //generics_oef_1.opgave_a.WorkingPlace<Vehicle> vehicleWorkingPlaceA = new generics_oef_1.opgave_a.WorkingPlace<>();

        // Classes die Motorized overerven
        generics_oef_1.opgave_a.WorkingPlace<Car> carWorkingPlaceA = new generics_oef_1.opgave_a.WorkingPlace<>();
        generics_oef_1.opgave_a.WorkingPlace<CircularSaw> otherWorkPlaceA = new generics_oef_1.opgave_a.WorkingPlace<>();
        generics_oef_1.opgave_a.WorkingPlace<Motorized> motorizedWorkingPlaceA = new generics_oef_1.opgave_a.WorkingPlace<>();

        //------------------------------------------------------
        //          CHECKS VOOR WORKPLACE IN OPGAVE B
        //------------------------------------------------------

        // Classes die Vehicle niet overerven
        //generics_oef_1.opgave_b.WorkingPlace<CircularSaw> otherWorkPlaceB = new generics_oef_1.opgave_b.WorkingPlace<>();
        //generics_oef_1.opgave_b.WorkingPlace<Motorized> motorizedWorkingPlaceB = new generics_oef_1.opgave_b.WorkingPlace<>();

        // Classes die Vehicle overerven
        generics_oef_1.opgave_b.WorkingPlace<Car> carWorkingPlaceB = new generics_oef_1.opgave_b.WorkingPlace<>();
        generics_oef_1.opgave_b.WorkingPlace<Bike> bikeWorkingPlaceB = new generics_oef_1.opgave_b.WorkingPlace<>();
        generics_oef_1.opgave_b.WorkingPlace<Vehicle> vehicleWorkingPlaceB = new generics_oef_1.opgave_b.WorkingPlace<>();

        //------------------------------------------------------
        //          CHECKS VOOR WORKPLACE IN OPGAVE C
        //------------------------------------------------------

        // Classes die Vehicle niet overerven
        //generics_oef_1.opgave_c.WorkingPlace<CircularSaw> otherWorkPlaceC = new generics_oef_1.opgave_c.WorkingPlace<>();
        //generics_oef_1.opgave_c.WorkingPlace<Motorized> motorizedWorkingPlaceC = new generics_oef_1.opgave_c.WorkingPlace<>();

        // Classes die Motorized niet overerven
        //generics_oef_1.opgave_c.WorkingPlace<Bike> bikeWorkingPlaceC = new generics_oef_1.opgave_c.WorkingPlace<>();
        //generics_oef_1.opgave_c.WorkingPlace<Vehicle> vehicleWorkingPlaceC = new generics_oef_1.opgave_c.WorkingPlace<>();

        // Classes die zowel Vehicle en Motorized overerven
        generics_oef_1.opgave_c.WorkingPlace<Car> carWorkingPlaceC = new generics_oef_1.opgave_c.WorkingPlace<>();

        //----------------------------------------------------------------------------------------------------------------------

        WorkingPlace<Car> carWorkingPlace = new WorkingPlace<>();
        WorkingPlace<Bike> bikeWorkingPlace = new WorkingPlace<>();
        WorkingPlace<Vehicle> vehicleWorkingPlace = new WorkingPlace<>();
        WorkingPlace<CircularSaw> otherWorkPlace = new WorkingPlace<>();
        WorkingPlace<Motorized> motorizedWorkingPlace = new WorkingPlace<>();

        //------------------------------------------------------
        //          CHECKS VOOR WORKPLACEUTILITY IN OPGAVE D
        //------------------------------------------------------

        generics_oef_1.opgave_d.WorkingPlaceUtility.getScore(bikeWorkingPlace);
        //generics_oef_1.opgave_d.WorkingPlaceUtility.getScore(carWorkingPlace);
        //generics_oef_1.opgave_d.WorkingPlaceUtility.getScore(vehicleWorkingPlace);
        //generics_oef_1.opgave_d.WorkingPlaceUtility.getScore(otherWorkPlace);
        //generics_oef_1.opgave_d.WorkingPlaceUtility.getScore(motorizedWorkingPlace);

        //------------------------------------------------------
        //          CHECKS VOOR WORKPLACEUTILITY IN OPGAVE E
        //------------------------------------------------------

        generics_oef_1.opgave_e.WorkingPlaceUtility.getScore(bikeWorkingPlace);
        generics_oef_1.opgave_e.WorkingPlaceUtility.getScore(carWorkingPlace);
        generics_oef_1.opgave_e.WorkingPlaceUtility.getScore(vehicleWorkingPlace);
        //generics_oef_1.opgave_e.WorkingPlaceUtility.getScore(otherWorkPlace);
        //generics_oef_1.opgave_e.WorkingPlaceUtility.getScore(motorizedWorkingPlace);

        //------------------------------------------------------
        //          CHECKS VOOR WORKPLACEUTILITY IN OPGAVE F
        //------------------------------------------------------

        //generics_oef_1.opgave_f.WorkingPlaceUtility.getScore(bikeWorkingPlace);
        generics_oef_1.opgave_f.WorkingPlaceUtility.getScore(carWorkingPlace);
        //generics_oef_1.opgave_f.WorkingPlaceUtility.getScore(vehicleWorkingPlace);
        generics_oef_1.opgave_f.WorkingPlaceUtility.getScore(otherWorkPlace);
        generics_oef_1.opgave_f.WorkingPlaceUtility.getScore(motorizedWorkingPlace);

        //------------------------------------------------------
        //          CHECKS VOOR WORKPLACEUTILITY IN OPGAVE G
        //------------------------------------------------------

        //generics_oef_1.opgave_g.WorkingPlaceUtility.getScore(bikeWorkingPlace);
        generics_oef_1.opgave_g.WorkingPlaceUtility.getScore(carWorkingPlace);
        //generics_oef_1.opgave_g.WorkingPlaceUtility.getScore(vehicleWorkingPlace);
        //generics_oef_1.opgave_g.WorkingPlaceUtility.getScore(otherWorkPlace);
        //generics_oef_1.opgave_g.WorkingPlaceUtility.getScore(motorizedWorkingPlace);
    }
}
