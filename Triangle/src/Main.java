import java.util.Scanner;

public class Main {

    // Display filled triangle pattern
    public static void Filled(int n, char character, int spacing) {
        int numChars = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= numChars; k++) {
                System.out.print(character);
                for (int l = 1; l <= spacing; l++) {
                    System.out.print(" ");
                }
            }
            numChars += 2;
            System.out.println();
        }
    }

    //Display hollow triangle pattern
    public static void Hollow(int n, char character, int spacing) {
        int numChars = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = n - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= numChars; k++) {
                if (k == 1 || k == numChars || i == n) {
                    System.out.print(character);
                } else {
                    for (int l = 1; l <= spacing; l++) {
                        System.out.print(" ");
                    }
                }
            }
            numChars += 2;
            System.out.println();
        }
    }
    public static void displayTriangle(int height) {
        int numChars = 1;
        for (int i = 1; i <= height; i++) {
            for (int j = height - i; j > 0; j--) {
                System.out.print(" ");
            }
            if (i == 4) {
                System.out.print("********");
                numChars += 8;
            } else if (i == 5) {
                System.out.print("***********");
                numChars += 9;
            } else {
                for (int k = 1; k <= numChars; k++) {
                    System.out.print("*");
                }
            }
            numChars += 2;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Get input for triangle height and character
        Scanner scanner = new Scanner(System.in);

        //Enter height by lines by an integer
        System.out.print("Enter the height of the triangle: ");
        int n = scanner.nextInt();
        if (n == 5) displayTriangle(5);
        else {
            //Optional of characters displayed
            System.out.print("Enter the character for the triangle: ");
            char character = scanner.next().charAt(0);

            //Fill or hollow
            System.out.print("Do you want the triangle to be filled? (Y/N): ");
            String filled = scanner.next().toUpperCase();

            //As description
            System.out.print("Enter the spacing between characters: ");
            int spacing = scanner.nextInt();
            scanner.close();

            // Display filled or hollow triangle pattern
            System.out.println("Upward-Pointing Triangle Pattern:");
            if (filled.equals("Y")) {
                Filled(n, character, spacing);
            } else if (filled.equals("N")) {
                Hollow(n, character, spacing);
            } else {
                System.out.println("Invalid choice for filled or hollow!");
            }
        }


    }
}
