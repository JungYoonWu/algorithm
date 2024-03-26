package chapter02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class ReverseArray_mk2 {

	public static void main(String[] args) {
				
		int[] numArr = new int[getPositiveNumber("양수를 입력하세요. ")];
		
		getRandArray(numArr);
		reverseArray(numArr);
		displayArray(numArr);
		
		
	}
	
	static int getPositiveNumber(String message) {
		int num;  //int numIndexLength;
				  //int num
		
		Scanner input = new Scanner(System.in);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print(message);
			num = input.nextInt();
		}while(num<=0);
		
		
		return num;
	}
	
	static void reverseArray(int[] numArr) {
		for(int i = 0; i < numArr.length / 2; i++) {
			// 배열의 index값이 i와 numArr.length-1-i인 곳의 값이 바뀐다
			// 배열의 시작인덱스 0은 i부터 끝 인덱스 값인 length-i-1 값
			swapArr(numArr, i, numArr.length-1-i);   
			
		}
	}
	
	static void reverseArray2(int[] numArr) {
		for(int i = 0, j = numArr.length-1; i<numArr.length; i++, j--) {
			swapArr(numArr, i, j);
		}
	}
	
	
	static void swapArr(int[] numArr, int source, int target) {

		int temp = numArr[source];
		numArr[source] = numArr[target];
		numArr[target] = temp;
		
		
	//	int a = numArr[source];
	//	int b = numArr[target];
	//	int temp = a;
	//	a = b;
	//	b = temp;
	}

	static void getRandArray(int[] numArr) { // 
		Random rand = new Random();
		for(int i = 0; i<numArr.length; i++) {
			numArr[i] = rand.nextInt();
			System.out.print(numArr[i] +" ");
		}System.out.println();
	}
	
	static void displayArray(int[] numArr) {
		
		for(int i = 0; i < numArr.length; i++) {
			System.out.print(numArr[i] + " ");
		}System.out.println();
	}

}
