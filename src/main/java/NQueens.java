import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
      List<List<String>> result = resolveNQueue(4);
        for (List<String> strings : result) {
            for (String s : strings) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private static List<List<String>> resolveNQueue(int i) {
        List<List<String>> result = new ArrayList<>();
        if (i <= 0) {
            result.add(new ArrayList<>());
            return result;
        }

        List<Integer> list = new ArrayList<>();
        dfs(result, list, i);
        return result;
    }

    private static void dfs(List<List<String>> result, List<Integer> columns, int k) {
        if (columns.size() == k) {
            result.add(drawChessBoard(columns));
            return;
        }

        for (int columnIndex = 0; columnIndex < k; columnIndex++) {
            if (!invalid(columns, columnIndex)) {
                continue;
            }

            columns.add(columnIndex);
            dfs(result, columns, k);
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