package chapter02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {

	public static void main(String[] args) {
		// 사람 수 입력 받기
		int num = getPositiveNumber("사람 수 : ");
		
		// 사람 수 만큼 키를 random 생성하여 배열에 저장
		int[] height = new int[num];
		getRandArray(height, 100, 200);
		
		// 배열에서 가장 큰 값 찾기
		int max = maxof(height);
		
		//출력
		System.out.println("가장 큰 키는 " + max + "cm입니다");
		
		Random rand = new Random();
		rand.nextInt();

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
	
	static int getPositiveNumber(String message) {
		int num;
		
		Scanner input = new Scanner(System.in);
		do {
			System.out.print(message);
			num = input.nextInt();
		}while(num<=0);
		
		
		return num;
	}
	
	static void getRandArray(int[] numArr, int start, int end) { // height의 주소를 numArr로 받아서 업데이트 하기 때문에 return값이 없다
		Random rand = new Random();
		for(int i = 0; i<numArr.length; i++) {
			numArr[i] =start + rand.nextInt(end-start);
			System.out.print(numArr[i] +" ");
		}System.out.println();
	}
	
}
