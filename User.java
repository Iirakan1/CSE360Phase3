package main.java.com.example.cse360;

import java.util.Arrays;

public class User {
    private String email;
    private String username;
    private char[] password; // Storing password as char array for security
    private String firstName;
    private String middleName;
    private String lastName;
    private String preferredName;

    // Constructor matching your RegisterController
    public User(String email, String username, char[] password, String firstName, String middleName, String lastName, String preferredName) {
        this.email = email;
        this.username = username;
        this.password = Arrays.copyOf(password, password.length); // Copying for security
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.preferredName = preferredName;
    }

    // Method to check if the provided password matches the stored password
    public boolean checkPassword(char[] inputPassword) {
        return Arrays.equals(password, inputPassword);
    }

    // Method to set a new password
    public void setPassword(char[] newPassword) {
        this.password = Arrays.copyOf(newPassword, newPassword.length); // Copying for security
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public char[] getPassword() {
        return Arrays.copyOf(password, password.length); // Return a copy for security
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPreferredName() {
        return preferredName;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", preferredName='" + preferredName + '\'' +
                '}';
    }
}
