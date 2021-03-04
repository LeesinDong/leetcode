import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author leesin
 */
// 题目：启动n(n < 10)个线程往一个相同的Map中放入m(m > 1000)个元素
// 要求：保证最终map的size为m，并尽量考虑高性能。

// 答案：1 模仿CHM实现 2 直接用CHM
public class Mayi {
    public Map genMap(int n, int m) {
        // 保存1000个元素
        List<Integer> values = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            values.add(i);
        }
        // 初始化容器
        List<List<Integer>> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            segments.add(list);
        }

        // 分成n段，一段处理一部分，hash取模放入元素
        for (Integer value : values) {
            segments.get(value % n).add(value);
        }

        // 多线程进行处理
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
