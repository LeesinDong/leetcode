package gupao;

public class SortEx {
	
	public static void main(String[] args) {
		int[] array = new int[1000000];
		
		// bubble Sort 
		long start1 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			bubbleSort(array);
		}
		long end1 = System.currentTimeMillis();	
		System.out.println("Bubble Sort->");
		System.out.println(end1 - start1);
		//insert Sort
		long start2 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			insertSort(array);
		}
		long end2 = System.currentTimeMillis();	
		System.out.println("Insert Sort->");
		System.out.println(end2 - start2);
		//select sort
		long start3 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			selectSort(array);
		}
		long end3 = System.currentTimeMillis();	
		System.out.println("Select Sort->");
		System.out.println(end3 - start3);
		
		//quick sort
		long start4 = System.currentTimeMillis();
		for (int k = 0; k < 10; k++) {
			for (int j = 0; j < array.length; j++) {
				array[j] =(int)(Math.random() * 10000);
			}
			quickSort(array);
		}
		long end4 = System.currentTimeMillis();	
		System.out.println("quick Sort->");
		System.out.println(end4 - start4);
	}
	public static void bubbleSort(int[] array) {
		int length = array.length;
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < length; j++) {
				if (array[j - 1] > array[j]) {
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	
	public static void insertSort(int[] array) {
		int insertNode;
		int j;
		for (int i = 1; i < array.length; i++) {
			insertNode = array[i];
			j = i - 1;
			while(j >= 0 && insertNode < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = insertNode;
		}
	}
	
	public static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int pos = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[pos] > array[j]) {
					pos = j;
				}
			}
			if (pos != i) {
				int temp = array[i];
				array[i] = array[pos];
				array[pos] = temp;
			}
		}
	}
	public static void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}
	
	public static void sort(int[] array, int start, int end) {
		// 避免死循环
		// >= ? 下面加入left到了end-1 ，一次循环会left++两次就会导致>end
		// start >= end 说明已经排完了， left >= end 或 start >= right 说明已经拍的超了。
		if (start >= end) {
			return;
		}

		// start 和 (start + end) / 2 一样的结果，都不只真正的中间值
		// pivot应该在while外面计算出来，因为下面大while每次循环会 将left[如果pivot和left重合]、right所指进行交换，
		// 会将pivot的值动态改变，下次就变了
		int pivot = array[start];
		int left = start;
		int right = end;
		// <= ? 只有>错开的时候才会出去，说明分成两份了，否则left right一起没分开
		while (left <= right) {
			// 1 找到左边第一个 >= pivot 的
			while (left <= right && array[left] < pivot) {
				left++;
			}
			// 2 找到右边第一个 <= pivot 的
			while (left <= right && array[right] > pivot) {
				right--;
			}
			// 3 交换 [左边第一个比pivot大的] [右边第一个比pivot小的]
			if (left <= right) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				// 交换完了进行移动，开始下一轮
				left++;
				right--;
			}
		}
		// 4 错位之后分成了两个，然后递归
		sort(array, start, right);
		sort(array, left, end);
	}
}
