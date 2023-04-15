import java.text.DateFormatSymbols;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month, year;
        boolean validInput = false;

        // Prompt user for month and year until valid input is provided
        do {
            System.out.print("Enter a month (1-12): ");
            month = input.nextInt();
            System.out.print("Enter a year: ");
            year = input.nextInt();

            if (isValidMonth(month) && isValidYear(year)) {
                validInput = true;
            } else {
                System.out.println("Invalid month/year! Please try again.");
            }
        } while (!validInput);

        input.close();

        // Get month name using DateFormatSymbols
        String monthName = new DateFormatSymbols().getMonths()[month - 1];

        // Calculate and display number of days in the entered month
        int numDays = getNumDaysInMonth(month, year);
        System.out.println("Number of days in " + monthName + " " + year + ": " + numDays);
    }

    // Check if input month is valid (between 1 and 12)
    public static boolean isValidMonth(int month) {
        return month >= 1 && month <= 12;
    }

    // Check if input year is valid (greater than 0)
    public static boolean isValidYear(int year) {
        return year > 0;
    }

    // Calculate and return number of days in a month, considering leap years
    public static int getNumDaysInMonth(int month, int year) {
        int numDays;
        switch (month) {
            case 2:
                numDays = isLeapYear(year) ? 29 : 28;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            default:
                numDays = 31;
                break;
        }
        return numDays;
    }

    // Check if a year is a leap year (divisible by 4, but not divisible by 100 unless also divisible by 400)
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
