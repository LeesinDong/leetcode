//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 158 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//这个里面可以随便练习排序算法
class Solution {
    public int[] sortArray(int[] nums) {
        //快排
        // sort(nums, 0, nums.length - 1);
        //归并
        int[] swap = new int[nums.length];
        partAndMerge(nums,0,nums.length-1,swap);
        return nums;
    }

    //快排
    public static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            sort(arr, left, r);
        }
        if (l < right) {
            sort(arr, l, right);
        }
    }

    //归并排序
    public void partAndMerge(int[] arr, int left, int right, int[] swap) {
        if (left < right) {
            int mid = (left + right) / 2;
            partAndMerge(arr,left,mid,swap);
            partAndMerge(arr,mid+1,right,swap);
            merge(arr, left, mid, right, swap);
        }
    }
    public void merge(int[] arr,int left,int mid ,int right, int[] swap) {
        int i = left;
        int j = mid + 1;
        int t = 0;
        while (i <= mid && j <= right) {
            //这里<和<=都是可以的
            if (arr[i] < arr[j]) {
                swap[t] = arr[i];
                i++;
                t++;
            } else {
                swap[t] = arr[j];
                j++;
                t++;
            }
        }
        while (i <= mid) {
            swap[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            swap[t] = arr[j];
            j++;
            t++;
        }
        int tempLeft = left;
        t = 0;
        while (tempLeft <= right) {
            arr[tempLeft] = swap[t];
            tempLeft++;
            t++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
