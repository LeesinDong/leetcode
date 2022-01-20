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
                // ******************* 必须是>= 一般条件里面都是加上=的，因为尽量把所有的都囊括进来，避免少了一些可能
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


    // if (nums == null || nums.length == 0) {
    //             return -1;
    //         }
    //
    //         int left = 0;
    //         int right = nums.length - 1;
    //         while (left <= right) {
    //             int mid = left + (right - left) / 2;
    //             if (nums[mid] == target) {
    //                 return mid;
    //             } else if (nums[mid] >= nums[left]) {
    //                 if (target <= nums[mid] && nums[left] <= target) {
    //                     right = mid - 1;
    //                 } else {
    //                     left = mid + 1;
    //                 }
    //             } else if (nums[mid] < nums[left]) {
    //                 if (target >= nums[mid] && target <= nums[right]) {
    //                     left = mid + 1;
    //                 } else {
    //                     right = mid - 1;
    //                 }
    //             }
    //         }
    //         return -1;
}