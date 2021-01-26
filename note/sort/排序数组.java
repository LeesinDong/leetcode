package sort;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/12 0012 13:56
 * @modified By:
 */
public class 排序数组 {
    //快排
    public static void sort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //为什么一定要让pivot在外面？而不能在while里面arr[mid]？
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
            //为什么一定要让pivot在外面？
            //因为在这里互换了，如果数组是偶数位的，中间值在下次while的时候换了，中间值变了
            //所以不能在while中通过arr[mid]再次得到
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
        if (right > l) {
            sort(arr, l, right);
        }
    }

}
