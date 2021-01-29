class Solution {
    public int[] sortArray(int[] nums) {
        //快排
        // sort(nums, 0, nums.length - 1);
        //归并
        // int[] temp = new int[array.length];
        // mergeSortImpl(array, 0, array.length - 1, temp);

        int[] swap = new int[nums.length];
        mergeSortImpl(nums,0,nums.length-1,swap);
        return nums;
    }

    //快排
    public  void sort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int pivote = arr[start];
        while (left <= right) {
            while (left <= right && arr[left] < pivote) {
                left++;
            }
            while (left <= right && arr[right] > pivote) {
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
    public static void mergeSortImpl(int[] arr, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSortImpl(arr, start, mid, temp);
        mergeSortImpl(arr, mid + 1, end, temp);
        merge(arr, start, mid, end, temp);
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int left = start;
        int index = start;
        int right = mid + 1;
        while (left <= mid && right <= end) {
            if (arr[left] <= arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= end) {
            temp[index++] = arr[right++];
        }
        for (index = start; index <= end; index++) {
            arr[index] = temp[index];
        }
    }
}
