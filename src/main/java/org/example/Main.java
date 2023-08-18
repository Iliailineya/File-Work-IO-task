package org.example;

import java.io.IOException;
import java.util.Scanner;

import static org.example.Constants.FILES_DIRECTORY;
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
                case 1 -> createAndWrite(scanner);
                case 2 -> read(scanner);
                case 3 -> exit();
                default -> System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    public static void createAndWrite(Scanner scanner) {
        try {
            FileWriteService.writeToFile(getFilename(scanner), getContent(scanner));
            System.out.println("File created and written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while creating/writing the file: " + e.getMessage());
        }
    }

    public static void read(Scanner scanner) {
        try {
            String fileContent = FileReadService.readFromFile(getFilename(scanner));
            System.out.println("File content:\n" + fileContent);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public static String getFilename(Scanner scanner) {
        System.out.print("Enter file name (without extension): ");
        return FILES_DIRECTORY + scanner.nextLine() + ".txt";
    }

    public static String getContent(Scanner scanner) {
        System.out.print("Enter content to write: ");
        return scanner.nextLine();
    }

    public static void exit() {
        System.out.println("Exiting...");
        System.exit(0);
    }
}
