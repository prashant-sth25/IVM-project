package src.ui;

import src.model.Product;
import src.service.InventoryService;
import java.util.Scanner;

public class ConsoleMenu {
    private InventoryService inventoryService;
    private Scanner scanner;

    public ConsoleMenu(){
        inventoryService=new InventoryService();
        scanner = new Scanner(System.in);
    }

    public void start(){
        while (true){
            System.out.println("\nWAREHOUSE INVENTORY SYSTEM");
            System.out.println("1. Add Product");
            System.out.println("2. Check In Product");
            System.out.println("3. Check Out Product");
            System.out.println("4. List All Products");
            System.out.println("5.Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    checkIn();
                    break;
                case 3:
                    checkOut();
                    break;
                case 4:
                    inventoryService.listProducts();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addProduct(){
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Name: ");   
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Location: ");   
        String loc = scanner.nextLine();

        Product p = new Product (id, name, qty, loc);
        inventoryService.addProduct(p);
        System.out.println("Product added successfully.");
    }
    private void checkIn(){
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Quantity to Check In: ");
        int qty = Integer.parseInt(scanner.nextLine());

        inventoryService.checkIn(id, qty);
        System.out.println("Product checked in successfully.");
    }

    private void checkOut(){
        System.out.print("Enter Product ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Quantity to Check Out: ");
        int qty = Integer.parseInt(scanner.nextLine());

        inventoryService.checkOut(id, qty);
        System.out.println("Product checked out successfully.");
    }
}
