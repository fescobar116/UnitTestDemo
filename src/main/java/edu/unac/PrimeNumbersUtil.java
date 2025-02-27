package edu.unac;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersUtil {
    public static List<Integer> getPrimeNumbersInRange(int lowerLimit, int upperLimit) {
        if (lowerLimit > upperLimit)
            throw new IllegalArgumentException("lowerLimit > upperLimit");

        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = lowerLimit; i <= upperLimit; i++) {
            if (isPrime(i))
                primeNumbers.add(i);
        }
        return primeNumbers;
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
