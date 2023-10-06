package com.pluralsight;

import java.util.Scanner;

public class SandwichShop {

    private static final double REGULAR_PRICE = 5.45;
    private static final double LARGE_PRICE = 8.95;
    private static final double STUDENT_RATE = 0.9;
    private static final double SENIOR_RATE = 0.8;
    private static final double REGULAR_LOADED = 1.00;
    private static final double LARGE_LOADED = 1.75;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the size of the sandwich (Regular or Large): ");
        String size = scan.nextLine().toUpperCase();

        System.out.print("Enter your age: ");
        int age = scan.nextInt();

        scan.nextLine();
        System.out.print("Will the sandwich be loaded? ");
        String loaded = scan.nextLine().toUpperCase();

        double price = calculatePrice(size, age, loaded);

        System.out.printf("The cost of the sandwich is: $%.2f", price);
    }

    private static double calculatePrice(String size, int age, String loaded) {
        double price = 0.0;

        if (size.equals("LARGE")) {
            price = LARGE_PRICE;
            if (loaded.equals("YES")) {
                price += LARGE_LOADED;
            }
        } else if (size.equals("REGULAR")) {
            price = REGULAR_PRICE;
            if (loaded.equals("YES")) {
                price += REGULAR_LOADED;
            }
        } else {
            System.out.println("Invalid size");
            return -1.0;
        }

        if (age <= 17) {
            price *= STUDENT_RATE;
        } else if (age >= 65) {
            price *= SENIOR_RATE;
        }

        return price;
    }
}
