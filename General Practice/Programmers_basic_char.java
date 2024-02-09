import java.util.Scanner;

// isUpper(Lower)Case() -> boolean
// toUpper(Lower)Case() -> return 

// 주의 :둘다 Character Class의 메서드이므로 char 변수 선언해서 String.charAt(int) 로 자른 뒤 사용해야함

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
