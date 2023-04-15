import java.util.Scanner;

public class replace_char {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        int len = input.length();
        String str = input.substring(0, len-4);
        char f = input.charAt(len-3);
        char e = input.charAt(len-1);

        StringBuilder sb = new StringBuilder();
        for(char i:str.toCharArray()){
            if(i!=f){
                sb.append(i);
            }
            else{
                sb.append(e);
            }
        }
        System.out.println(sb);

    }
}
