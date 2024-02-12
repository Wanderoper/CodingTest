package DoIt_Algorithm_Practice;

public class DoIt_4_3_IntArrayQueue_RingBuffer {
	
	private int[] queue;  // 큐 구현용 배열 
	private int capacity; // 큐 용량 
	private int front;    // 맨 처음 요소 커서 
	private int rear;     // 맨 끝 요소 커서 
	private int num;      // 현재 데이터 개수 
	
	//--- dequeue 시 예외: 큐가 비어있음 ---//
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() { }
    }
	
	//--- enqueue 시 예외: 큐가 가득찼음 ---//
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }
	
	//--- CONSTRUCTOR : intqueue ---//
    public DoIt_4_3_IntArrayQueue_RingBuffer(int maxlen) {
        num = front = rear = 0; // 모두 0으로 초기화해주기 
        capacity = maxlen;
        try {
            queue = new int[capacity];        // 큐 본체용 배열을 생성
        } catch (OutOfMemoryError e) {        // 생성할 수 없음 (호출시 throws 사용)
            capacity = 0;
        }
    }
    
	//--- ENQUEUE : 데이터 인큐 ---//
    public int enqueue(int x) throws OverflowIntQueueException {
    	if (num >= capacity) { // 배열이 가득찼다
    		throw new OverflowIntQueueException();
    	}
    	queue[rear++] = x; // 가장 뒤에 쌓고 포인터 증가 시키기 
    	num++;             // 데이터의 갯수 증가
    	if (rear == capacity) { // rear가 capacity에 다다르면 Ring의 첫부분 (0)으로 이동 
    		rear = 0;
    	}
    	return x;
    }
	
	//--- DEQUEUE : 데이터 디큐 (주의: front에서 빼준 ---//
   public int dequeue() throws EmptyIntQueueException {
	   if (num <= 0) {            // == 보다 <= 사용권장 
		   throw new EmptyIntQueueException();
	   }
	   int x = queue[front++];    // 리턴할 값 : x에 front를 담고 카운트를 하나 올려준다
	   num--;                     // 요소 한개를 디큐 하니까 카운트해주기
	   if (front == capacity) {
		   front = 0;             // enqueue와 마찬가지로 Ring 버퍼이므로 맨 처음으로 돌린다 
	   }
	   return x;       // 디큐되는 요소를 리턴  	   
   }
	
	//--- PEEK : 큐에서 데이터를 피크 ---//
   public int peek() throws EmptyIntQueueException {
	   if (num <= 0) {            // == 보다 <= 사용권장 
		   throw new EmptyIntQueueException();
	   }
	   return queue[front];
   }
	
	//--- 큐를 비움 ---//
   public void clear() { num = front = rear = 0; }
	
	//--- 큐에서 x를 검색하여 인덱스(찾지 못하면 –1)를 반환 ---//
	   // --- 내가 짠 로직 --- // 
//	   if (rear >= front) { // front 부터 ~ rear 까지 검색 (인덱스를) 
//		 for (int i = front; i < rear; i++) {
//			 if (queue[i] == key) {
//				 return i;
//			 }
//		 }
//	   }
//	   else if (rear < front) {// front ~ capacity 검색하고 , 0 ~ rear 까지 두번 
//		  for (int i = front; i < capacity; i++) {
//			  if (queue[i] == key) {
//				  return i;
//			  }
//		  }
//		  for (int i = 0; i < rear; i++) {
//			  if (queue[i] == key) {
//				  return i;
//			  }
//		  }
//	   }
	   
	   // --- 책 해답 --- // 
	   public int indexOf(int key) { 
		   for (int i = 0; i < num; i++) {         // num 을 활용한다 
			   int index = (i + front) % capacity; // 핵심 코드 
			   if (queue[index] == key) {
				   return index;
			   }
		   }
		   return -1;
	   }
	
	//--- 큐의 크기를 반환 ---//
	public int getCapacity() { return capacity; }
	
	//--- 큐에 쌓여 있는 데이터 개수를 반환 ---//
	public int size() { return num; }
	
	//--- 큐가 비어있는가? ---//
	public boolean isEmpty() { return (num <= 0); }
	
	//--- 큐가 가득 찼는가? ---//
	public boolean isFull() { return (num >= capacity); }
	
	//--- 큐 안의 모든 데이터를 프런트 → 리어 순으로 출력 ---//
	public void dump() {
		if (num <= 0) {
			System.out.println("큐가 비어있습니다.");
		}
		for (int i = 0; i < num; i++) {
			int index = (i + front) % capacity;
			System.out.print(queue[index] + " " );
		}
		System.out.println();
	}
	
}
