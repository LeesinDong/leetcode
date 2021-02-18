import sun.nio.cs.ext.DoubleByte;

import java.beans.IndexedPropertyDescriptor;

public class BasicBinarySearch {
    public static void main(String[] args) {
        int[] num = {1,4,7,9,10,14,16,20,56,89};
        System.out.println(new BasicBinarySearch().getIndex(num, 89));
    }

    private int getIndex(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }


}
