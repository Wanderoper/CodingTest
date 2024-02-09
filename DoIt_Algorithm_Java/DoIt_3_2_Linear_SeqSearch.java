package DoIt_Algorithm_Practice;

import java.util.Scanner;

// 선형 검색 
public class DoIt_3_2_Linear_SeqSearch {
	// 요솟수가 n인 배열 a에서 key와 값이 같은 요소를 선형 검색
	
	public static int seqSearch(int num, int[] arr, int key) {		

		// for문으로 찾는 방법 
		
//		for (int i = 0; i <= num; i++) {
//			if (arr[i] == key) {
//				return i;
//			}
//		}
//		return -1;
		
		// while문으로 찾는 방법 
		int i = 0;
		
		while (true) {
			if (i == num) {
				return -1;
			}
			if (arr[i] == key) {
				return i;
			}
			i++;
		}
	}
	
	// main method 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 배열 사이즈 
		System.out.print("요솟수 입력 :");
		int arrSize = scan.nextInt();
		
		int[] arrLinear = new int[arrSize];
		
		// 배열 생성 
		for (int i = 0; i < arrSize; i++) {
			
			System.out.print((i+1) + "번 째 요소를 입력해 주세요 :");
			arrLinear[i] = scan.nextInt();			
			if (i == arrSize - 1) {
				System.out.println("배열이 생성되었습니다.");
			}
		}
		
		// 찾을 요소 입력
		System.out.println();
		System.out.print("배열에서 찾을 요소 :");
		int key = scan.nextInt();
		
		int answer = seqSearch(arrSize, arrLinear, key);
		
		// answer 판단 
		if (answer == -1) {
			System.out.println("찾는 값이 배열에 없습니다.");
		}
		else {
			System.out.println("찾는 값은 " + (answer + 1) + "번 째에 있습니다.");
		}
		
		
	}	
}
