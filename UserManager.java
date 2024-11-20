package main.java.com.example.cse360;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {
    private Map<String, User> users = new HashMap<>();

    public void registerUser(User user) {
        users.put(user.getUsername(), user);
    }

    public User login(String username, char[] password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public void resetPassword(String username, char[] newPassword) {
        User user = users.get(username);
        if (user != null) {
            user.setPassword(newPassword);
        }
    }
}
