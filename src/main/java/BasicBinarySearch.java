import com.sun.org.apache.regexp.internal.REUtil;

import javax.naming.ldap.StartTlsRequest;

public class BasicBinarySearch {
    public static void main(String[] args) {
        int[] num = {1,4,7,9,10,14,16,20,56,89};
        System.out.println(sort(num, 89));
    }

    public static int sort(int[] num, int k) {
        int start = 0;
        int end = num.length - 1;
        int mid = 0;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (num[mid] == k) {
                return mid;
            } else if (num[mid] < k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (num[start] == k) {
            return start;
        }

        if (num[end] == k) {
            return end;
        }

        return -1;
    }
}
