import java.util.Scanner;

public class array_equality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t>0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            if(n!=m){
                System.out.println(0);
            }
            else {
                int a[] = new int[n];
                outer:while(true){
                    for (int i=0; i<n; i++) a[i] = scanner.nextInt();
                    for (int j=0; j<m; j++) {
                        int b = scanner.nextInt();
                        if (b != a[j]) {
                            System.out.println(0);
                            break outer;
                        }
                    }
                    System.out.println(1);
                    break;
                }

            }
            t--;
        }

    }
}
//5
//10 10
//1 2 3 4 5 6 7 8 9 10
//1 2 3 4 5 6 7 8 9 10 10 10
//1 2 3 4 5 6 7 8 9 10
//1 2 3 4 5 6 7 8 9 10 10 10
//1 2 3 4 5 6 7 8 9 10
//1 2 3 4 5 6 7 8 9 10 10 10
//1 2 3 4 5 6 7 8 9 10
//1 2 3 4 5 6 7 8 9 10 10 10
//129 449 81 884 644 293 802 638 317 662
//259 65 275 206 420 468 483 260 33 239
