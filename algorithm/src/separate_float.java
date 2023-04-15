import java.util.Scanner;

public class separate_float {
    public static void main(String[] args) {
        float num, intpart, decpart;

        Scanner scanner = new Scanner(System.in);

        num = scanner.nextFloat();
        intpart =(float) Math.floor(num);
        decpart = num - intpart;

        System.out.println(String.format("%.0f %.2f", intpart, decpart));
    }
}
