import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CallLogFactory {
    //id;naam;datum;tijd;bedrijf;omschrijving;prio;status
    // 0;   1;    2;   3;      4;           5;   6;     7

    public static List<CallLog> readCallLogsFromFile(File file) {
        return readCallLogsFromFile(file.toPath());
    }

    public static List<CallLog> readCallLogsFromFile(Path filePath) {
        try {
            return Files.readAllLines(filePath)
                    .stream()
                    .map(CallLogFactory::stringToCallLog)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("File not found at: " + filePath.toString());
            System.out.println("ErrorMessage: " + e.getMessage());
        }
        return null;
    }

    public static List<CallLog> readCallLogsFromFile(String filePathString) {
        return readCallLogsFromFile(Paths.get(filePathString));
    }

    private static CallLog stringToCallLog(String callLogString) {
        try {
            String[] logParts = callLogString.split(";");

            int logId = Integer.parseInt(logParts[0]);

            String callerName = logParts[1];

            String[] logDateParts = logParts[2].split("/");
            int logYear = Integer.parseInt(logDateParts[2]);
            int logMonth = Integer.parseInt(logDateParts[1]);
            int logDayOfMonth = Integer.parseInt(logDateParts[0]);
            LocalDate logDate = LocalDate.of(logYear, logMonth, logDayOfMonth);

            String[] logTimeParts = logParts[3].split(":");
            int logHour = Integer.parseInt(logTimeParts[0]);
            int logMinute = Integer.parseInt(logTimeParts[1]);
            int logSecond = Integer.parseInt(logTimeParts[2]);
            LocalTime logTime = LocalTime.of(logHour, logMinute, logSecond);

            String callerCompany = logParts[4];

            String logDescription = logParts[5];

            int logPriority = Integer.parseInt(logParts[6]);

            LogStatus logStatus = Arrays.stream(LogStatus.values())
                    .filter(status -> status.getDescription().equalsIgnoreCase(logParts[7]))
                    .findFirst().get();

            return new CallLog(logId, callerName, logDate, logTime, callerCompany, logDescription, logPriority, logStatus);
        } catch (ArrayIndexOutOfBoundsException firstex) {
            System.out.println("ArrayOutOfBoundsException occurred: " + firstex.getLocalizedMessage());
        } catch (NumberFormatException secondex) {
            System.out.println("NumberFormatException occurred: " + secondex.getLocalizedMessage());
        } catch (IllegalArgumentException thirdex) {
            System.out.println("IllegalArgumentException occured: " + thirdex.getLocalizedMessage());
        } catch (Exception finalex) {
            System.out.println("Unknown exception occurred!");
            finalex.printStackTrace();
        }
        return null;
    }
}
