import java.util.Stack;

public class MaximumRange {
	public static void main(String[] args) {
		int[] nums = {5, 2, 3 , 4, 1};
		System.out.println(new MaximumRange().getMax(nums, 4));
	}

	private int getMax(int[] nums, int k) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		Stack<Integer> stack = new Stack<>();
		// stack.push(0);
		int[] sum = new int[nums.length + 1];
		for (int i = 1; i < sum.length; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		int max = 0;

		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
				int index = stack.pop();
				int left  = i;
				int right = i;
				if (stack.isEmpty()) {
					left = 0;
				} else {
					left = index;
				}
				max = Math.max(max, nums[index] * (sum[right] - sum[left]));
			}
			stack.push(i);
		}

		while (!stack.isEmpty()) {
			int index = stack.pop();
			int left  = nums.length;
			int right = nums.length;
			if (stack.isEmpty()) {
				left = 0;
			} else {
				left = index;
			}
			max = Math.max(max, nums[index] * (sum[right] - sum[left]));
		}

		return max;

	}


}