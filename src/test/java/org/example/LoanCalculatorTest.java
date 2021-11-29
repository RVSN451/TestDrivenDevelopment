package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class LoanCalculatorTest {

    private static float delta = 0.1f;

    LoanCalculator testCalculator = new LoanCalculator(
            new BigDecimal(20_000),
            36,
            new BigDecimal(12)
    );

    public static float floatValueExact(BigDecimal decimal) {
        float result = decimal.floatValue();
        if (!Float.isInfinite(result)) {
            if (new BigDecimal(String.valueOf(result)).compareTo(decimal) == 0) {
                return result;
            }
        }
        throw new ArithmeticException(String.format("%s: Cannot be represented as float", decimal));
    }

    @Test
    @DisplayName("Monthly payment.")
    public void checkMonthlyPayment() {
        BigDecimal expected = new BigDecimal(664.28, testCalculator.bigDecimalContext);
        BigDecimal actual = testCalculator.monthlyPayment();

        Assertions.assertEquals(
                floatValueExact(expected),
                floatValueExact(actual),
                delta
        );
    }

    @Test
    @DisplayName("Total amount to be returned to the bank.")
    public void checkTotalAmountReturnedToBank() {
        BigDecimal expected = new BigDecimal(23914.08, testCalculator.bigDecimalContext);
        BigDecimal actual = testCalculator.totalAmountReturnedToBank();

        Assertions.assertEquals(
                floatValueExact(expected),
                floatValueExact(actual),
                delta
        );
    }

    @Test
    @DisplayName("Overpayment calculation for the entire period.")
    public void checkOverpaymentCalculationEntirePeriod() {
        BigDecimal expected = new BigDecimal(3914.08, testCalculator.bigDecimalContext);
        BigDecimal actual = testCalculator.overpaymentCalculationEntirePeriod();

        Assertions.assertEquals(
                floatValueExact(expected),
                floatValueExact(actual),
                delta
        );
    }

}