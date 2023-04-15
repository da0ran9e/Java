import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = input.nextInt();

        int[] arr = new int[size];

        System.out.println("Enter array["+ size +"] :");
        for (int i = 0; i < size; i++) {
            arr[i] = input.nextInt();
        }

        //Close the scanner
        input.close();

        //Display the input array
        System.out.println("Original array: " + Arrays.toString(arr));

        // Sort the array
        Sort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));

        // Calculate sum of array elements
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }
        System.out.println("Sum of array elements: " + sum);

        // Calculate average of array elements
        double average = (double) sum / size;
        System.out.println("Average of array elements: " + average);
    }

    //Sort function using bubble sort
    public static void Sort(int[] arr) {
        int n = arr.length;
        //debug
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                      arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                      arr[j] = arr[j] ^ arr[j+1];

                    swapped = true;
                }
            }
            //Check whether the swap was worked or not
            if (!swapped) {
                break;
            }
        }
    }
}
