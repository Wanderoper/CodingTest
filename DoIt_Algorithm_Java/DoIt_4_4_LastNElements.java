// 원하는 개수만큼 값을 계속 입력받고, 요솟수가 N인 배열에 마지막 N 개를 저장 

package DoIt_Algorithm_Practice;

import java.util.Scanner;

public class DoIt_4_4_LastNElements {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int N = 10;
		int[] a = new int[N];  // 입력 값 저장할 배열
		int cnt = 0;           // 입력받은 개수 
		int retry;             // 재실행 여부 
		
		System.out.println("정수를 입력하세요.");
		
		// -------- 생성 부분 ------------ // 
		do {
			System.out.printf("%d번째 정수: ", cnt + 1);
			a[cnt++ % N] = scan.nextInt();
			
			System.out.print("계속할까요? (예 = 1, 아니오 = 2) 입력 => ");
			retry = scan.nextInt();
		} while (retry == 1);
		
		// -------- 출력 부분 ------------ // 		
		int i = cnt - N;
		if (i < 0) { i = 0;	}
		
		for ( ; i < cnt; i++) {
			System.out.printf("%2d번째 정수 = %d\n", i + 1, a[i % N]);
		}
	}
}
