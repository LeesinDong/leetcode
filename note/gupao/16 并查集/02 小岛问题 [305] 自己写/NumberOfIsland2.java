class UnionFind {
    private Map<Integer, Integer> father = new HashMap<>();

    public UnionFind(int row, int column) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int id = convertId(i, j, column);
                father.put(id, id);
            }
        }
    }

    public int find(int x) {
        int parent = father.get(x);
        // 有父亲的意思，就是不是一个点的意思，因为构造函数默认，就是key value是一个点
        // ***************************get(parent)
        while (parent != father.get(parent)) {
            parent = father.get(parent);
        }

        // 有父亲，就缓存一下，下次能直接找到
        int temp = -1;
        int fa = father.get(x);
        while (fa != father.get(fa)) {
            temp = father.get(fa);
            // father.put(fa, parent); father.put(fa, temp); 皆可 ，为了将fa直接通道最上面的parent点(上面while已经到了最上面顶点)
            father.put(fa, parent);

            fa = temp;
        }
        return parent;
    }

    public void union(int x, int y) {
        int parent_x = father.get(x);
        int parent_y = father.get(y);
        if (parent_x != parent_y) {
            father.put(parent_x, parent_y);
        }
    }

    // 我认为这里应该是 column，因为这里其实是要一个最后的数字：行*每行多少+最后一行第几个。  不过为一个确定一个数字就行row也可以
    // 原来：public int convertedId(int x, int y, int row) {
    // ******************************这里是column 不是row，因为x行*一样几个，再加上最后一行的y个
    public int convertId(int x, int y, int column) {
        return x * column + y;
    }
}

class Solution {
    // 本质：本身是一个小岛，但是并查集里面没有，就往并查集里面放
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0] == null || positions[0].length == 0) {
            return result;
        }

        int[] kx = {1, -1, 0, 0};
        int[] ky = {0, 0, 1, -1};
        boolean[][] isLand = new boolean[m][n];
        UnionFind unionFind = new UnionFind(m, n);
        int count = 0;

        for (int u = 0; u < positions.length; u++) {
            int[] row = positions[u];
            int x = row[0];
            int y = row[1];
            // 如果是true，就是之前已经处理过了，处理过的，就不对count进行修改了，因为isLand里面这段里面的本质就是修改count
            if (!isLand[x][y]) {
                isLand[x][y] = true;
                int id = unionFind.convertId(x, y, n);
                count++;
                for (int k = 0; k < 4; k++) {
                    int currentX = x + kx[k];
                    int currentY = y + ky[k];
                    // island[current_x][current_y] 上下左右，true则和自己有连接，是一个小岛，之前认亲过了。
                    if (currentX >= 0 && currentX < m && currentY >= 0 && currentY < n
                            && isLand[currentX][currentY]) {// 本身是一个小岛的意思
                        int nId = unionFind.convertId(currentX, currentY, n);
                        int father = unionFind.find(id);
                        int nFather = unionFind.find(nId);
                        // 父亲不相等说明是不可达的，没有相认，现在是当做独立的小岛在做这个问题，需要相认，说明需要将两个小岛合并了。
                        // 即：上下左右点和xy 本身是一个小岛，但是并查集里面没有记录，所以并查集合并下。
                        if (father != nFather) {
                            count--;
                            unionFind.union(father, nFather);
                        }
                        // father 相等说明，之前连接过，之前已经验证过了，之前已经知道是一个小岛
                        // 即：和原来是一个点，(原来point(1,2), 现在又输入一个点(1,2))；
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}