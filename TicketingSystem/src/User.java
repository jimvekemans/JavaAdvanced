import java.time.LocalDate;

public class User {
    private static int count = 0;

    private String lastname;
    private String firstname;
    private LocalDate birthday;
    private String id;

    {
        count++;
    }

    public User(String lastname, String firstname, LocalDate birthday) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.birthday = birthday;
        this.id = generateId();
    }

    private String generateId() {
        StringBuilder builder = new StringBuilder("U-");
        builder.append(String.format("%6d", count));
        return builder.toString();
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
