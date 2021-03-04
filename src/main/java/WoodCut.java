import com.sun.prism.shader.Mask_TextureSuper_AlphaTest_Loader;

import java.security.Key;

public class WoodCut {
    // 结果 114
    public static void main(String[] args) {
        int[] L = {232,124,456};
        System.out.println(woodcut(L, 7));
    }

    private static int woodcut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return -1;
        }

        int start = 0;
        int end = getMax(L);
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (getPieces(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getPieces(L, start) >= k) {
            return start;
        }

        if (getPieces(L, end) >= k) {
            return end;
        }
        return -1;
    }

    private static int getPieces(int[] l, int length) {
        int result = 0;
        for (int i : l) {
            result += i / length;
        }
        return result;
    }

    private static int getMax(int[] L) {
        int max = 0;
        for (int i : L) {
            max = Math.max(max, i);
        }
        return max;
    }
}
