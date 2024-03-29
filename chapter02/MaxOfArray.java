package chapter02;

public class MaxOfArray {

	public static void main(String[] args) {
		
		int[] numArr = {32, 45, 69, 30, 66};
		
		int max = maxof(numArr);
		
		System.out.println("최대값은 " + max + "입니다");
	}
	
	static int maxof(int[] numArr) {
		
		int search = numArr[0];
		
		for(int i = 1; i < numArr.length; i++) { // 초기화값이 [0]번이니까 1번부터 조사
			if(search<numArr[i]) {
				search = numArr[i];
			}
		}
		
		return search;
	}

}
