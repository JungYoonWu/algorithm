package mysort;

public class BubbleSort {
	public static void main(String[]args) {
		int [] testArr = {1,56,12,185,41,5,45,64,3,151,8,7,745,523,154,441};
		
		bubbleSort(testArr);
		
		for(int i = 0; i < testArr.length; i++) {
			System.out.print(testArr[i] + " ");
		}
	}
	//파라미터로 받은 정수타입 배열을 버블정렬하는 method 
	static void bubbleSort(int[] dataList) {
		//정렬된 가장 큰 수는 오른쪽에 배치
		//last값을 length-1에서 1까지 줄여나가면서 정렬
		//last값이 1까지 왔을때 마지막으로 0값과 비교후 정렬 완료
		for(int last = dataList.length-1; last >= 1; last--) {
			//i는 0부터 last까지 이동 여기서 index가 i, i+1인 연속된 위치에 있는 배열의 값을 비교후 
			//i에 있는값이 작으면 유지 아니라면 swap을통해 큰값을 오른쪽으로 계속 정렬해서 밀어냄
			for(int i = 0; i <= last-1; i++) {
				if(dataList[i] > dataList[i+1]) {
					swap(dataList, i, i+1);
				}
			}
		}
	}
	
	//파라미터로 int형 배열, 자리를 바꿀 배열의 index a, b를 받는 swap method
	static void swap(int[] dataList, int a, int b) {
		//swap할 배열의 두 index가 같다면 swap하지않고 return
		if(a == b) {return;}
		//swap용 임시변수 temp
		int temp;
		//temp에 dataList[a]값 저장
		temp = dataList[a];
		//dataList[a]값을 temp에 저장해 뒀으니 dataList[a]에 dataList[b]저장
		dataList[a] = dataList[b];
		//dataList[b]값은 dataList[a]에 저장해 뒀으니 dataList[b]에 temp에 저장한 dataList[a]값 저장
		dataList[b] = temp;
	}
}
