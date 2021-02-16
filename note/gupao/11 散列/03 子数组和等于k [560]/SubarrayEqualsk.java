class Solution {
    // 前缀和
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int ans = 0;
        int temp = 0;
        // 为什么0 ？ 例子  [1, 2, 3]  k = 1, nums[0] - 1 = 0 需要有一个0被contains到
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                ans += map.get(nums[i] - k);
            }
            // 例子[1, 2, 2, 3]  没有增长的情况
            temp = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], temp);
        }
        return ans;
    }
}