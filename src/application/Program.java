package application;

import entities.Product;
import entities.Venda;

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

        int totalBuy = 0;

        for (Venda p : products) {
            System.out.println(p);
            totalBuy += p.totalPrice();
        }

        System.out.println("Total buy: " + totalBuy);

    }
}