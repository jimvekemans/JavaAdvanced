package generics_oef_1.opgave_b;

/* --------------------------------------------------------------------------------------------------------------------------------------
 * Pas de generieke klasse WorkingPlace aan zodat je WorkingPlace-objecten kan maken om Vehicle-objecten te herstellen
 * (dus wel WorkingPlace<Car, Bike of Vehicle> maar niet WorkingPlace<Motorized of CircularSaw>)
 * --------------------------------------------------------------------------------------------------------------------------------------
 * Wat wordt er gegeven:
 *  -> 'generieke klasse' dus moet in de header van de klasse worden ingesteld
 *  -> Het generiek type moet 'Vehicle' zijn
 */

import generics_oef_1.Vehicle;

// Aan de hand van wat er gegeven is weten we dat hier het type moet ingesteld worden voor de hele klasse
// Het type moet ook 'Vehicle' zijn dus <T extends Vehicle> voldoet die vereiste (check polymorphism als onduidelijk is waarom)
public class WorkingPlace<T extends Vehicle> {
    private T thingToFix;
    private int numberOfThingsFixed = 0;

    /* Het valt ook op dat hier geen contructor staat, hoe werkt dat dan?
     * Java maakt een constuctor zonder parameters aan als er zelf geen wordt aangegeven.
     * Zelf uittypen wat Java genereert zou er zoals volgt uitzien:
     *
     * public WorkingPlace(){}
     *
     * Soms wordt er geen constuctor ingesteld als
     * - er geen berekeningen moeten gebeuren tijdens aanmaken van het object
     * - alle waardes via setters worden ingesteld
     */

    public boolean isEmpty() {
        return thingToFix == null;
    }

    // T is hier gelijk aan het volledige type T (dus <T extends Vehicle>) dat bovenaan wordt ingesteld.
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