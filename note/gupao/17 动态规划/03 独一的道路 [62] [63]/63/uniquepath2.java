    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 1;
        }
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 1;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];

        // 初始化1
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1) {
                result[i][0] = 1;
            } else {
                // 有一个石头，后面的都到不了，后面的都不设置了
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1) {
                result[0][j] = 1;
            } else {
                // 有一个石头，后面的都到不了，后面的都不设置了
                break;
            }
        }

        // 动归
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = result[i - 1][j] + result[i][j - 1];
                } else {
                    // 有石头的，路径清零
                    result[i][j] = 0;
                }
            }
        }

        return result[m - 1][n - 1];
    }