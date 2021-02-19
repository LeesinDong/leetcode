class Solution {
    // 前缀和
    // 最终解法
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // nums{123}
        Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 1; i < nums.length; i++) {
        //     nums[i] += nums[i - 1];
        // }

        // sum{0123}，下面这种在for中需要i = 1 开始，或map.put(0, 1)要去掉，两个其中一个，
        // 因为不论nums[0]还是map put都有一个是0，且必须是一个，如果 i = 0，且map.put(0, 1)则会多加一次，一定要有一个0开头避免第一个就是结果
        // 因为sum[0] 在nums中是不存在的，所以不应该出现在结果中
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int answer = 0;
        //次数
        int time = 0;
        // 为什么0 ？ 例子  [1, 2, 3]  k = 1, nums[0] - 1 = 0 需要有一个0被contains到
        // [nums[i], 次数]
        // map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            // 这个if一定在上面，因为，
            // [1] k = 0 本应该结果0，但是结果2
            // {0, 1}
            // temp下  temp上
            // 第一次： 第一次
            // 0  1    re 0
            // re 1    0 1
            // nums[i] - k 即 一定存在 nums[x] - nums[y] = k，即中间某几个加起来等于
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

    //解法一
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
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                answer += map.get(nums[i] - k);
            }
            time = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], time);
        }
        return answer;
    }

    //解法二
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int answer = 0;
        int time = 0; // 次数
        map.put(0, 1);
        for (int i = 1; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                answer += map.get(nums[i] - k);
            }
            time = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], time);
        }
        return answer;
    }

    //解法三
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int answer = 0;
        int time = 0; // 次数
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - k)) {
                answer += map.get(nums[i] - k);
            }
            time = map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1;
            map.put(nums[i], time);
        }
        return answer;
    }

}