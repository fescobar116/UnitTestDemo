package edu.unac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> primeNumbersInRangeList =
                PrimeNumbersUtil.getPrimeNumbersInRange(10,30);
        List<Integer> expResult = List.of(11,13,17,19,23,29);
        if (!Objects.equals(primeNumbersInRangeList,
                expResult))
            throw new RuntimeException("Expected " + expResult + " but got " + primeNumbersInRangeList);

        primeNumbersInRangeList =
                PrimeNumbersUtil.getPrimeNumbersInRange(11,29);
        expResult = List.of(11,13,17,19,23,29);
        if (!Objects.equals(primeNumbersInRangeList,
                expResult))
            throw new RuntimeException("Expected " + expResult + " but got " + primeNumbersInRangeList);

        primeNumbersInRangeList =
                PrimeNumbersUtil.getPrimeNumbersInRange(90,96);
        expResult = Collections.emptyList();
        if (!Objects.equals(primeNumbersInRangeList,
                expResult))
            throw new RuntimeException("Expected " + expResult + " but got " + primeNumbersInRangeList);
    }
}