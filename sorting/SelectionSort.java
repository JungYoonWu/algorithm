package mysort;

public class SelectionSort {
	public static void main(String[] args) {
		int [] testArr = {1,56,12,185,41,5,45,64,3,151,8,7,745,523,154,441};
		
		selectSort(testArr);
		
		for(int i = 0; i < testArr.length; i++) {
			System.out.print(testArr[i] + " ");
		}
	}
	
	//파라미터로 받은 정수타입 배열을 선택정렬하는 method 
	static void selectSort(int[] dataList) {
		//last의 시작은 배열의 오른쪽 끝 length-1, last의 마지막은 1 
		//오른쪽 끝 index에 가장 큰 값들을 swap으로 넣으면서 정렬
		//index 0부터 last까지는 정렬안된 부분
		//정렬이 안된 부분에서 가장 큰 값을 가지고있는 index를 selectMax method를 통해 찾고 그 index가 last랑 다르다면
		//last에 있는 값과 maxIndex에 있는 값을 swap하고 last는 왼쪽으로 이동 last--
		//last가 1까지오면 selectMax method에서 초기화는 index0값 
		//last는 1 last에 있는 값이 0에 있는 값보다 크다면 swap이 필요없고 정렬완료
		//last에 있는 값이 0에 있는값보다 작다면 마지막 swap하고 정렬 완료
		for(int last = dataList.length-1; last >= 1; last--) {
			int maxIndex = selectMax(dataList, last);
			if(maxIndex != last) {
				swap(dataList, maxIndex, last);
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
	
	//dataList 에서 0~last 사이 값중에서 가장 큰 값을 찾아서 그 큰 값이 있는 index를 return하는 method
	static int selectMax(int[] dataList, int last) {
		//배열의 첫번째 index에 있는 값을 지역변수 max에 초기화, maxIndex 0
		int max = dataList[0];
		int maxIndex = 0;
		
		for(int i = 1; i <= last; i++) {
			if(dataList[i] > max) {
				max = dataList[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
