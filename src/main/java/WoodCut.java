import sun.jvmstat.perfdata.monitor.PerfStringConstantMonitor;
import sun.security.util.Length;

public class WoodCut {
    public static void main(String[] args) {
        int[] wood = {232,124,456};
        System.out.println(WoodCut.getLength(wood, 7));
    }

    public static int getLength(int[] wood, int target) {
        if (wood == null || wood.length == 0) {
            return -1;
        }

        int start = 0;
        int end = getMax(wood);
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (getSize(wood, mid) == target) {
                return mid;
            } else if (getSize(wood, mid) < target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (getSize(wood, start) >= target) {
            return start;
        }

        if (getSize(wood, end) >= target) {
            return end;
        }

        return 0;
    }

    private static int  getMax(int[] wood) {
        int result = wood[0];

        for (int i = 0; i < wood.length; i++) {
            if (result < wood[i]) {
                result = wood[i];
            }
        }
        return result;
    }

    private static int getSize(int[] wood, int length) {
        int result = 0;

        for (int i = 0; i < wood.length; i++) {
            result += wood[i] / length;
        }
        return result;
    }
}
