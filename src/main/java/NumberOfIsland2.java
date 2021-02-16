import com.sun.deploy.ui.FancyButton;
import com.sun.javaws.Cache6UpgradeHelper;
import com.sun.xml.internal.bind.v2.model.core.ID;
import javafx.scene.web.WebHistory;

import java.awt.*;
import java.io.PushbackInputStream;
import java.security.AuthProvider;
import java.util.*;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

class Point {
    int x;
    int y;
    Point() {
            x = 0;
            y = 0;
        }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class NumberOfIsland2 {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        Point[] operators = new Point[4];
        operators[0] = new Point(1, 1);
        operators[1] = new Point(0, 1);
        operators[2] = new Point(3, 3);
        operators[3] = new Point(3, 4);
        List<Integer> integers = new NumberOfIsland2().numsIsLand2(m, n, operators);
        integers.forEach(System.out::println);
    }

    class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();

        public UnionFind(int row, int column) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    int id = convertedId(i, j, column);
                    father.put(id, id);
                }
            }
        }

        public int find(int x) {
            int parent = father.get(x);
            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }

            int temp = -1;
            int fa = father.get(x);
            while (fa != father.get(fa)) {
                temp = father.get(fa);
                father.put(fa, temp);
                fa = temp;
            }
            return parent;
        }

        public void union(int x, int y) {
            int findX = father.get(x);
            int findY = father.get(y);
            if (findX != findY) {
                father.put(findX, findY);
            }
        }

        public int convertedId(int x, int y, int column) {
            return x * column + y;
        }
    }

    public List<Integer> numsIsLand2(int m, int n, Point[] operators) {
        if (operators == null || operators.length == 0) {
            return Collections.emptyList();
        }

        List<Integer> result = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int count = 0;
        UnionFind unionFind = new UnionFind(m, n);
        boolean[][] isLand = new boolean[m][n];
        for (Point operator : operators) {
            int x = operator.x;
            int y = operator.y;
            if (!isLand[x][y]) {
                count++;
                isLand[x][y] = true;
                int id = unionFind.convertedId(x, y, n);
                for (int i = 0; i < 4; i++) {
                    int currentX = x + dx[i];
                    int currentY = y + dy[i];
                    if (currentX >= 0 && currentX < m && currentY >= 0 && currentY < n && isLand[currentX][currentY]) {
                        int nid = unionFind.convertedId(currentX, currentY, n);
                        int father = unionFind.find(id);
                        int nFather = unionFind.find(nid);
                        if (father != nFather) {
                            count--;
                            unionFind.union(father, nFather);
                        }
                    }
                }
                result.add(count);
            }
        }
        return result;
    }
}