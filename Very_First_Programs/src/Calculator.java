import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input first number
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        // Input second number
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Calculate sum, difference, product, and quotient
        double sum = num1 + num2;
        System.out.println("Sum: " + sum);
        double difference = num1 - num2;
        System.out.println("Difference: " + difference);
        double product = num1 * num2;
        System.out.println("Product: " + product);
        if (num2 != 0) {
            double quotient = num1 / num2;
            System.out.println("Quotient: " + quotient);
        }
        else{
            System.out.println("There is no Quotient with divisor equal to 0");
        }
    }
}
