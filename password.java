import java.util.Set;
import java.util.HashSet;

public class PasswordValidator {
    public static String isPasswordSecure(String password) {
        Set<Character> specialChars = new HashSet<>();
        String special = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        for (char c : special.toCharArray()) {
            specialChars.add(c);
        }

        boolean isDigit = false;
        boolean isChar = false;
        boolean isLower = false;
        boolean isUpper = false;

        for (char c : password.toCharArray()) {
            if (specialChars.contains(c)) {
                isChar = true;
            }
            if (Character.isDigit(c)) {
                isDigit = true;
            }
            if (Character.isUpperCase(c)) {
                isUpper = true;
            }
            if (Character.isLowerCase(c)) {
                isLower = true;
            }
        }

        if (password.length() >= 8 && isDigit && isChar && isLower && isUpper) {
            return "Password is valid";
        }
        return "Password is not valid. It must be at least 8 characters long and include a mix of uppercase, lowercase, digits, and special characters.";
    }

    public static void main(String[] args) {
        System.out.println(isPasswordSecure("Secure@123"));
        System.out.println(isPasswordSecure("weakpass"));
    }
}
