import com.sun.org.apache.xml.internal.security.c14n.helper.C14nHelper;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nQueens {
    public static void main(String[] args) {
        List<List<String>> lists = new nQueens().slaveNQueueens(4);
        for (int i = 0; i < lists.size(); i++) {
            for (String s : lists.get(i)) {
                System.out.println(s);
            }
            System.out.println();
        }

    }

    public List<List<String>> slaveNQueueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return Collections.emptyList();
        }

        search(result, new ArrayList<>(), n);
        return result;
    }

    private void search(List<List<String>> result, ArrayList<Integer> col, int n) {
        if (col.size() == n) {
            result.add(chessBoard(col, n));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!invalid(col, colIndex)) {
                continue;
            }
            col.add(colIndex);
            search(result, col, n);
            col.remove(col.size() - 1);
        }
    }

    private boolean invalid(ArrayList<Integer> col, int colIndex) {
        int row = col.size();
        for (int rowIndex = 0; rowIndex < col.size(); rowIndex++) {
            if (col.get(rowIndex) == colIndex) {
                return false;
            }

            if (rowIndex - col.get(rowIndex) == row - colIndex) {
                return false;
            }

            if (rowIndex + col.get(rowIndex) == row + colIndex) {
                return false;
            }
        }
        return true;
    }

    private List<String> chessBoard(List<Integer> result, int n) {
        List<String> chessBoard = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(result.get(i) == j ? "Q" : ".");
            }
            chessBoard.add(sb.toString());
        }
        return chessBoard;
    }
}
