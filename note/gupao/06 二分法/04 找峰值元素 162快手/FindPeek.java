class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start + 1 < end) {
            mid = start + (end - start) / 2;
            // 为什么这里是< < 而不是 <= 因为下面的== 是已经到了peek顶峰处
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else {
                return mid;
            }
        }
        // 输出大的那个
        return nums[start] > nums[end] ? start : end;
    }
}