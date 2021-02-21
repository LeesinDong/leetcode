class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // if (nums == null) {
        //     return result;
        // }
        if (nums == null || nums.length == 0) {
            // **************** 不能直接return result.add()
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> list = new ArrayList<>();
        dfs(result, nums, list);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }

            list.add(nums[i]);
            dfs(result, nums, list);
            //***************************remove 是list.size() -1 而不是 i，减一个而已
            list.remove(list.size() - 1);
        }
    }
}