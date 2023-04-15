import javax.swing.JOptionPane;
public class Example3{
    public static void main(String[] args){
        String result;
        result = JOptionPane.showInputDialog("Enter your name:");
        JOptionPane.showMessageDialog(null,
                "Hello " + result + "!");
        System.exit(0);
    }
}