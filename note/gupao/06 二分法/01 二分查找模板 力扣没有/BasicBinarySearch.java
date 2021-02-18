package gupao;

public class BasicBinarySearch {
	public static void main(String[] args) {
		int[] num = {1,4,7,9,10,14,16,20,56,89};
		System.out.println(new BasicBinarySearch().getIndex(num, 5));
	}
	public int getIndex(int[] num, int target) {
		if (num == null || num.length == 0) {
			return -1;
		}
		int start = 0;
		// **************************注意end长度
		int end = num.length - 1;
		int mid;
		// 有时候是奇数有时候是偶数
		// 防止死循环出不来，可能错过去
		// start + 1 < end 的时候，其中有一个已经是end了 start, end 紧挨着
		while (start + 1 < end) {
			// (end - start) / 2 可能会越界
			// right - left > 0，以及left + (right - left) = right（遵循基本代数）。
			// 因此left + (right - left) / 2 <= right
			// (left + right) / 2。left + right >= right，并且由于我们不知道leftand的值right，因此该值很可能溢出
			// https://stackoverflow.com/questions/27167943/why-leftright-left-2-will-not-overflow
			mid = start + (end - start) / 2;
			if (num[mid] == target) {
				return mid;
			}
			if(num[mid] > target) { // 这里也可以 else if
				end = mid;
			} else {
				start = mid;
			}
		}
		if (num[start] == target) {
			return start;
		}
		if (num[end] == target) {
			return end;
		}
		return -1;
	}
}
