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

        int answer = 0;
        int time = 0; // 次数
        // 为什么0 ？ 例子  [1, 2, 3]  k = 1, nums[0] - 1 = 0 需要有一个0被contains到
        // [nums[i], 次数]
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // nums[i] - k 即 一定存在 nums[x] - nums[y] = k，即中间某几个加起来等于k
            if (map.containsKey(nums[i] - k)) {
                answer += map.get(nums[i] - k);
            }
            // 例子[1, 2, 2, 3]  没有增长的情况
            // 有的话再次刷到 + 1，没有就是1
            time = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], time);
        }
        return answer;
    }
}