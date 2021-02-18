class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target) {
                end--;
            } else {
                // 因为结果是 + 1的
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            // 如果是多个solution，求个数
            //    else {
            //          result[0] = start + 1;
            //          result[1] = end + 1;
            //          end--;
            //          start++;
            //          count++;
            //     }
        }
        return result;
    }
}