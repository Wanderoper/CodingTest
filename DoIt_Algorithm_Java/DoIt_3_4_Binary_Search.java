// 109p 실습 3-4 : 이진검색 

package DoIt_Algorithm_Practice;

import java.util.Scanner;

public class DoIt_3_4 {
	
	static int binSearch(int[] a, int n, int key) {
		// pl: 처음요소 pc: 중앙요소 pr: 마지막요소
		
		int pl = 0;     // 인덱스 
		int pr = n - 1; // 인덱스
		
		do {
			int pc = (pl + pr) / 2; // 중앙 요소의 인덱스
			
			// 1.key가 중앙요소인 경우 찾음. 
			if (a[pc] == key) { 
				return pc; 
			} 
			// 2.key가 중앙요소보다 큰 경우 -> 시작위치를 pc+1로 
			else if (a[pc] < key) {
				pl = pc + 1;
			}
			// 3.key가 중앙요소보다 작은 경우 -> 마지막위치를 pc-1로 
			else if (a[pc] > key) {
				pr = pc - 1;
			}
		} while (pl <= pr);
		
		return -1;
	}

	public static void main(String[] args) {
		int x[]; // 생성할 배열 
		int key; // 배열에서 검색할 값 
		int index; // 배열에서 key가 있는 index
		
		Scanner scan = new Scanner(System.in);
		
		// 배열의 크기 length 입력받기
		System.out.print("배열의 크기를 입력해주세요 : ");
		int length = scan.nextInt();
		x = new int[length];
		
		// 첫 요소만 따로 입력받기
		System.out.println("오름차순으로 입력해주세요.");
		System.out.print("x[0] = ");
		x[0] = scan.nextInt();
		
		for (int i = 1; i < length; i++) {
			// 오름차순으로만 입력받도록 do while 설정 
			do {
				System.out.print("x[" + i + "] = ");
				x[i] = scan.nextInt();
			} while (x[i] < x[i-1]);
		}
		
		System.out.println("배열이 생성되었습니다.");
		System.out.print("배열에서 검색할 값을 입력해주세요 : ");
	    key = scan.nextInt(); 
	    
	    index = binSearch(x, length, key);
	    
	    if (index == -1) {
	    	System.out.println("검색 값이 배열에 없습니다.");
	    } else {
	    	System.out.println("검색하려는 값은 x[" + index + "] 에 있습니다.");
	    }
	}

}
