package email.data;

import email.business.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserDB {
    private static final List<User> users = new ArrayList<>();

    private UserDB() {
    }

    public static void insert(User user) {
        users.add(user);
    }

    public static List<User> getUsers() {
        return Collections.unmodifiableList(users);
    }
}

