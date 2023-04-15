import java.util.Scanner;

public class bounding_rectangle {
    public static void main(String[] args) {
        int Xmax = 0, Xmin = Integer.MAX_VALUE, Ymax = 0, Ymin = Integer.MAX_VALUE;
        int x, y, t;
        Scanner s = new Scanner(System.in);
        t = s.nextInt();
        for(int i=0; i<t*2; i++){
            x = s.nextInt();
            y = s.nextInt();

            if(x<Xmin) Xmin = x;
            if(x>Xmax) Xmax = x;
            if(y<Ymin) Ymin = y;
            if(y>Ymax) Ymax = y;
        }
        int rec = (Xmax-Xmin)*(Ymax-Ymin);
        System.out.println(rec);

    }
}
