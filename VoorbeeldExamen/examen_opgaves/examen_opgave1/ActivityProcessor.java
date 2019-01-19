package examen_opgave1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class ActivityProcessor {

    private CustomerRepository customerRepository;

    public ActivityProcessor(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Activity> processActivities(Path activityFile, Path errorFile) {
        Map<String, Activity> activities;

        try (BufferedReader reader = Files.newBufferedReader(activityFile);
             BufferedWriter errorFileWriter = Files.newBufferedWriter(errorFile)) {
            try {
                if (activityFile.toString().contains("strava")) {
                    activities = reader.lines()
                            .collect(Collectors.toMap(
                                    string -> string,
                                    this::stravaStringToActivity
                            ));
                } else if (activityFile.toString().contains("endomondo")) {
                    activities = reader.lines()
                            .collect(Collectors.toMap(
                                    string -> string,
                                    this::endoMondoStringToActivity
                            ));
                } else {
                    throw new IOException("INVALID FILENAME");
                }
                //filter out the activities with invalid customernumbers
                activities.keySet().stream()
                        .filter(activityString -> customerRepository.getByCustomerNumber(activities.get(activityString).getCustomerNumber()) == null)
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
            ioe.getMessage();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
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
