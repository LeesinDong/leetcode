import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        /**
         * .Q..
         * ...Q
         * Q...
         * ..Q.
         *
         * ..Q.
         * Q...
         * ...Q
         * .Q..
         */
        List<List<String>> chessboard = new NQueens().solveNQueens(4);
        for (List<String> list : chessboard) {
            // 一个list一个解决方案
            for (String s : list) {
                // 一个s是一行。
                System.out.println(s + " ");
            }
            System.out.println();
        }


    }

    // 和46基本一样
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> results = new ArrayList<>();
        if (n <= 0) {
            return results;
        }
        List<Integer> columns = new ArrayList<Integer>();
        dfs(results, columns, n);
        return results;
    }

    //columns.get(0,1).... 0,1 就是colIndex
    // 和46基本一样
    public void dfs(List<List<String>> results, List<Integer> columns, int n) {
        if (columns.size() == n) {
            // 一个drawChessboard(columns)是一种解法，有多种解法
            results.add(drawChessboard(columns));
            return;
        }

        // columnIndex是一行中的每一个
        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            // columns 之前加入的 多行[里面有一个皇后]  columnIndex 新的一行的第几列
            if (!isValid(columns, columnIndex)) {
                continue;
            }

            columns.add(columnIndex);
            dfs(results, columns, n);// 这里固定是n
            columns.remove(columns.size() - 1);// -1，search里面出来，去掉一层，删掉上面add进去的，避免到达return条件。
        }
    }

    private boolean isValid(List<Integer> columns, int columnIndex) {
        // row 目前已经到了第几行
        int row = columns.size();
        // 遍历colunms？因为即将选出的这个天选之子：前几行的 竖线、左右、右左斜线都不能沾边
        for (int rowIndex = 0; rowIndex < columns.size(); rowIndex++) {
            //同一竖线
            // columns.get(rowIndex) 第rowIndex行的皇后，即纵坐标
            // dfs中 1 上去 2 所以不会相等
            if (columns.get(rowIndex) == columnIndex) {
                return false;
            }
            //左到右斜线
            if (rowIndex - columns.get(rowIndex) == row - columnIndex) {
                return false;
            }
            //右到左斜线
            if (rowIndex + columns.get(rowIndex) == row + columnIndex) {
                return false;
            }
        }
        return true;
    }

    public List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < cols.size(); j++) {
                sb.append(j == cols.get(i) ? 'Q' : '.');
            }
            // sb一行
            chessboard.add(sb.toString());
        }
        return chessboard;
    }
}
