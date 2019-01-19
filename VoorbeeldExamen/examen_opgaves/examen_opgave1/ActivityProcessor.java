package examen_opgave1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ActivityProcessor {

    private CustomerRepository customerRepository;

    public ActivityProcessor(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Activity> processActivities(Path activityFile, Path errorFile) {
        Map<String, Activity> activities = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(activityFile);
             BufferedWriter errorFileWriter = Files.newBufferedWriter(errorFile)) {
            try {
                if (activityFile.toString().contains("strava")) {
                    Map<String, Activity> localActivitiesMap = new HashMap<>();
                    reader.lines().forEach(string -> localActivitiesMap.put(string, stravaStringToActivity(string)));
                    activities = localActivitiesMap;
                } else if (activityFile.toString().contains("endomondo")) {
                    Map<String, Activity> localActivitiesMap = new HashMap<>();
                    reader.lines().forEach(string -> localActivitiesMap.put(string, endoMondoStringToActivity(string)));
                    activities = localActivitiesMap;
                } else {
                    throw new IOException("INVALID FILENAME");
                }
                //filter out the activities with invalid customernumbers
                Map<String, Activity> finalActivities = activities;
                activities.keySet().stream()
                        .filter(activityString -> customerRepository.getByCustomerNumber(finalActivities.get(activityString).getCustomerNumber()) == null)
                        .forEach(activityString -> {
                            try {
                                errorFileWriter.write(String.format(
                                        "%s - %s - UNKNOWN CUSTOMER: \r\n %s",
                                        LocalTime.now().toString(),
                                        activityFile.getFileName(),
                                        activityString
                                ));
                            } catch (IOException e) {
                                System.out.println("An error occured while trying to write to the errorfile.");
                                e.printStackTrace();
                            }
                        });
                return new ArrayList<>(activities.values());
            } catch (Exception e) {
                errorFileWriter.write(LocalTime.now().toString() + " - " + activityFile + " - " + e.getMessage());
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (Exception e) {
            e.getMessage();
        }
        return new ArrayList<Activity>(activities.values());
    }

    private void assignPointsToCustomer(Activity activity) {
        //Als Customerrepository.getByCustomerNumber() geen customer vindt, krijg je null
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
