package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        boolean isUpper = true;
        boolean isLower = true;
        boolean isDigit = true;
        boolean isSpecial = true;

        if (password == null) {
            throw new IllegalArgumentException("Password can't be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Password should be length [8, 32]");
        }

        char[] letters = password.toCharArray();
        for (char letter : letters) {
            if (Character.isUpperCase(letter)) {
                isUpper = false;
            }
            if (Character.isLowerCase(letter)) {
                isLower = false;
            }
            if (Character.isDigit(letter)) {
                isDigit = false;
            }
            if (!Character.isLetterOrDigit(letter)) {
                isSpecial = false;
            }
        }

        if (isUpper) {
            throw new IllegalArgumentException("Password should contain at least one uppercase letter");
        }

        if (isLower) {
            throw new IllegalArgumentException("Password should contain at least one lowercase letter");
        }

        if (isDigit) {
            throw new IllegalArgumentException("Password should contain at least one figure");
        }

        if (isSpecial) {
            throw new IllegalArgumentException("Password should contain at least one special symbol");
        }

        String[] contain = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (String word : contain) {
            if (password.toLowerCase().contains(word.toLowerCase())) {
                throw new IllegalArgumentException("Password shouldn't contain substrings: qwerty, 12345, password, admin, user");
            }
        }
        return password;
    }
}
