class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        // nums.length - k 因为是从小大大排序
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }
    
    public int partition(int[] nums, int start, int end, int k) {
        if (start >= end) {
            // 这里说明已经排完了 left 到了 end||后  或 right到了 start||前 了，直接返回topk即可
            return nums[k];
        }

        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        while (left <= right) {
            while(left <= right && nums[left] < pivot) {
                left++;
            }
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }

        // 排完了
        return nums[k];
    }
}