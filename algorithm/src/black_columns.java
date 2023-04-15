import java.util.Arrays;
import java.util.Scanner;

public class black_columns {
    public static void main(String[] args) {
        int r, c, cell;
        boolean is_black[] = new boolean[1001];
        int cnt=0;

        Scanner scanner = new Scanner(System.in);

        r = scanner.nextInt();
        c = scanner.nextInt();

        Arrays.fill(is_black, true);

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                cell = scanner.nextInt();
                boolean b = (cell != 0) ? true : false;
                is_black[j] = is_black[j]&b;
            }
        }
        for(int k=0; k<c; k++) if(is_black[k]) cnt++;
        System.out.println(cnt);
    }
}
