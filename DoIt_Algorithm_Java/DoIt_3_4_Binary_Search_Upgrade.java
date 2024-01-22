package DoIt_Algorithm_Practice;

import java.util.Arrays;
import java.util.Scanner;

public class DoIt_3_4_again {
	
	public static void main(String[] Args) {
		int SIZE;
		int arr[]; 
		int key;
		int answer;
		boolean toContinue = false;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("배열의 크기를 입력해주세요 : ");
		SIZE = scan.nextInt();
		arr = new int[SIZE];
		
		System.out.print(" 1 번째 요소를 입력해주세요 : ");
		arr[0] = scan.nextInt();
		
		for (int i = 1; i < SIZE; i++) {
			do {
				System.out.print( (i + 1) + "번째 요소를 입력해주세요 : ");
				arr[i] = scan.nextInt();
			} while (arr[i-1] > arr[i]);
		}
		
		do {
			System.out.print("찾고자 하는 값을 입력해주세요 : ");
			key = scan.nextInt();
			
//			answer = binarySearch(arr, key); // 직접 이진검색 메서드 작성하는 방
			answer = Arrays.binarySearch(arr, key);
			
			if (answer < 0) {
				System.out.println("찾고자 하는 값이 배열에 없습니다.");
				toContinue = continueSearch();
			} 
			else {
				System.out.println("값을 찾았습니다.");
				System.out.println("찾고자 하는 값은 [" + ( answer + 1 ) + "] 번째에 있습니다." );
				toContinue = continueSearch();
			}
			
		} while ( toContinue == true );	
		
	}
	
	static int binarySearch(int arr[], int key) {
		int pl; // left
		int pc; // central
		int pr; // right
		
		pl = 0;
		pr = arr.length - 1;
		
		do {
			pc = (pr + pl) / 2;
			
			if (arr[pc] < key) {
				pl = pc + 1;
			} 
			else if (arr[pc] > key) {
				pr = pc - 1;
			}
			else if (arr[pc] == key) {
				return pc;
			}
			
		} while (pl <= pr) ;
		
		return -1;
	}
	
	static boolean continueSearch() {
		int decision;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("다시 시도하시겠습니까? (Yes = 1 , No = 2)");
		decision = scan.nextInt();
		
		switch (decision) {
			case 1: 
				return true;
			case 2:
				return false;
			default:
				break;
		}
		return true;
	}
	
}
