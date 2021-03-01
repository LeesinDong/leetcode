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
            // 为什么不是 nums[mid] > nums[mid - 1]，因为mid要把mid -1 mid +1 包住，因为要找大的，所以mid - 1 mid + 1应该比mid大
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