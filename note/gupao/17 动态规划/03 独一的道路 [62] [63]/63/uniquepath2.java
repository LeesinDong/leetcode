    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            // 0 1 皆可
            return 1;
        }
        if (obstacleGrid[0] == null || obstacleGrid[0].length == 0) {
            return 1;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] step = new int[m][n];

        // 初始化1
        for (int i = 0; i < m; i++) {
            // ************************************obstacleGrid 而不是 result
            if (step[i][0] != 1) {
                result[i][0] = 1;
            } else {
                // 有一个石头，后面的都到不了，后面的都不设置了
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1) {
                step[0][j] = 1;
            } else {
                // 有一个石头，后面的都到不了，后面的都不设置了
                break;
            }
        }

        // 动归
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    step[i][j] = step[i - 1][j] + step[i][j - 1];
                } else {
                    // 有石头的，路径清零
                    step[i][j] = 0;
                }
            }
        }

        return step[m - 1][n - 1];
    }