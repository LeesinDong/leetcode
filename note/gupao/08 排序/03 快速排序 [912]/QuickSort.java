package gupao;

public class SortEx {

	public static void quickSort(int[] array) {
		sort(array, 0, array.length - 1);
	}
	
	public static void sort(int[] array, int start, int end) {
		// 避免死循环
		// >= ? 下面加入left到了end-1 ，一次循环会left++两次就会导致>end
		// start >= end 说明已经排完了， left >= end 或 start >= right 说明已经排的超了。
		if (start >= end) {
			return;
		}

		// start 和 (start + end) / 2 一样的结果，都不只真正的中间值
		// pivot应该在while外面计算出来，因为下面大while每次循环会 将left[如果pivot和left重合]、right所指进行交换，即array里面东西都变了
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
