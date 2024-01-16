// 단계별 - 1차원 배열 - 개수 세기
// https://www.acmicpc.net/problem/10807

import java.util.Scanner;

public class BOJ_10807 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        
        int count = 0; // 카운터
        // 첫째 줄 
        int N = scan.nextInt(); // length 구하기
        int arr[] = new int[N]; 
    
        // 둘째 줄
        for (int i = 0; i < N; i++) {
            arr[i] = scan.nextInt();
        }
    
        // 셋째 줄
        int v = scan.nextInt();
    
        for (int i = 0; i < N; i++) {
            if (arr[i] == v) {
                count++;
            }
        }   
        System.out.println(count);

	}

}
