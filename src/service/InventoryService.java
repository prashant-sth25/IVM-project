package src.service;
import src.model.Product;
import java.util.HashMap;
import java.util.Map;

public class InventoryService {
    private Map<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product product){
        inventory.put(product.getId(),product);
    }

    public void checkIn(int productId, int quantity){
        Product p = inventory.get(productId);
        if (p!=null){
            p.setQuantity(p.getQuantity() + quantity);
        }
    }

    public void checkOut(int productId, int quantity){
        Product p = inventory.get(productId);
        if(p!=null && p.getQuantity() >=quantity){
            p.setQuantity(p.getQuantity() - quantity);
        }
    }

    public void listProducts(){
        for(Product p : inventory.values()){
            System.out.println(p);
        }
    }

}
