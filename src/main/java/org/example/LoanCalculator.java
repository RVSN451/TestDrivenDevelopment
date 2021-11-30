package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Data
@AllArgsConstructor
public class LoanCalculator {
    protected static final BigDecimal monthsInYear = new BigDecimal(12);
    protected static final MathContext bigDecimalContext = new MathContext(5);

    @NonNull
    private BigDecimal creditAmount;
    @NonNull
    private Integer creditTermMonth;
    @NonNull
    private BigDecimal annualInterestRate;

    public BigDecimal monthlyPayment() {

        return creditAmount.multiply(
                monthlyInterestRate().divide(
                        new BigDecimal(1).subtract(
                                negativeDegree(new BigDecimal(1).add(monthlyInterestRate()),
                                        creditTermMonth)
                        ), bigDecimalContext
                )
        );

    }

    public BigDecimal totalAmountReturnedToBank() {
        return monthlyPayment().multiply(BigDecimal.valueOf(creditTermMonth));
    }

    public BigDecimal overpaymentCalculationEntirePeriod() {
        return totalAmountReturnedToBank().subtract(creditAmount);

    }

    private BigDecimal monthlyInterestRate() {
        return annualInterestRate.divide((monthsInYear.multiply(new BigDecimal(100))),
                5, RoundingMode.CEILING);
    }

    private BigDecimal negativeDegree(BigDecimal a, int degree) {

        return new BigDecimal(1).divide(a.pow(degree), bigDecimalContext);

    }
}
