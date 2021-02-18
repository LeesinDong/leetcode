
public class WoodCut {
    public static void main(String[] args) {
        int[] L = {232,124,456};
        System.out.println(new WoodCut().woodCut(L, 7));
    }

    public int woodCut(int[] woods, int k) {
        if (woods == null || woods.length == 0) {
            return -1;
        }

        int start = 0;
        int end = getMax(woods);
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (getPeices(woods, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getPeices(woods, end) >= k) {
            return end;
        }

        if (getPeices(woods, start) >= k) {
            return start;
        }

        return -1;
    }

    private int getPeices(int[] wood, int length) {
        int result = 0;
        for (int i : wood) {
            result += i / length;
        }
        return result;
    }

    private int getMax(int[] woods) {
        int max = 0;
        for (int w : woods) {
            if (w > max) {
                max = w;
            }
        }
        return max;
    }
}
