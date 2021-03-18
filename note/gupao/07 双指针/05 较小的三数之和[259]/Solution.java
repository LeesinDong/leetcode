class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] < target) {
                    // i不变，left right 分别从左右往中间移动，这段距离都是 < target的
                    sum += right - left;
                    // 找到了一个结果，left++找下个结果
                    left++;
                } else {
                    // 不够小，right--缩小范围
                    right--;
                }
            }
        }
        return sum;
    }
}