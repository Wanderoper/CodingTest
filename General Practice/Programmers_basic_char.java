import java.util.Scanner;

public class Programmers_basic_char {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String answer = "";
        char index;
        
        for (int i = 0; i < a.length(); i++) {
            index = a.charAt(i);
            if (Character.isUpperCase(index)) {
                answer += Character.toLowerCase(index);
            }
            else {
                answer += Character.toUpperCase(index);
            }
        }
        
        System.out.print(answer);
    }
}
