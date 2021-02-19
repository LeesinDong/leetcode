class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        // 一行都没有或一行中一个都没有
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        int number = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // 同一个小岛内第一次bfs全为true，后面再!visited[i][j]都是false，所以不会进去
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // 第一次 [0][0] bfs的时候就已经把整个二维数组中的 1 都标记为了true，
                    // 后面其他点都是!visited，所以只会bfs一次

                    // 第一次bfs其实就是标记一次小岛，可达的全部标记，下次同一个小岛内的会跳过
                    // 所以每次bfs就是一个小岛
                    bfs(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }
    
    public void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        int[] kx ={1, -1, 0, 0};
        int[] ky ={0, 0, 1, -1};
        visited[i][j] = true;
        // 这里两个queue其实只是保存坐标 一个点 上下左右宽度搜索
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();
        xQueue.offer(i);
        yQueue.offer(j);
        // 为什么没有yQueue，因为这里存的是gird中的坐标，有x必有y
        while (!xQueue.isEmpty()) {
            // 图，不是一对多直线延伸，是错乱的关系，不需要像树一样，一行一行的poll
            int currentX = xQueue.poll();
            int currentY = yQueue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = currentX + kx[k];
                int newY = currentY + ky[k];
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY]) {
                    if (grid[newX][newY] == '1') {
                        xQueue.offer(newX);
                        yQueue.offer(newY);
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}