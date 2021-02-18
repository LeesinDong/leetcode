class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        //nlog(n)
        Arrays.sort(nums);
        int len = nums.length;
        // len - 2 ? left一开始i + 1,right 一开始 len - 1,所以少两次
        for (int i = 0; i < len - 2; i++) {
            // *************i > 0
            // 重复的值说明找过了，去重直接跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = len - 1;
            // *******************别丢了
            while(left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    left++;
                    right--;
                    result.add(list);
                    // **********************1.while 2. left< right 3. right + 1
                    // 这两步去重用的
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    // result.add(list);
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}