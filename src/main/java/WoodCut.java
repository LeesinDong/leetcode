import sun.jvmstat.perfdata.monitor.PerfStringConstantMonitor;
import sun.security.util.Length;

import javax.swing.plaf.nimbus.State;

public class WoodCut {
    public static void main(String[] args) {
        int[] L = {232,124,456};
        System.out.println(new WoodCut().woodCut(L, 7));
    }

    public int woodCut(int[] wood, int k) {
        if (wood == null || wood.length == 0) {
            return -1;
        }

        int start = 0;
        int end = getMax(wood);
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (getPeices(wood, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (getPeices(wood, end) >= k) {
            return end;
        }

        if (getPeices(wood, start) >= k) {
            return start;
        }

        return -1;
    }

    private int getPeices(int[] wood, int length) {
        if (wood == null || wood.length == 0) {
            return -1;
        }

        int result = 0;
        for (int i : wood) {
            result += i / length;
        }
        return result;
    }

    private int getMax(int[] wood) {
        int l = wood[0];
        for (int i : wood) {
            if (l <= i) {
                l = i;
            }
        }
        return l;
    }


}
