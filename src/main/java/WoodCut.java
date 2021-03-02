import com.sun.prism.shader.Mask_TextureSuper_AlphaTest_Loader;

import java.security.Key;

public class WoodCut {
    // 结果 114
    public static void main(String[] args) {
        int[] L = {232,124,456};
        System.out.println(woodcut(L, 7));
    }

    public static int woodcut(int[] L, int k) {
        int start = 0;
        int end = getMax(L);
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (getPieces(mid, L) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getPieces(start, L) >= k) {
            return start;
        }

        if (getPieces(end, L) >= k) {
            return end;
        }
        return -1;
    }

    private static int getPieces(int length, int[] L) {
        int result = 0;
        for (int i : L) {
            result += i / length;
        }
        return result;
    }

    private static int getMax(int[] l) {
        int max = 0;
        for (int i : l) {
            max = Math.max(max, i);
        }
        return max;
    }
}
