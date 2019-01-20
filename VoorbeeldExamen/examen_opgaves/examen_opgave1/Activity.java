package examen_opgave1;

import java.time.LocalDate;

public class Activity {
    private String customerNumber;
    private ActivityType activityType;
    private double distance;
    private LocalDate activityDate;
    private ActivityTracker tracker;

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public LocalDate getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(LocalDate activityDate) {
        this.activityDate = activityDate;
    }

    public ActivityTracker getTracker() {
        return tracker;
    }

    public void setTracker(ActivityTracker tracker) {
        this.tracker = tracker;
    }

    @Override
    public String toString() {
        return String.format("Type: %s | Tracker: %s | Date: %s | Customernumber:%s | Distance: %d",
                activityType.toString(),
                tracker.toString(),
                activityDate.toString(),
                customerNumber,
                distance);
    }
}
