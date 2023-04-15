public class Sum_Overloading
{
    int add(int x, int y)
    {
        int sum;
        sum = x + y;
        return sum;
    }
    int add(int x, int y, int z)
    {
        int sum;
        sum = x + y + z;
        return sum;
    }
    int add(int x, int y, int z, int w)
    {
        int sum;
        sum = x + y + z + w;
        return sum;
    }
    public static void main(String[] args)
    {
        Sum_Overloading obj = new Sum_Overloading();
        int a = obj.add(10, 15);
        System.out.println("Sum with two arguments:"+a);
        int b = obj.add(10, 15, 20);
        System.out.println("Sum with three arguments:"+b);
        int c = obj.add(10, 15, 20, 25);
        System.out.println("Sum with four arguments:"+c);
    }
}