package src.model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private String location;

    public Product(int id, String name, int quantity, String location) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.location = location;
    }

    //adding getter and setter methods
    public int getId(){return id;}
    public String getName(){return name;}
    public int getQuantity(){return quantity;}
    public String getLocation(){return location;}

    public void setQuantity(int quantity){this .quantity = quantity;}
    
    @Override
    public String toString(){
        return "ID: " + id + ", Name: " + name + ", Quantity: " + quantity + ", Location: " + location;
    }
}
