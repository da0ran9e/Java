import java.util.Scanner;
public class Nesting_Methods
{
    int perimeter(int l, int b)
    {
        int pr = 12 * (l + b);
        return pr;
    }
    int area(int l, int b)
    {
        int pr = perimeter(l, b);
        System.out.println("Perimeter:"+pr);
        int ar = 6 * l * b;
        return ar;
    }
    int volume(int l, int b, int h)
    {
        int ar = area(l, b);
        System.out.println("Area:"+ar);
        int vol ;
        vol = l * b * h;
        return vol;
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter length of cuboid:");
        int l = s.nextInt();
        System.out.print("Enter breadth of cuboid:");
        int b = s.nextInt();
        System.out.print("Enter height of cuboid:");
        int h = s.nextInt();
        Nesting_Methods obj = new Nesting_Methods();
        int vol = obj.volume(l, b, h);
        System.out.println("Volume:"+vol);
    }
}