public class BasicBinarySearch {
    public static void main(String[] args) {
        int[] num = {1,4,7,9,10,14,16,20,56,89};
        System.out.println(getIndex(num, 5));
    }

    private static int getIndex(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }

        int start = 0;
        int end = num.length;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (start == num[mid]) {
            return start;
        }

        if (end == num[mid]) {
            return end;
        }

        return -1;
    }
}
