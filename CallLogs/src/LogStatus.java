public enum LogStatus {
    INPROGRESS("In progress"),
    IGNORE("Ignore"),
    CLOSED("Closed"),
    OPEN("Open");

    private String description;

    LogStatus(String description) {
        this.description = description;
    }

    String getDescription() {
        return description;
    }
}
