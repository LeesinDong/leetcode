package gupao;

public class SortEx {
	//merge Sort
	public static void mergeSort(int[] array) {
		int[] temp = new int[array.length];
		mergeSortImpl(array, 0, array.length - 1, temp);
	}
	public static void mergeSortImpl(int[] array, int start, int end, int[] temp) {
		if (start >= end) {
			return;
		}

		int mid = (start + end) / 2;
		mergeSortImpl(array, start, mid, temp);
		mergeSortImpl(array, mid + 1, end, temp);
		merge(array, start, mid, end, temp);
	}
	
	public static void merge(int[] array, int start, int mid, int end, int[] temp) {
		int left = start;
		int right = mid + 1;
		// **********************这里是start，不是0，这种在往回装的temp中浪费了index前面的，而不是从0开始的，先这么记住把
		int index = start;
		// ********************** left <= mid 是小于某个值作为条件
		while (left <= mid && right <= end) {
			if (array[left] < array[right]) {
				temp[index++] = array[left++];
			} else {
				temp[index++] = array[right++];
			}
		}
		while (left <= mid) {
			temp[index++] = array[left++];
		}
		while (right <= end) {
			temp[index++] = array[right++];
		}
		// ******************* <= !!!!
		for (index = start; index <= end; index++) {
			array[index] = temp[index];
		}
	}
}
