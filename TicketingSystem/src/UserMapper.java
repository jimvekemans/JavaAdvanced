import java.time.LocalDate;

public class UserMapper implements Mapper<User> {
    @Override
    public User map(String[] inputFields) {
        int dayOfMonth = Integer.parseInt(inputFields[3].substring(0, 2));
        int month = Integer.parseInt(inputFields[3].substring(2, 4));
        int year = Integer.parseInt(inputFields[3].substring(4));
        LocalDate localDate = LocalDate.of(year, month, dayOfMonth);
        User localUser = new User(inputFields[1], inputFields[2], localDate);
        localUser.setId(inputFields[0]);
        return localUser;
    }
}
