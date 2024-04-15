package queue;

public class IntQueue {
	private int[] queue;
	private int front;
	private int rear;
	private int size;
	private int capacity;
	
	public IntQueue(int capacity) {
		queue = new int[capacity];
		front = rear = size = 0;
		this.capacity = capacity;
	}
	
	public boolean enqueue(int data) {
		if(isFull()) {
			return false;
		}
		queue[rear++] = data;
		if(rear == capacity) {
			rear = 0;
		}
		size++;
		return true;
	}
	public int dequeue() {
		if(isEmpty()) {
			return -1;
		}
		int result = queue[front++];
		if(front == capacity) {
			front = 0;
		}
		size--;
		return result;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public boolean isFull() {
		return size==capacity;
	}
	public int getFront() {
		if(isEmpty()) {
			return -1;
		}
		return queue[front];
	}
	public void clear() {
		size = front = rear = 0;
	}
	public void dump() {
		//empty
		if(isEmpty()) {
			System.out.println("Queue가 비어 있습니다.");
		}
		//front< rear
		else if(front< rear) {
			for(int i = front; i < rear; i++ ) {
				System.out.print(queue[i] + " ");
			}System.out.println();
		}
		//front >= rear
		else {
			//front -> capacity -1
			for(int i = front; i < capacity; i++) {			
				System.out.print(queue[i] + " ");
			}
			//0 -> rear-1
			for(int i = 0; i < rear; i++) {
				System.out.println(queue[i] + " ");
			}System.out.println();
		}
		
		
		
	}
}
