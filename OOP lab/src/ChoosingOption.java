import javax.swing.*;

public class ChoosingOption {
    public static void main(String[] args) {
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?", "Confirmation", JOptionPane.YES_NO_OPTION);
        JOptionPane.showMessageDialog(null, "You've chosen: " + (option == JOptionPane.YES_OPTION?"Yes":"No"));
        System.exit(0);
    }
}

// If users choose "Cancel" the program check the `YES_OPTION` return false, macro function return the second option which is "No"
// Add @MagicConstant int optionType and massageType
