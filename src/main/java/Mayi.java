import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leesin
 */
// 题目：启动n(n < 10)个线程往一个相同的Map中放入m(m > 1000)个元素
// 要求：保证最终map的size为m，并尽量考虑高性能。
public class Mayi {
    public Map genMap(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(i);
        }

        List<List<Integer>> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list1 = new ArrayList<>();
            segments.add(list1);
        }

        for (Integer integer : list) {
            segments.get(integer % n).add(integer);
        }

        ConcurrentHashMap<Integer, Integer> chm = new ConcurrentHashMap<>();
        for (int i = 0; i < n; i++) {
            int j = i;
            Thread t = new Thread(() -> {
                for (int value : segments.get(j)) {
                    chm.put(value, value);
                }
            });
        }
        return chm;
    }
}
