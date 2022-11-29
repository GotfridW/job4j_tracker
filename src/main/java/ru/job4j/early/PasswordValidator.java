package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (!containsUpperCase(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter");
        }
        if (!containsLowerCase(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter");
        }
        if (!containsDigit(password)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure");
        }
        if (!containsSpecialCharacter(password)) {
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

    private static boolean containsUpperCase(String str) {
        boolean rsl = false;
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean containsLowerCase(String str) {
        boolean rsl = false;
        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean containsDigit(String str) {
        boolean rsl = false;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    private static boolean containsSpecialCharacter(String str) {
        boolean rsl = false;
        for (char c : str.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}