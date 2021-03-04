import com.sun.tools.javac.tree.JCTree;

import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        List<List<String>> result = nQueue(4);
        for (List<String> list : result) {
            for (String s : list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private static List<List<String>> nQueue(int i) {
        List<List<String>> result = new ArrayList<>();
        if (i == 0) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        dfs(result, list, i);
        return result;
    }

    private static void dfs(List<List<String>> result, List<Integer> list, int column) {
        if (list.size() == column) {
            result.add(drawChessBoard(list));
            return;
        }

        for (int columnIndex = 0; columnIndex < column; columnIndex++) {
            if (!invalid(list, columnIndex)) {
                continue;
            }

            list.add(columnIndex);
            dfs(result, list, column);
            list.remove(list.size() - 1);
        }
    }

    private static boolean invalid(List<Integer> list, int column) {
        int row = list.size();
        for (int rowIndex = 0; rowIndex < row; rowIndex++) {
            if (list.get(rowIndex) == column) {
                return false;
            }

            if (rowIndex - list.get(rowIndex) == row - column) {
                return false;
            }

            if (rowIndex + list.get(rowIndex) == row + column) {
                return false;
            }
        }
        return  true;
    }

    private static List<String> drawChessBoard(List<Integer> list) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                sb.append(list.get(i) == j ? "Q" : '.');
            }
            result.add(sb.toString());
        }
        return result;
    }
}
