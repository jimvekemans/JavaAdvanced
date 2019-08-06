public enum PropertyType {
    RESIDENTIAL("Residential"),
    CONDO("Condo"),
    MULTIFAM("Multi-Family");

    private String type;

    PropertyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
