package mySort;

public class QuickSort {

	public static void main(String[]args) {
		int [] testArr = {1,56,12,185,41,5,45,64,3,151,8,7,745,523,154,441};
		
		quickSort(testArr, 0, testArr.length-1);
		
		for(int i = 0; i < testArr.length; i++) {
			System.out.print(testArr[i] + " ");
		}
	}
	//int타입 배열과 그 배열의 시작끝값을 매개변수로 받아 quicksort방식으로 정렬하는 method
	static void quickSort(int[] dataList, int start, int end) {
		//start 값이 end값보다 크거나 같아지면 return 더이상 분할하지 못하는 가장 기본적인 상태
		if(start>=end) {return;}
		
		//partition method에 배열의 시작값과 끝값을 주고 기준값pivot이 정렬되어 들어갈 위치를 저장
		//pivot보다 작은값은 index값이 0~p-1까지 나열, 큰값은 p+1~end까지 나열
		int p = partition(dataList, start, end);
		
		//partition method를 통해 기준값 pivot은 배열에서 자기 위치에 정렬됨
		//start값에서 p-1 까지 divide, p+1값에서 end까지 divide해서 다시 각각 pivot을 partition method를 통해 위치를 찾고
		//모든 값이 자기 위치에 정렬될때까지 재귀호출
		quickSort(dataList, start, p-1);
		quickSort(dataList, p+1, end);
	}
	
	static int partition(int [] dataList, int start, int end) {
		//pivot값은 임의의 기준값 지금 partition method에서는 end index에 위치한 값으로 지정
		int pivot = dataList[end];
		//leftEnd는 현재 pivot값 보다 작은 요소들을 위치시키는 역할을 하고 마지막에는 pivot값이 들어갈 위치
		int leftEnd = start - 1;
		//start부터 end까지 배열을 탐색하면서 pivot값과 비교
		for(int i = start; i <= end; i++) {
			//dataList[i]가 pivot보다 작으면 leftEnd를 증가시키고 dataList[i]값과 교환하면서
			//pivot의 값을 기준으로 자기보다 작은값을 leftEnd를 따라 나열하고
			//결과적으로 pivot값보다 큰값은 swap이 이뤄지지 않으면서 pivot값보다 작은값은 왼쪽 큰값은 오른쪽에 나열됨
			if(dataList[i] < pivot) {
				swap(dataList, ++leftEnd, i);
			}
		}
		//pivot보다 작은값들을 leftEnd를 증가시켜가면서 왼쪽에 나열한 뒤에 마지막에 leftEnd + 1에 있는 값과 pivot을 swap하면서 pivot을 자기 위치에 정렬
		swap(dataList, leftEnd + 1, end);
		//pivot의 최종위치 반환
		return leftEnd + 1;
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
