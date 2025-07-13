package src.service;
import src.model.Product;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    //Map to store product by ID
    private Map<Integer, Product> inventory;
    
    public InventoryService(){
        //load saved inventory on startup
        inventory = FileManager.loadInventory();
    }

    public void addProduct(Product product){
        inventory.put(product.getId(),product);
        FileManager.saveinventory(inventory);
    }

    // Method to check in a product by increasing its quantity
    public void checkIn(int productId, int quantity){
        Product p = inventory.get(productId);
        if (p!=null){
            p.setQuantity(p.getQuantity() + quantity);
            FileManager.saveinventory(inventory);
        }
    }

    // Method to check out a product by decreasing its quantity
    public void checkOut(int productId, int quantity){
        Product p = inventory.get(productId);
        if(p!=null && p.getQuantity() >=quantity){
            p.setQuantity(p.getQuantity() - quantity);
            FileManager.saveinventory(inventory);
        }
    }

    // public void listProducts(){
    //     for(Product p : inventory.values()){
    //         System.out.println(p);
    //     }
    // }

    public Collection <Product> listProducts(){
        return inventory.values();
    }

}
