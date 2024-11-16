package application;

import entities.Venda;
import services.PaymentCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Venda> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" + (i + 1));
            System.out.print("Enter product name: ");
            String name = sc.next();
            System.out.print("Enter product price: ");
            double price = sc.nextDouble();
            System.out.print("Enter product quantity: ");
            int quantity = sc.nextInt();

            Venda p = new Venda(name, price, quantity);
            products.add(p);
        }

        Double totalBuy = 0.0;

        for (Venda p : products) {
            totalBuy += p.totalPrice();
        }

        System.out.println("Enter payment method" +
                "\n C - Credit" +
                "\n D - Debit" +
                "\n M - Money");

        PaymentCalculator pc = new PaymentCalculator();
        pc.Calculator(totalBuy, pc);

        for (Venda p : products) {
            System.out.println(p);
        }
        System.out.println("Total value: " + totalBuy);
        System.out.println("Total Payment: " + pc.getTotalPayment());
        sc.close();
    }
}