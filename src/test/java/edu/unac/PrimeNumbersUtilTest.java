package edu.unac;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class PrimeNumbersUtilTest {
    @Test
    void getPrimeNumbersInRange() {
        List<Integer> primeNumbersInRangeList =
                PrimeNumbersUtil.getPrimeNumbersInRange(10,30);
        List<Integer> expResult = List.of(11,13,17,19,23,29);

        Assertions.assertEquals(expResult, primeNumbersInRangeList);
    }

    @Test
    void getPrimeNumbersInRangeLimit() {
        List<Integer> primeNumbersInRangeList =
                PrimeNumbersUtil.getPrimeNumbersInRange(11,29);
        List<Integer> expResult = List.of(11,13,17,19,23,29);

        Assertions.assertEquals(expResult, primeNumbersInRangeList);
    }

    @Test
    void getPrimeNumbersInRangeNoNumbers() {
        List<Integer> primeNumbersInRangeList =
                PrimeNumbersUtil.getPrimeNumbersInRange(90,96);
        List<Integer> expResult = Collections.emptyList();

        Assertions.assertEquals(expResult, primeNumbersInRangeList);
    }

    @Test
    void getPrimeNumbersIllegalArgumentException(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> PrimeNumbersUtil.getPrimeNumbersInRange(60,10)
        );
    }
}