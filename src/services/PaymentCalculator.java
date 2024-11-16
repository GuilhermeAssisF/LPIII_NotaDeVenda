package services;

import java.util.Scanner;

public class PaymentCalculator implements Payment{

    Scanner sc = new Scanner(System.in);

    private static final double CREDIT_PERCENTAGE = 0.05;
    private static final double MONEY_PERCENTAGE = -0.05;

    @Override
    public Double credit(Double amount) {
        return amount += (amount * CREDIT_PERCENTAGE);
    }

    @Override
    public Double money(Double amount) {
        return amount += (amount * MONEY_PERCENTAGE);
    }

    private Double totalPayment = 0.0;
    public void Calculator(Double totalBuy, PaymentCalculator paymentCalculator) {
        char typePayment = sc.next().charAt(0);
        try {
            if (typePayment == 'C' || typePayment == 'c') {
                totalPayment = paymentCalculator.credit(Double.valueOf(totalBuy));
            } else if (typePayment == 'M' || typePayment == 'm') {
                totalPayment = paymentCalculator.money(Double.valueOf(totalBuy));
            } else if (typePayment == 'D' || typePayment == 'd') {
                totalPayment = Double.valueOf(totalBuy);
            }
            else{
                System.out.print("Invalid payment type. Enter your payment method again: ");
                Calculator(totalBuy, paymentCalculator);
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

        public Double getTotalPayment() {
        return totalPayment;
    }
}
