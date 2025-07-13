package src.ui;

import src.model.Product;
import src.service.InventoryService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class InventoryAppGUI {
    private InventoryService service = new InventoryService();

    private JFrame frame;
    private JTextArea displayArea;
    private JTextField idField, nameField, qtyField, locField;

    public void createAndShowGUI(){
        frame =new JFrame("Warehouse Inventory System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        JPanel panel = new JPanel (new GridLayout(7,2,5,5));

        //input fields
        idField = new JTextField();
        nameField = new JTextField();
        qtyField = new JTextField();    
        locField = new JTextField();

        //buttons
        JButton addBtn = new JButton("Add Product");
        JButton checkInBtn = new JButton("Check In");
        JButton checkOutBtn = new JButton("Check Out");
        JButton listBtn = new JButton("List Products");

        //display area
        displayArea = new JTextArea(10,40);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        //add labels and fields
        panel.add(new JLabel("Product ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Quantity:"));
        panel.add(qtyField);
        panel.add(new JLabel("Location:"));
        panel.add(locField);
        panel.add(addBtn);
        panel.add(checkInBtn);
        panel.add(checkOutBtn);
        panel.add(listBtn);

        //add action
        addBtn.addActionListener(this::handleAdd);
        checkInBtn.addActionListener(this::handleCheckIn);
        checkOutBtn.addActionListener(this::handleCheckOut);
        listBtn.addActionListener(e-> listProducts());

        frame.getContentPane().add(panel,BorderLayout.NORTH);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void handleAdd(ActionEvent e){
        try{
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int qty = Integer.parseInt(qtyField.getText());
            String loc = locField.getText();

            Product product = new Product(id, name, qty, loc);
            service.addProduct(product);
            showMessage("Product added.");
            clearInputs();
        }catch (Exception ex){
            showMessage("Error:" + ex.getMessage());
        }
    }

    private void handleCheckIn(ActionEvent e){
        try {
            int id = Integer.parseInt(idField.getText());
            int qty = Integer.parseInt(qtyField.getText());
            service.checkIn(id, qty);
            showMessage("Checked in successfully.");
        }catch(Exception ex){
            showMessage("Error: " + ex.getMessage());
        }
    }

    private void handleCheckOut(ActionEvent e){
        try {
            int id = Integer.parseInt(idField.getText());
            int qty = Integer.parseInt(qtyField.getText());
            service.checkOut(id, qty);
            showMessage("Checked out successfully.");
        }catch(Exception ex){
            showMessage("Error: " + ex.getMessage());
        }
    }

    private void listProducts(){
        displayArea.setText("");
        service.listProducts().forEach(p -> displayArea.append(p + "\n"));
    }

    private void showMessage(String message){
        JOptionPane.showMessageDialog(frame, message);
    }

    private void clearInputs(){
        idField.setText("");
        nameField.setText("");
        qtyField.setText("");
        locField.setText("");
    }
}
