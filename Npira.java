package boj_School;

import java.util.Scanner;

public class Npira{

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요 : ");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		
		npria(num);
	}

	
	static void npria(int num) {
		int n = num;
		for(int i = 1; i <= n; i++) {
			for(int j=(n-1); j >= i; j--){		//공백찍기
				System.out.print(" ");
				}
			for(int k = 1; k<=(2*i)-1; k++ ) {	//숫자 찍기
				System.out.print(i%10);
				}
			System.out.println();
		}
	}
}
