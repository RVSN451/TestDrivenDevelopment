package org.example;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        LoanCalculator calculator = new LoanCalculator(
                new BigDecimal(2_000_000),
                36,
                new BigDecimal(12)
        );

        System.out.println("Ежемесячный платёж - " + calculator.monthlyPayment() +
                "\nОбщая сумма к возврату в банк - " + calculator.totalAmountReturnedToBank() +
                "\nПереплата за весь период - " + calculator.overpaymentCalculationEntirePeriod());
    }
}