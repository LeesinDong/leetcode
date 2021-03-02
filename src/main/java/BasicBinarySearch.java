import com.sun.org.apache.regexp.internal.REUtil;

import javax.naming.ldap.StartTlsRequest;


public class BasicBinarySearch {
    public static void main(String[] args) {
        int[] num = {1,4,7,9,10,14,16,20,56,89};
        System.out.println(sort(num, 89));
    }

    private static int sort(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
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
