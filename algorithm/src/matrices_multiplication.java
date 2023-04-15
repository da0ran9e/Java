import java.util.Scanner;

public class matrices_multiplication {
    public static void main(String[] args) {
        int x, y, Y, mem=0;
        int M1[][] = new int[101][101];
        int M2[][] = new int[101][101];

        Scanner scanner = new Scanner(System.in);

        y = scanner.nextInt();
        x = scanner.nextInt();
        Y=y;

        for(int i=1; i<=y; i++){
            for(int j=1; j<=x; j++){
                M1[i][j] = scanner.nextInt();
            }
        }

        y = scanner.nextInt();
        x = scanner.nextInt();
        for(int i=1; i<=y; i++){
            for(int j=1; j<=x; j++){
                M2[i][j] = scanner.nextInt();
            }
        }

        for(int i=1; i<=Y; i++){
            for(int j=1; j<=x; j++){
                for(int k=1; k<=y; k++){
                    mem=mem+M1[i][k]*M2[k][j];
                }
                System.out.print(mem+" ");
                mem = 0;
            }
            System.out.print('\n');
        }
    }
}
