package mySort;

public class MergeSort {

	public static void main(String[]args) {
		int [] testArr = {1,56,12,185,41,5,45,64,3,151,8,7,745,523,154,441};
		
		mergeSort(testArr, 0, testArr.length-1);
		
		for(int i = 0; i < testArr.length; i++) {
			System.out.print(testArr[i] + " ");
		}
	}
	//int타입 배열과 배열의 왼쪽index값, 오른쪽 index값 (초기값은 각각 0, length-1)을 매개변수로 받아서 병합정렬하는 method
	static void mergeSort(int[] dataList, int start, int end) {
		//start값이 end값보다 크거나 같은경우는 병합할 배열의 크기가 1이하인 경우이므로 return
		if(start >= end) {return;}
		//병합하기 전 정렬하는 과정에서 start값과 end값의 중간값 mid로 배열을 나누고
		//start~mid, mid+1~end값에서 다시 mergeSort를 재귀호출
		//재귀호출되어서 작게 나누어진 배열을 merge method 에서 병합하면서 정렬
		int mid = (start + end) / 2;
		mergeSort(dataList, start, mid);
		mergeSort(dataList, mid+1, end);
		merge(dataList, start, mid, end);
	}
	
	//배열을 정렬하고 병합하는 method
	static void merge(int[] dataList, int start, int mid, int end) {
		//병합 결과를 저장할 임시 배열 생성 임시배열은 병합할 하위 배열의 모든 요소를 담아야 하기 때문에 end - start + 1
		//ex) 하위 배열이 각각 {1,2,3,4} {5,6,7,8} 과 같은 경우에 tmepList에 8개의 배열요소를 다 담아야 하는데
		//이때 두개의 하위배열은 start = 0, mid = 3, end = 7 이고 
		//각각 idx 0~3까지가 start~mid까지 나눠진 배열, 4~7까지가 mid+1에서 end까지 나눠진 배열이므로
		//모든 요소를 포함시길 tempList의 크기는 8이여야 하는데 이 값은 7-0+1 과 같다 이 값을 대표값으로 나타내면 end - start + 1이라고 할 수 있다.
		int[] tempList = new int [end - start + 1];
		//i값은 start부터 나눠진 배열에서 index값 역할, j값은 mid+1부터 나눠진 배열에서 index값 열할, k값은 tempList에서 index값 열할
		int i = start, j = mid + 1, k = 0;
		
		//i값이 왼쪽하위배열의 끝값인 mid값보다 작거나 같고 동시에 j값이 오른쪽하위배열의 끝값인 end값보다 작거나 같은경우
		//dataList[i]값과 dataList[j]값을 비교해서 작은값을 tempList[k]값에 저장한 후 저장된 값의 index를 증가
		//&&연산을 사용했기 때문에 while문의 조건탐색이 끝났다면 i값이 mid보다 커졌거나 j값이 end보다 커지면 반복을 멈추는데 하나만 만족하지 않아도 반복문이 멈추기때문에
		//이후에 남아있는 부분을 처리해야함
		while(i <= mid && j <= end) {
			if(dataList[i] <= dataList[j]) {
				tempList[k++] = dataList[i++];
			}else {
				tempList[k++] = dataList[j++];
			}
		}
		
		//위의 while문의 조건에서 j<=end조건이 불만족된 경우 i값이 아직 mid까지 도달하지 못한 상태일 수 있어서 그부분 check
		while(i <= mid) {
			tempList[k++] = dataList[i++];
		}
		//위의 while문의 조건에서 i<=mid조건이 불만족된 경우 j값이 아직 end까지 도달하지 못한 상태일 수 있어서 그부분 check
		while(j <= end) {
			tempList[k++] = dataList[j++];
		}
		
		//for(int i2 = start, k2 = 0; k2 < tempList.length; i2++,k2++) {
		//	dataList[i2] = tempList[k2];
		//}
		
		//merge method가 매개변수로 받은 start값부터 tempList에 담고있는 요소들을 정렬된 상태로 덮어쓰는 작업
		for(int idx = 0; idx < tempList.length; idx++) {
			dataList[start + idx] = tempList[idx];
		}
	}
}
