class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int total = 0;
        for (int k = S.length - 1; k >= 2; k--) {
            int start = 0;
            // *************这里一定写成k - 1
            int end = k - 1;
            while (start < end) {
                if (nums[start] + nums[end] > nums[k]) {
                    // 最大的为k的时候，end - start 中间的都符合，start + (end - start) 中间的都是比k大的
                    total += (end - start);
                    end --;
                } else {
                    start++;
                }
            }
        }
        return total;
    }
}