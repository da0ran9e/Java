import javax.swing.*;
import java.awt.*;

public class solveEquation {

    public static void Solve(double a, double b){
        if (a!=0){
                double x = -(b/a);
                JOptionPane.showMessageDialog(null, a+"x + "+b+" = 0\n"+"x = "+x);
            }
            else {
                int error = JOptionPane.showConfirmDialog(null, "Invalid value for coefficient 'a'. Please try again!","Error!", JOptionPane.OK_CANCEL_OPTION);
                if(error == JOptionPane.OK_OPTION){
                    firstDeg();
                }
            }
    }
    public static void Solve(double a11, double a12, double a21, double a22, double b1, double b2){
        double det = a11 * a22 - a21 * a12;

        if (det == 0){
            JOptionPane.showMessageDialog(null, "No solution!");
        }
        else{
            double x1 = ( b1 * a22 - b2 * a12 ) / det;
            double x2 = ( a11 * b2 - a21 * b1 ) / det;

            JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
        }
    }

    public static void Solve(double a, double b, double c){
         double d = b * b - 4 * a * c;

        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);

            JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
        } else if (d == 0) {
            double x = -b / (2 * a);

            JOptionPane.showMessageDialog(null,  "Equation has double real root x = " + x);
        } else {
            JOptionPane.showMessageDialog(null,  "Equation has no real root");
        }
    }

    public static void firstDeg(){
        JPanel inputPanel = new JPanel(new GridLayout(1, 4));
        JTextField input_a = new JTextField();
        JLabel text1 = new JLabel("*x +");
        JTextField input_b = new JTextField();
        JLabel text2 = new JLabel("= 0");

        inputPanel.add(input_a);
        inputPanel.add(text1);
        inputPanel.add(input_b);
        inputPanel.add(text2);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Input coefficients", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION){
            double a = Double.parseDouble(input_a.getText());
            double b = Double.parseDouble(input_b.getText());

            Solve(a,b);
        }
    }
    public static void systemEquation(){
        JPanel inputPanel = new JPanel(new GridLayout(2, 5));
        JTextField input_a11 = new JTextField();
        JTextField input_a12 = new JTextField();
        JTextField input_a21 = new JTextField();
        JTextField input_a22 = new JTextField();
        JTextField input_b1 = new JTextField();
        JTextField input_b2 = new JTextField();
        JLabel label1 = new JLabel(" x1 + ");
        JLabel label2 = new JLabel(" x2 = ");
        JLabel label3 = new JLabel(" x1 + ");
        JLabel label4 = new JLabel(" x2 = ");

        inputPanel.add(input_a11);
        inputPanel.add(label1);
        inputPanel.add(input_a12);
        inputPanel.add(label2);
        inputPanel.add(input_b1);
        inputPanel.add(input_a21);
        inputPanel.add(label3);
        inputPanel.add(input_a22);
        inputPanel.add(label4);
        inputPanel.add(input_b2);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Input coefficients", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION){
            double a11 = Double.parseDouble(input_a11.getText());
            double a12 = Double.parseDouble(input_a12.getText());
            double a21 = Double.parseDouble(input_a21.getText());
            double a22 = Double.parseDouble(input_a22.getText());
            double b1 = Double.parseDouble(input_b1.getText());
            double b2 = Double.parseDouble(input_b2.getText());

            Solve(a11, a12, a21, a22, b1, b2);
        }

    }

    public static void secondDeg(){
        JPanel inputPanel = new JPanel(new GridLayout(1, 6));
        JTextField input_a = new JTextField();
        JTextField input_b = new JTextField();
        JTextField input_c = new JTextField();
        JLabel label1 = new JLabel(" x^2 + ");
        JLabel label2 = new JLabel(" x + ");
        JLabel label3 = new JLabel(" = 0");

        inputPanel.add(input_a);
        inputPanel.add(label1);
        inputPanel.add(input_b);
        inputPanel.add(label2);
        inputPanel.add(input_c);
        inputPanel.add(label3);

        int result = JOptionPane.showConfirmDialog(null, inputPanel, "Input coefficients", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            double a = Double.parseDouble(input_a.getText());
            double b = Double.parseDouble(input_b.getText());
            double c = Double.parseDouble(input_c.getText());

            Solve(a, b, c);
        }
    }
    public static void main(String[] args) {
        String[] options = {"ax + b = 0", "<html>a11x1 + a12x2 = b1<br>a21x1 + a22x2 = b2</html>", "ax^2 + bx + c = 0"};
        int defaultOption = 0;
        int chose = JOptionPane.showOptionDialog(null, "Choose the form of equation: ",
                "Option dialog", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[defaultOption]);

        switch (chose) {
            case 0 -> firstDeg();
            case 1 -> systemEquation();
            case 2 -> secondDeg();
            default -> {
            }
        }
    }
}
