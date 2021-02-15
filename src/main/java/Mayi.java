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
        List<Integer> values = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            values.add(i);
        }

        List<List<Integer>> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            segments.add(list);
        }

        for (Integer value : values) {
            segments.get(value % n).add(value);
        }

        Map<Integer, Integer> map = new ConcurrentHashMap<>(m);
        for (int i = 0; i < n; i++) {
            int j = i;
            Thread t = new Thread(() -> {
                for (Integer value : segments.get(j)) {
                    map.put(value, value);
                }
            });
            t.start();
        }
        return map;
    }
}
