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
}
