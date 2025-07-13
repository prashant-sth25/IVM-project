package src;
import src.ui.ConsoleMenu;
import javax.swing.SwingUtilities;
import src.ui.InventoryAppGUI;

public class Main {
    public static void main(String [] args){
        // new ConsoleMenu().start();
        SwingUtilities.invokeLater(()-> new InventoryAppGUI().createAndShowGUI());
    }
}
