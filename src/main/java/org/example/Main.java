package org.example;

import java.util.Scanner;

import static org.example.Constants.MENU;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);

        //noinspection InfiniteLoopStatement
        while (true) {
            System.out.println(MENU);
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> Util.createAndWrite(scanner);
                case 2 -> Util.read(scanner);
                case 3 -> Util.exit();
                default -> System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
