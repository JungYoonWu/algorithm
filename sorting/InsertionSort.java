package mysort;

public class InsertionSort {
	public static void main(String[]args) {
		int [] testArr = {1,56,12,185,41,5,45,64,3,151,8,7,745,523,154,441};
		
		insertSort(testArr);
		
		for(int i = 0; i < testArr.length; i++) {
			System.out.print(testArr[i] + " ");
		}
	}
	//파라미터로 받은 정수타입 배열을 삽입정렬하는 method 
	static void insertSort(int[] dataList) {
		//배열의 첫번째 요소를 정렬된 상태로 가정하고 index 1 부터 탐색
		for(int i = 1; i < dataList.length; i++) {
			//dataList[i]와 dataList[i-1] (시작하는 비교값은 i가 1부터 시작하니까 dataList[1] dataList[0]값비교)
			//findLessFromLast method에 
			//dataList의 dataList[i]값이 0부터 i-1사이의 값중에작은 값이 있는지 설정된 범위에서 오른쪽에서 왼쪽으로 탐색해서 삽입할 위치를 loc에 저장
			int loc = findLessFromLast(dataList, dataList[i], i-1);
			//loc에 저장된 값(index)이 i-1과 같다면 이미 정렬된 부분에서 dataList[i]값보다 작은값이 없기때문에 값을 정렬부분에 삽입하지 않고 다음으로 넘어감
			//loc에 저장된 값(index)이 i-1과 같지 않다면 dataList[i]값을 loc+1부분에 삽입하고 기존에 loc+1부터 i까지의 값들을 오른쪽으로 덮어씀
			if(loc != i-1) {
				insertData(dataList, loc+1, i);
			}
		}
	}
	
	//dataList에 값을 삽입하는 method 
	static void insertData(int[] dataList, int target, int source) {
		//index가 source위치에 있는 값을 임시변수 temp에 저장
		int temp = dataList[source];
		//source값을 임시변수에 저장한 다음 index target부터 source까지의 값들을 오른쪽으로 한칸씩 덮어쓰면서 이동
		for(int i = source; i > target; i--) {
			dataList[i] = dataList[i - 1];
		}
		//index target에 처음에 저장한 source값이 저장된 temp값을 이용해 저장
		dataList[target] = temp;
	}
	
	//dataList에서 data보다 작거나 같은 값을 가지는 0~last사이의 위치중에서 가장 오른쪽에 있는 index값을 찾는 method
	static int findLessFromLast(int[] dataList, int data, int last) {
		//last부터 0까지 역순으로 배열탐색
		for(int i = last; i >= 0; i--) {
			//dataList[i]값이 data보다 작거나 같은 i를 반환
			if(dataList[i] <= data) {return i;}
		}
		//for문으로 탐색이 완료되면 dataList의 0~last까지 data보다 작거나 같은 값이 없다는 뜻 -1 return
		return -1;
	}
}
