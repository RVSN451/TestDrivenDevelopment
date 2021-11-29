package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.math.MathContext;

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
        return new BigDecimal(1);

    }

    public BigDecimal totalAmountReturnedToBank() {
        return new BigDecimal(1);
    }

    public BigDecimal overpaymentCalculationEntirePeriod() {
        return new BigDecimal(1);
    }
}
