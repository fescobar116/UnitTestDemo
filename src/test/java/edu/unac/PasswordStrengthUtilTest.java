package edu.unac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PasswordStrengthUtilTest {
    @Test
    void validateWeakPassword() {
        PasswordStrengthUtil.PasswordStrength actual =
                PasswordStrengthUtil.getPasswordStrength("1234");

        Assertions.assertEquals(PasswordStrengthUtil.PasswordStrength.WEAK, actual);
    }

    @Test
    void validateWeakPasswordOnlyNumbers() {
        PasswordStrengthUtil.PasswordStrength actual =
                PasswordStrengthUtil.getPasswordStrength("123456789");

        Assertions.assertEquals(PasswordStrengthUtil.PasswordStrength.WEAK, actual);
    }

    @Test
    void validateWeakPasswordOnlyWords() {
        PasswordStrengthUtil.PasswordStrength actual =
                PasswordStrengthUtil.getPasswordStrength("abcdefghi");

        Assertions.assertEquals(PasswordStrengthUtil.PasswordStrength.WEAK, actual);
    }

    @Test
    void validateMediumPassword() {
        PasswordStrengthUtil.PasswordStrength actual =
                PasswordStrengthUtil.getPasswordStrength("1234abcd");

        Assertions.assertEquals(PasswordStrengthUtil.PasswordStrength.MEDIUM,
                actual);
    }

    @Test
    void validateStrongPassword() {
        PasswordStrengthUtil.PasswordStrength actual =
                PasswordStrengthUtil.getPasswordStrength("1234abcd*");

        Assertions.assertEquals(PasswordStrengthUtil.PasswordStrength.STRONG, actual);
    }
}