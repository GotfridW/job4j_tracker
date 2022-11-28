package ru.job4j.early;

import java.util.function.IntPredicate;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }
        if (notContains(password, Character::isUpperCase)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one uppercase letter");
        }
        if (notContains(password, Character::isLowerCase)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one lowercase letter");
        }
        if (notContains(password, Character::isDigit)) {
            throw new IllegalArgumentException(
                    "Password should contain at least one figure");
        }
        if (notContains(password, (c -> !Character.isLetterOrDigit(c)))) {
            throw new IllegalArgumentException(
                    "Password should contain at least one special symbol"
            );
        }
        if (password.contains("12345")
                || containsIgnoreCase(password, "qwerty")
                || containsIgnoreCase(password, "password")
                || containsIgnoreCase(password, "admin")
                || containsIgnoreCase(password, "user")) {
            throw new IllegalArgumentException(
                    "Password shouldn't contain substrings: qwerty, 12345, password, admin, user"
            );
        }
        return password;
    }

    private static boolean notContains(String str, IntPredicate predicate) {
        return str.chars().noneMatch(predicate);
    }

    private static boolean containsIgnoreCase(String str, String other) {
        boolean rsl = false;
        int length = other.length();
        for (int i = 0; i < str.length() - length; i++) {
            if (str.regionMatches(true, i, other, 0, length)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }
}
