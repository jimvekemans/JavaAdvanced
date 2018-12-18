import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;

public class CallLogMainClass {
    public static void main(String[] args) {
        LocalTime startTime = LocalTime.now();

        //Change this to read up to 100 files
        int amountOfFilesToRead = 5;

        List<CallLog> allFilesCombined = new ArrayList<>();
        for (int i = 1; i <= amountOfFilesToRead; i++) {
            Path localPath = Paths.get(".\\resources\\calllog_files\\input\\testdata" + i + ".csv");
            allFilesCombined.addAll(CallLogFactory.readCallLogsFromFile(localPath));
        }

        RapportService.createRapportSortedByPriority(allFilesCombined);
        RapportService.createRapportSortedByCallerCompany(allFilesCombined);
        RapportService.createRapportOlderThanTwoYears(allFilesCombined);
        RapportService.createRapportSortedByLogDate(allFilesCombined);
        RapportService.createRapportPerCaller(allFilesCombined);
        RapportService.createRapportPerStatus(allFilesCombined);

        LocalTime endTime = LocalTime.now();
        System.out.printf("Execution took: %ss and %sms",
                SECONDS.between(startTime, endTime),
                MILLIS.between(startTime, endTime));
    }
}
