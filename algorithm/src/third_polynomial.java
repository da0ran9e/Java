import java.util.Scanner;
import static java.lang.Math.abs;

public class third_polynomial {
    public static int roots[] = new int[3];
    public static int rootcount[] = new int[3];
    public static int numroots;

    public static boolean check(long x, long a, long b){
        long a1, b1;
        a1 = a*2;
        b1 = b;
        if (3*x*x+a1*x+b1 == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public static void addRoot (long a, long b, long c){
        int num = Math.toIntExact(abs(c));
        for (int x = -1 * num; x<num; x++){
            if (x*x*x + a*x*x + b*x + c == 0){
                roots[numroots] = x;

                if(check(x, a, b)){
                    rootcount[numroots] = 2;
                }
                else {
                    rootcount[numroots] = 1;
                }
                numroots++;
            }
        }
    }

    public static void print(){
        int count =0;
        for (int i = 0; i<numroots; i++){
            count += rootcount[i];
            System.out.println(roots[i] +" "+rootcount[i]);
        }

        if (count<1) System.out.println("NO SOLUTION");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        long b = scanner.nextLong();
        long c = scanner.nextLong();

        addRoot(a, b, c);
        print();
    }
}
