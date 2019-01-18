package examen_opgave1;

import java.util.ArrayList;
import java.util.List;

public class Opgave1 {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        System.out.println("*** Klanten uit Louisville:");
        // TODO: 1

        System.out.println("*** Jarige klanten: ");
        // TODO: 2

        System.out.println("*** 10 jongste klanten:");
        // TODO: 3

        ActivityProcessor activityFileProcessor = new ActivityProcessor(customerRepository);
        List<Activity> allActivities = new ArrayList<>();
        // TODO: 4


        System.out.println("*** Top 10 klanten");
        // TODO: 5

        System.out.println("** Alle activiteiten meest actieve klant (gesorteerd op datum):");
        // TODO: 6

    }
}
