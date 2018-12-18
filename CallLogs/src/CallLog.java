import java.time.LocalDate;
import java.time.LocalTime;

public class CallLog {
    private int logId;
    private String callerName;
    private LocalDate logDate;
    private LocalTime logTime;
    private String callerCompany;
    private String logDescription;
    private int logPriority;
    private LogStatus logStatus;

    public CallLog(int logId, String callerName, LocalDate logDate, LocalTime logTime, String callerCompany, String logDescription, int logPriority, LogStatus logStatus) {
        this.logId = logId;
        this.callerName = callerName;
        this.logDate = logDate;
        this.logTime = logTime;
        this.callerCompany = callerCompany;
        this.logDescription = logDescription;
        this.logPriority = logPriority;
        this.logStatus = logStatus;
    }

    public int getLogId() {
        return logId;
    }

    public String getCallerName() {
        return callerName;
    }

    public LocalDate getLogDate() {
        return logDate;
    }

    public LocalTime getLogTime() {
        return logTime;
    }

    public String getCallerCompany() {
        return callerCompany;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public int getLogPriority() {
        return logPriority;
    }

    public LogStatus getLogStatus() {
        return logStatus;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s, %s %s, %s %s, %s %s, %s %s, %s %s, %s %s, %s %s",
                "LogID: ", logId,
                "Name: ", callerName,
                "Company: ", callerCompany,
                "Date of log: ", logDate,
                "Time of log: ", logTime,
                "Description: ", logDescription,
                "Priority: ", logPriority,
                "Status of log: ", logStatus.getDescription()
        );
    }
}
