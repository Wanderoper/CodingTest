// 선형검색 (보초법 Sentinel) 

// 보초법을 쓰려면 배열 사이즈를 + 1 늘려주고 거기에 센티넬을 집어넣어줘서 판단횟수를 한번으로 줄인다 

package DoIt_Algorithm_Practice;

import java.util.Scanner;

public class DoIt_3_2_Linear_SeqSearchSentinel {
	static int seqSearchSen(int num, int[] arr, int key) {
		// while문 방법 
		int i = 0;
		
		arr[num] = key; // 센티넬 추가 
		
		while (true) {
			if (arr[i] == key) {
				break;
			}
			i++;
		}
		
		return ( i == num ? -1 : i ); 
		
		// for문 방법 
	}

	// main method 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// 배열 사이즈 
		System.out.print("요솟수 입력 :");
		int arrSize = scan.nextInt();
		
		int[] arrLinear = new int[arrSize + 1];
		
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
		
		int answer = seqSearchSen(arrSize, arrLinear, key);
		
		// answer 판단 
		if (answer == -1) {
			System.out.println("찾는 값이 배열에 없습니다.");
		}
		else {
			System.out.println("찾는 값은 " + (answer + 1) + "번 째에 있습니다.");
		}
		
		
	}	
}
