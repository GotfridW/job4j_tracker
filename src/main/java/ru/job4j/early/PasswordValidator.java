package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean upperCase = false, lowerCase = false, digit = false, specialChar = false;
        for (char c : password.toCharArray()) {
            if (!upperCase && Character.isUpperCase(c)) {
                upperCase = true;
            }
            if (!lowerCase && Character.isLowerCase(c)) {
                lowerCase = true;
            }
            if (!digit && Character.isDigit(c)) {
                digit = true;
            }
            if (!specialChar && !Character.isLetterOrDigit(c)) {
                specialChar = true;
            }
            if (upperCase && lowerCase && digit && specialChar) {
                break;
            }
        }
        if (!upperCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter");
        }
        if (!lowerCase) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter");
        }
        if (!digit) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure");
        }
        if (!specialChar) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        String[] keyWords = new String[] {
                "12345", "qwerty", "password", "user", "admin"
        };
        for (String word : keyWords) {
            if (password.toLowerCase().contains(word)) {
                throw new IllegalArgumentException(
                        "Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}