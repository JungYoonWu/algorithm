	package chapter02;
	
	import java.util.Scanner;
	
	public class PrimeNumber {
	
		public static void main(String[] args) {
			Scanner input = new Scanner(System.in);
			//배열에 안쓰고 입력받은 값을 n이라고 하면 2~n-1까지 나눴을때 나머지가 0이 되는 경우가 없으면 소수다 굳이 배열에 값을 다 집어넣을 필요 없음
			int num;
			int[] primeArr = new int[50];
			int numPrime = 0;				//소수가 입력될 배열의 index값을 표시한 변수
			
			for(num = 2; num <= 50; num++) {
				if(isPrimeNumber(num, primeArr, numPrime)) {
					primeArr[numPrime++] = num;		
					System.out.print(num + " ");
				}
			}
			
		}
		
		static boolean isPrimeNumber(int num) {
			for( int i = 2; i <= num-1; i++) {
				if(num % i == 0) {
					return false;
				}
			}return true;
		}
		
		static boolean isPrimeNumber(int num, int[] primeArr, int numPrime) {
			for( int i = 0; i <= numPrime-1; i++) {
				if(num % primeArr[i] == 0) {
					return false;
				}
			}return true;
		}
	
	}
