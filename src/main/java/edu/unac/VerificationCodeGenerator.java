package edu.unac;

import edu.unac.exception.InvalidVerificationCodeException;

public class VerificationCodeGenerator {
    private final RandomNumberGenerator randomNumberGenerator;
    private String currentCode;
    private int attempts;

    public VerificationCodeGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.currentCode = "";
        this.attempts = 0;
    }

    public String generateCode() {
        StringBuilder code = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            code.append(randomNumberGenerator.generate());
        }

        String newCode = code.toString();

        if (hasTreeConsecutiveDigits(newCode))
            throw new InvalidVerificationCodeException("Tree consecutive digits not allowed");

        attempts = 0;
        currentCode = newCode;
        return newCode;
    }

    public boolean validateCode(String code) {
        if (attempts >= 5)
            return false;

        attempts++;

        return currentCode.equals(code);
    }

    private boolean hasTreeConsecutiveDigits(String code) {
        for (int i = 0; i < code.length() - 2 ; i++) {
            int firstDigit = Character.getNumericValue(code.charAt(i));
            int secondDigit = Character.getNumericValue(code.charAt(i+1));
            int thirdDigit = Character.getNumericValue(code.charAt(i+2));

            if (firstDigit + 1 == secondDigit && firstDigit + 2 == thirdDigit)
                return true;
        }
        return false;
    }
}
