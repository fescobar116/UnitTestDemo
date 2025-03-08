package edu.unac;

public class PasswordStrengthUtil {
    public enum PasswordStrength {
        WEAK, MEDIUM, STRONG
    }

    public static PasswordStrength getPasswordStrength(String password){
        if (password.length() < 8
                || password.matches("[0-9]+")
                || password.matches("[a-z]+")){
            return PasswordStrength.WEAK;
        }

        if (password.matches("[0-9a-z]+"))
            return PasswordStrength.MEDIUM;

        return PasswordStrength.STRONG;
    }
}
