import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RapportService {
    private final static Path standardOutputPath = Paths.get(".\\resources\\calllog_files\\output");
    private final static String standardFilePrefix = "[CallLogs - Rapport] ";

    //This method was written to prevent writing duplicate code for the 'createRapport...' methods
    private static void writeLinesToFile(List<String> callLogString, String fileName, Path outputPath) {
        try {
            if (!Files.exists(outputPath.resolve(fileName + ".csv")))
                Files.createFile(outputPath.resolve(fileName + ".csv"));
        } catch (IOException e) {
            System.out.println("Error during file-creation: " + outputPath + fileName);
        }
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(outputPath.resolve(fileName + ".csv"), StandardOpenOption.APPEND)) {
            callLogString.forEach(logString -> {
                try {
                    bufferedWriter.write(logString);
                } catch (IOException ioe) {
                    System.out.println("IOException occurred during foreach-loop");
                }
            });
        } catch (IOException ioe) {
            System.out.println("IOException occured during creation of BufferedWriter.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createRapportSortedByPriority(List<CallLog> callLogs, Path outputPath) {
        writeLinesToFile(
                callLogs.stream()
                        .sorted(Comparator.comparing(CallLog::getLogPriority))
                        .map(CallLog::toString)
                        .collect(Collectors.toList()),
                (standardFilePrefix + "Sorted by priority"),
                outputPath
        );
    }

    public static void createRapportSortedByPriority(List<CallLog> callLogs) {
        createRapportSortedByPriority(
                callLogs,
                standardOutputPath
        );
    }

    public static void createRapportSortedByCallerCompany(List<CallLog> callLogs, Path outputPath) {
        writeLinesToFile(
                callLogs.stream()
                        .sorted(Comparator.comparing(CallLog::getCallerCompany))
                        .map(CallLog::toString)
                        .collect(Collectors.toList()),
                (standardFilePrefix + " Sorted by callerCompany"),
                outputPath
        );
    }

    public static void createRapportSortedByCallerCompany(List<CallLog> callLogs) {
        createRapportSortedByCallerCompany(
                callLogs,
                standardOutputPath
        );
    }

    public static void createRapportOlderThanTwoYears(List<CallLog> callLogs, Path outputPath) {
        LocalDate twoYearsAgo = LocalDate.now().minusYears(2);
        writeLinesToFile(
                callLogs.stream()
                        .filter(callLog -> callLog.getLogDate().isBefore(twoYearsAgo))
                        .map(CallLog::toString)
                        .collect(Collectors.toList()),
                (standardFilePrefix + " Over two years old"),
                outputPath
        );
    }

    public static void createRapportOlderThanTwoYears(List<CallLog> callLogs) {
        createRapportOlderThanTwoYears(
                callLogs,
                standardOutputPath
        );
    }

    public static void createRapportSortedByLogDate(List<CallLog> callLogs, Path outputPath) {
        writeLinesToFile(
                callLogs.stream()
                        .sorted(Comparator.comparing(CallLog::getLogDate))
                        .map(CallLog::toString)
                        .collect(Collectors.toList()),
                (standardFilePrefix + " Sorted by logDate"),
                outputPath
        );
    }

    public static void createRapportSortedByLogDate(List<CallLog> callLogs) {
        createRapportSortedByLogDate(
                callLogs,
                standardOutputPath
        );
    }

    public static void createRapportPerCaller(List<CallLog> callLogs, Path outputPath) {
        List<CallLog> listCopy = new ArrayList<>(callLogs);
        listCopy.stream()
                .map(CallLog::getCallerName)
                .distinct()
                .forEach(callerName -> writeLinesToFile(
                        callLogs.stream()
                                .filter(callLog -> callLog.getCallerName().equalsIgnoreCase(callerName))
                                .map(CallLog::toString)
                                .collect(Collectors.toList()),
                        (standardFilePrefix + callerName),
                        outputPath
                        )
                );
    }

    public static void createRapportPerCaller(List<CallLog> callLogs) {
        createRapportPerCaller(
                callLogs,
                standardOutputPath
        );
    }

    public static void createRapportPerStatus(List<CallLog> callLogs, Path outputPath) {
        List<CallLog> listCopy = new ArrayList<>(callLogs);
        listCopy.stream()
                .map(CallLog::getLogStatus)
                .distinct()
                .forEach(logStatus -> writeLinesToFile(
                        callLogs.stream()
                                .filter(callLog -> callLog.getLogStatus() == logStatus)
                                .map(CallLog::toString)
                                .collect(Collectors.toList()),
                        (standardFilePrefix + logStatus.getDescription()),
                        outputPath
                        )
                );
    }

    public static void createRapportPerStatus(List<CallLog> callLogs) {
        createRapportPerStatus(
                callLogs,
                standardOutputPath
        );
    }
}
