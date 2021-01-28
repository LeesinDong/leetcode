class Solution {
    public int[] sortArray(int[] nums) {
        //快排
        sort(nums, 0, nums.length - 1);
        //归并
        // int[] swap = new int[nums.length];
        // partAndMerge(nums,0,nums.length-1,swap);
        return nums;
    }

    //快排
    public  void sort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivot = arr[start];
        while (left <= right) {
            while (left <= right && arr[left] < pivot) {
                left++;
            }
            while (left <= right && arr[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        sort(arr, start, right);
        sort(arr, left, end);
    }

    //归并排序
    public static void partAndMerge(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            partAndMerge(arr, left, mid, temp);
            partAndMerge(arr, mid+1,right, temp);
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid+1;
        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <=arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }
        int leftTemp = left;
        t = 0;
        while (leftTemp <= right) {
            arr[leftTemp] = temp[t];
            leftTemp++;
            t++;
        }
    }
}
