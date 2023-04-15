import java.util.Scanner;

public class add_two_integers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.next();
        String b = s.next();
        System.out.println(sum(a, b));
    }

    public static String sum(String a, String b) {

        int lenA = a.length();
        int lenB = b.length();
        if (lenA < lenB) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lenB - lenA; i++) {
                sb.append('0');
            }
            sb.append(a);
            a = sb.toString();
        } else if (lenA > lenB) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lenA - lenB; i++) {
                sb.append('0');
            }
            sb.append(b);
            b = sb.toString();
        }


        int mem = 0;
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            int digitA = a.charAt(i) - '0';
            int digitB = b.charAt(i) - '0';
            int digitSum = digitA + digitB + mem;
            int lastDigit = digitSum % 10;
            mem = digitSum / 10;
            resultBuilder.insert(0, (char) (lastDigit + '0'));
        }
        if (mem == 1) {
            resultBuilder.insert(0, '1');
        }
        return resultBuilder.toString();
    }
}
