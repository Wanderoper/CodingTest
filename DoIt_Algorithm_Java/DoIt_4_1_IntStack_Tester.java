package DoIt_Algorithm_Practice;

import java.util.Scanner;

// IntStack 클래스를 테스트하기 위한 클래스 
public class DoIt_4_1_IntStack_Tester {
	public static void main(String[] args) {
		// 변수 모음 
		Scanner scan = new Scanner(System.in);
		int menu; // 메뉴 컨트롤 
		int x;    // push 받을 변수  
		
		
		// Stack을 구현한 클래스를 생성한다 
		DoIt_4_1_IntStack stack = new DoIt_4_1_IntStack(64);
		
		// 메뉴 시작.
		while (true) {
			System.out.println();
			System.out.printf("현재 데이터 개수: %d / %d\n", stack.size(), stack.getCapacity());
			System.out.print("Select the menu to process");
			System.out.println();
			System.out.print("(1) Push (2) Pop (3) Peek (4) Dump (0) Exit: ");
			
			menu = scan.nextInt();
			if (menu == 0) {
				break;
			}
				
			switch (menu) {
				// push 
				case 1: 
					System.out.print("Push 데이터 : ");
					x = scan.nextInt();
					
					try {
						stack.push(x);
					}
					catch (DoIt_4_1_IntStack.OverflowIntStackException e){
						System.out.println("스택이 가득 찼습니다.");
					}
					break;
				
				// pop 
				case 2:
					try {
						x = stack.pop();
						System.out.println("Pop 데이터는 : " + x + " 입니다. ");
					}
					catch (DoIt_4_1_IntStack.EmptyIntStackException e){
						System.out.println("스택이 비어 있습니다.");
					}
					break;
					
				// peek 
				case 3: {
					try {
						x = stack.peek(); 
						System.out.println("현재 peek한 데이터는 : " + x + "입니다.");
					}
					catch (DoIt_4_1_IntStack.EmptyIntStackException e) { 
						System.out.println("peek 할 데이터가 없습니다. ");
					}
					break;
				}
				
				// Dump
				case 4: {
					stack.dump(); 
					break;
				}
			}
		}
	}
}
