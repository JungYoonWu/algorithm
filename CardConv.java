package chapter02;

import java.util.Scanner;

public class CardConv {

	public static void main(String[] args) {
		//양의 숫자 입력 받기
		int num = getPositiveNumber("양의 숫자 : ");
		
		//몇진수 변환할지 입력받기 (양수)
		//int card = getPositiveNumber("몇진수로 변환할까요?(양수) : ");
		
		//2진수로 변환하기(메서드)
		char[] cardNum = new char[64];
		int numDigit;   //입력받은 숫자가 몇자리 수인지 저장하는 변수
		
		//numDigit = cardConv2(num, cardNum); //2진수로 변환된 값이 cardnum에 저장되고 numdigit에 몇자리수인지 반환
		//numDigit = cardConv(num, card, cardNum); //메소드에 들어가는 변수의 자료형과 메소드가 받는 파라미터의 자료형이 다르면 오류발생함
		numDigit = cardConv16(num, cardNum);
		
		//변환 결과 출력하기
		displayResult(cardNum, numDigit);
	}

	static int getPositiveNumber(String message) {
		Scanner input = new Scanner(System.in);
		int num;
		
		do {
			System.out.println(message);
			num = input.nextInt();
		}while(num <= 0);
		
		return num;
	}
	
	static int cardConv2(int num, char[] cardNum) {
		int numDigit = 0;
		String digitChar = "0123456789ABCDEF";
		while(num > 0) {  //num/2 != 0
			cardNum[numDigit++] = digitChar.charAt(num % 2);
			num = num/2;
		}
		return numDigit;
	}
	
	static int cardConv16(int num, char[] cardNum) {
		int numDigit = 0;
		String digitChar = "0123456789ABCDEF";
		while(num > 0) {  //num/2 != 0
			cardNum[numDigit++] = digitChar.charAt(num % 16);
			num = num/16;
		}
		return numDigit;
	}
	
	static int cardConv(int num, int N, char[] cardNum) {
		int numDigit = 0;
		String digitChar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		while(num > 0) {
			cardNum[numDigit++] = digitChar.charAt(num % N);
			num /= N;
		}
		
		return numDigit;
	}
	
	static void displayResult(char[] cardNum, int numDigit) {
		
		for(int i = numDigit-1; i >= 0; i-- ) {
			System.out.print(cardNum[i]);
		}System.out.println();
	}
}
