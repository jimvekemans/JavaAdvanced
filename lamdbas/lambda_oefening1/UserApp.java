package lambda_oefening1;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UserApp {

    public static void main(String[] args) {
        User firstUser = new User("Ben", "Admin");

        DisplayOnly displayOnly = user -> {
            System.out.println(String.format("%s %s", user.getName(), user.getRole()));
        };

        displayOnly.print(firstUser);

        //------------------------------------------------------------------------------
        User secondUser = new User("Ben", "Admin");

        Predicate<User> adminUserPredicate = user -> {
            return user.getRole().equalsIgnoreCase("admin");
        };

        System.out.println(adminUserPredicate.test(secondUser));
        //------------------------------------------------------------------------------
        User thirdUser = new User("Ben", "Admin");

        Predicate<User> memberUserStartsWithBPredicate = user -> {
            return user.getRole().equalsIgnoreCase("member") && user.getName().startsWith("B");
        };

        System.out.println(memberUserStartsWithBPredicate.test(thirdUser));
        //------------------------------------------------------------------------------
        User fourthUser = new User("Benny", "CSGO addict");

        Function<User, String> userGeneratePassword = user -> {
            String firstTwoLetters = user.getName().substring(0, 2);
            int numbers = (new Random()).nextInt(9999);
            return String.format("%s%04d", firstTwoLetters, numbers);
        };

        System.out.println(userGeneratePassword.apply(fourthUser));
        //------------------------------------------------------------------------------
        User fifthUser = new User("Billy", "420 blazer");

        Consumer<User> userConsumer = user -> {
            StringBuilder tempBuilder = new StringBuilder(user.getName());
            System.out.println(tempBuilder.reverse());
        };

        userConsumer.accept(fifthUser);
    }

}
