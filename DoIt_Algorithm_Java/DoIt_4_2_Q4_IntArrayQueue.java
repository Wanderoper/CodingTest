package DoIt_Algorithm_Practice;

public class DoIt_4_2_Q4_IntArrayQueue {
	
	private int[] queue;  // 큐 구현용 배열 
	private int capacity; // 큐 용량 
	private int num;      // 현재 데이터 개수 
	
	// Constructor 
	public DoIt_4_2_Q4_IntArrayQueue(int maxlen) {
		capacity = maxlen; // 용량 초기화 
		queue = new int[capacity];
		num = 0; // 현재 데이터개수 초기화 
	}
	
	// Enqueue 
	public void enqueue(int x) {
		queue[num++] = x; // 넣고 포인터를 하나 올린다 
	}
	
	// Dequeue
	public void dequeue() {
		// 0번째를 빼고 나머지 요소들의인덱스를 하나씩 당겨야 한다 
		int temp; // front를 temp 에 담고 rear를 front에 넣고 front를 -1에 담기 
	
		for (int i = 0; i <= (num - 1); i++) {
			if (i == (num - 1)) { 
				--num; // 마지막요소는 null 할 필요없이 그냥 포인터 줄여버리기
				break;
			}
			queue[i] = queue[i+1];
		}
	}
	
	// Peek 
	public int peek() {
		return queue[num - 1]; 
	}
	
	// Dump 
	public void dump() {
		for (int i = 0; i <= (num - 1); i++ ) {
			System.out.println((i + 1) + "번 째 데이터 : " + queue[i]);
		}
	}
	
	// Clear 
	public void clear() {
		num = 0;
	}
	
	// Search 
	public void indexOfArr(int x) {
		for (int i = 0; i <= (num - 1); i++) {
			if (queue[i] == x) {
				System.out.println("찾는 데이터는 " + (i + 1) + "번 째에 있습니다.");
			}
		}
	}
	
	// 용량 구하기 : getCapacity 
	public int getCapacity() {
		return capacity;
	}
	
	// 용량이 max에 도달했는지 확인 : isFull 
	public boolean isFull() {
		if (num == capacity) {
			return true;
		} 
		else {
			return false;
		}
	}
	
	// 용량이 비었는지 확인 : isEmpty 
	public boolean isEmpty() {
		if (num == 0 ) {
			return true;
		}
		else { 
			return false;
		}
	}

}
