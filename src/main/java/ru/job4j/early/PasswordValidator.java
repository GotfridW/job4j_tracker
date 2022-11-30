package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        boolean upperCount = false, lowerCount = false, digitCount = false, specialCount = false;
        for (char c : password.toCharArray()) {
            if (!upperCount && Character.isUpperCase(c)) {
                upperCount = true;
            }
            if (!lowerCount && Character.isLowerCase(c)) {
                lowerCount = true;
            }
            if (!digitCount && Character.isDigit(c)) {
                digitCount = true;
            }
            if (!specialCount && !Character.isLetterOrDigit(c)) {
                specialCount = true;
            }
        }
        if (!upperCount) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter");
        }
        if (!lowerCount) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter");
        }
        if (!digitCount) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure");
        }
        if (!specialCount) {
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