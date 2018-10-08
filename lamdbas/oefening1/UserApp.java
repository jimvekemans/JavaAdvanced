package oefening1;

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
    }

}
