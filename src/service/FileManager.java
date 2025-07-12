package src.service;

import src.model.Product;
import java.io.*;
import java.util.*;

public class FileManager {
    private static final String FILE_NAME = "inventory.txt";

    // Method to save the inventory to a file
    public static void saveinventory(Map<Integer, Product> inventory){
        try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
            for (Product p : inventory.values()){
                writer.println(p.getId() + "," + p.getName() + "," + p.getQuantity() + "," + p.getLocation());

            }
        }catch(IOException e){
                System.out.println("Error saving inventory: " + e.getMessage());
            }
        }

        // Method to load the inventory from a file
        public static Map<Integer, Product> loadInventory(){
            Map<Integer, Product> inventory =new HashMap<>();

            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 4) {
                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        int quantity = Integer.parseInt(parts[2]);
                        String location = parts[3];
                        Product product = new Product(id, name, quantity, location);
                        inventory.put(id, product);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error loading inventory: " + e.getMessage());
            }
            return inventory;
    }
}
