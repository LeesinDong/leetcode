class Solution {
    public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 就改了这里
            if (nums[mid] > nums[start]) {
                // *******************target 不是nums[target]
                // *******************每次都是两端和target比较
                // *******************必须是>=
                if (target <= nums[mid] && nums[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
	}
}