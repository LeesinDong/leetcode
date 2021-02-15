package gupao;

import java.util.Stack;

public class ByteDanceEx1 {
	public static void main(String[] args) {
		// 28
		// int[] numbers = {5,2,3,4,1};
		int[] numbers = {6,7,5,2,3,4,1};
		// 36
		// int[] numbers = {6, 2 ,1};
		System.out.println(new ByteDanceEx1().getMax(numbers));
	}
	public int getMax(int[] numbers) {
		if (numbers == null || numbers.length == 0) {
			return 0;
		}
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		//求前缀和数组
		int[] sum = new int[numbers.length + 1];
		for (int i = 1; i <= numbers.length; i++) {
			sum[i] = sum[i - 1] + numbers[i - 1];
		}
		for(int i = 0; i < numbers.length; i++) {
			// 到了下一个最小值，所以遍历之前的最小值
			while (!stack.isEmpty() && numbers[i] < numbers[stack.peek()]) {
				// stack里面存的是下标
				int index = stack.pop();
				int left = i;
				int right = i;
				if (stack.isEmpty()) {
					left = 0;
				} else {
					left = index;
				}
				// 用 O（1）取到前缀和
				// left 最小会到第0个，因为1的时候，5已经出去了，所以到本次范围内的第0个 234 1 中的2，即栈中的0
				// 即前缀和会从后面一直往前全部求前缀和到0位
				// index是本次区间中最小值 234 中的 2

				// 6 7 5 2 3 4 1
				// 675本身比234中的大，之前已经弹出来了，234比1大 675一定比1大，所以弹出2，stack为空，left直接从675开始，因为结果只会更大
				// 1 1 5 2 3 4 1
				// 1 1 在栈底， 5 2 3 4 都比1大，所以在最后1进入前栈：1 1 5 2 3 4，1 不小于1 ，stack不会为空，所以left就到了5为止，再往前结果就变小了，因为两边都是最小的
				// 综上，为了取得中间最大的区间，然后从区间中取得最小值相乘
				max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
			}
			stack.push(i);
		}
		// 最后一个数字压进去没有出来，在这里进行计算
		while (!stack.isEmpty()) {
			int index = stack.pop();
			int left = numbers.length;
			int right = numbers.length;
			if (stack.isEmpty()) {
				left = 0;
			} else {
				left = index;
			}
			max = Math.max(max, numbers[index] * (sum[right] - sum[left]));
		}
		return max;
	}
}
