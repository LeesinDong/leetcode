import com.sun.prism.shader.Mask_TextureSuper_AlphaTest_Loader;

public class WoodCut {
    public static void main(String[] args) {
        int[] L = {232, 124, 456};
        System.out.println(new WoodCut().woodcut(L, 7));
        System.out.println("abc".charAt(0));
    }


    public int woodcut(int[] woods, int k) {
        if (woods == null || woods.length == 0) {
            return 0;
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
        if (getPeices(woods, start) >= k) {
            return start;
        }
        if (getPeices(woods, end) >= k) {
            return end;
        }
        return -1;
    }

    private int getPeices(int[] woods, int mid) {
        int result = 0;
        for (int i : woods) {
            result += i / mid;
        }
        return result;
    }

    private int getMax(int[] woods) {
        int max = woods[0];
        for (int i : woods) {
            if (i > max) {
                max = i;
            }
        }
        return max;

    }
}
