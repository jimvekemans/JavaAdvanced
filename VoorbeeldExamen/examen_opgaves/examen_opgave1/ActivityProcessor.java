package examen_opgave1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ActivityProcessor {

    private CustomerRepository customerRepository;

    public ActivityProcessor(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Activity> processActivities(Path activityFile, Path errorFile) {
        List<Activity> activities;

        try (BufferedReader reader = Files.newBufferedReader(activityFile);
             BufferedWriter errorFileWriter = Files.newBufferedWriter(errorFile)) {
            try {
                if (activityFile.toString().contains("strava")) {
                    activities = reader.lines()
                            .map(this::stravaStringToActivity)
                            .collect(Collectors.toList());
                } else if (activityFile.toString().contains("endomondo")) {
                    activities = reader.lines()
                            .map(this::endoMondoStringToActivity)
                            .collect(Collectors.toList());
                } else {
                    throw new IOException("INVALID FILENAME");
                }
                activities.forEach(this::assignPointsToCustomer);
            } catch (NullPointerException npe) {
                errorFileWriter.write(
                        LocalTime.now().toString() + " - " + activityFile + " - " +
                );
            }
        } catch (IOException ioe) {
            ioe.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    private void assignPointsToCustomer(Activity activity) {
        //CustomerRepository.getByCustomerNumber() kan een nullpointerexception gooien dus opvangen in errorFile
        customerRepository
                .getByCustomerNumber(activity.getCustomerNumber())
                .setPoints((int) (activity.getActivityType().getPointsPerKm() * activity.getDistance()));
    }

    private Activity endoMondoStringToActivity(String activityString) {
        String[] activityParts = activityString.split(";");
        Activity activity = new Activity();
        activity.setActivityDate(LocalDate.parse(activityParts[0], DateTimeFormatter.ofPattern("yyyyMMdd", Locale.ENGLISH)));
        activity.setCustomerNumber(activityParts[1]);
        activity.setActivityType(ActivityType.valueOf(activityParts[2].toUpperCase()));
        activity.setDistance(Double.parseDouble(activityParts[3]));
        return activity;
    }

    private Activity stravaStringToActivity(String activityString) {
        String[] activityParts = activityString.split(";");
        Activity activity = new Activity();
        activity.setCustomerNumber(activityParts[0].split(" ")[2]);
        activity.setActivityDate(LocalDate.parse(activityParts[1], DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH)));
        activity.setActivityType(ActivityType.valueOf(activityParts[2].toUpperCase()));
        activity.setDistance(Double.parseDouble(activityParts[3]));
        return activity;
    }
}
