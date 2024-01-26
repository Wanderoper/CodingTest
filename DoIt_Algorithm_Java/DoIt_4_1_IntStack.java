// chap04/IntStack.java 
// 133p 스택과 큐 

package DoIt_Algorithm_Practice;

public class DoIt_4_1_IntStack {
	private int[] stk;    // 스택용 배열 
	private int capacity; // 스택 용량 
	private int ptr;      // 스택 포인터 
	
	// 실행 시 예외 : 스택이 비어 있음 
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
			
		}
	}
	
	// 실행 시 예외 : 스택이 가득 
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
			
		}
	}
	
	// 생성자 
	public DoIt_4_1_IntStack(int maxlen) { 
		ptr = 0;
		capacity = maxlen;
		try {
			stk = new int[capacity];
		}
		catch (OutOfMemoryError e) {
			capacity = 0;
		}
	}
	
	// push 메서드
	public int push(int x) throws OverflowIntStackException {
		// 예외처리 1
		// ex) cap. 5일 때 ptr 5이면 arroutofrange
		if (ptr >= capacity) {
			throw new OverflowIntStackException();
		}
		return stk[ptr++] = x; // 다음 push 를 위한 ptr 세팅 
		// 먼저 스택에 push를 한 뒤, 포인터를 올린다  
	}
	
	// pop 메서드
	public int pop() throws EmptyIntStackException {
		// 예외처리 1
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[--ptr]; 
		// 먼저 포인터 인덱스를 하나 감소시킨다 
	}
	
	// peek 메서드
	public int peek() throws EmptyIntStackException {
		// 예외처리 1
		if (ptr <= 0) {
			throw new EmptyIntStackException();
		}
		return stk[ptr - 1];
	}
	
	// clear 메서드
	public void clear() {
		ptr = 0; 
	}
	
	// stack 에서 검색하는 메서드
	public int indexOf(int x) {
		// 꼭대기부터 검색한다 
		for (int i = ptr - 1; i >= 0; i--) {
			if (stk[i] == x) {
				return i;   // 검색 성공 
			} 
		}
		return -1;          // 검색 실패
	}
	
	// stack에 쌓여 있는 데이터 개수를 반환 
	public int size() {
		return ptr;
	}
	
	// isEmpty : stack empty check 
	public boolean isEmpty() {
		return (ptr <= 0);
	}
	// isFull  : stack full check 
	public boolean isFull() {
		return (ptr >= capacity);
	}
	
	// dump    : output stack from bottom to top 
	public void dump() {
		if (ptr <= 0) {
			System.out.println("스택이 비어 있습니다.");
		}
		else {
			for (int i = 0; i < ptr; i++) {
				System.out.print("stk[" + i + "] = " + stk[i]);
			}
			System.out.println();
		}
	}
}
