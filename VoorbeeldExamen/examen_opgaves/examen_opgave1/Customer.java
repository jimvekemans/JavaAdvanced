package examen_opgave1;

import java.time.LocalDate;

public class Customer {
    private String customerNumber;
    private String name;
    private String firstName;
    private String city;
    private LocalDate dateOfBirth;
    private int points;

    public Customer(String customerNumber, String firstName, String lastName, LocalDate dateOfBirth, String city) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.name = lastName;
        this.dateOfBirth = dateOfBirth;
        this.city = city;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPoints() {
        return points;
    }

    //methode om punten toe te wijzen is nodig dus heb deze toegevoegd
    public void setPoints(int points) {
        this.points = points;
    }
}
