package stack;

public class CharStack {
	private char[] stack;
	private int top;
	private int capacity;
	
	CharStack(int capacity){	//생성자값은 클래스 객체를 초기화 해주는 값
		this.capacity = capacity;
		this.stack = new char[capacity];
	}
	
	public boolean isEmpty() {
		return this.top == 0;
	}
	
	public boolean isFull() {	
		//stack에서 stack이 가득 차면 top을 할때 배열의index범위를 벗어나기 때문에
		// top값이 배열의 크기와 같은지 확인하고 실행하기 위해서 top==capacity인지 확인
		return capacity == top;
	}
	
	public boolean push(char par) {
		//push하기전에 가득차있는지 확인하고 가득차있지 않으면 top이 가리키고 있는 곳에 데이터를 넣고
		//top은 1증가
		if(isFull()) {return false;}
		
		stack[top++] = par;
		return true;
	}
	
	public char pop() {
		if(isEmpty()) {return '0';}
		//top이 가리키고잇는곳은 다음 데이터가 들어갈 곳이기때문에 top값을 하나 줄이면 
		//stack에 가장 위에 있는 값을 가리키게 되니까 top-- -> stack[top]하면 됨
		//한줄로 줄이면 [--top]
		return stack[--top];
	}

	public char getTop() {
		//top--를 안하는 이유는 top값이 가리키고 잇는곳이 변경되면 안되니까
		//top은 힐끔보는거 빼는거 아님
		if(isEmpty()) {return '0';}
		return stack[top-1];	
	}
	
}
