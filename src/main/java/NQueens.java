import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> lists = resolveNQueens(4);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    public static List<List<String>> resolveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> columns = new ArrayList<>();
        dfs(result, n, columns);
        return result;
    }

    private static void dfs(List<List<String>> result, int n, List<Integer> columns) {
        if (columns.size() == n) {
            result.add(drawChessBoard(columns));
        }

        for (int columnIndex = 0; columnIndex < n; columnIndex++) {
            if (!invalid(columns, columnIndex)) {
                continue;
            }

            columns.add(columnIndex);
            dfs(result, n, columns);
            columns.remove(columns.size() - 1);
        }
    }

    private static List<String> drawChessBoard(List<Integer> columns) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < columns.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < columns.size(); j++) {
                if (columns.get(i) == j) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            result.add(sb.toString());
        }
        return result;
    }

    private static boolean invalid(List<Integer> columns, int columnIndex) {
        int row = columns.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (columns.get(rowIndex) == columnIndex) {
                return false;
            }

            if (rowIndex - columns.get(rowIndex) == row - columnIndex) {
                return false;
            }

            if (rowIndex + columns.get(rowIndex) == row + columnIndex) {
                return false;
            }
        }

        return true;
    }
}