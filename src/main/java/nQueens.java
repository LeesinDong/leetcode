import com.sun.org.apache.regexp.internal.REUtil;
import com.sun.org.apache.xml.internal.security.c14n.helper.C14nHelper;

import javax.xml.transform.Result;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class nQueens {
    public static void main(String[] args) {
        List<List<String>> result = new nQueens().resovleNueens(4);
        for (int i = 0; i < result.size(); i++) {
            for (String s : result.get(i)) {
                System.out.println(s);
            }
            System.out.println();
        }

    }

    public List<List<String>> resovleNueens(int n) {
        if (n <= 0) {
            List<List<String>> result = new ArrayList<>();
            result.add(Collections.emptyList());
            return result;
            // return Collections.emptyList();
        }

        List<List<String>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        resolve(result, list, n);
        return result;
    }

    private void resolve(List<List<String>> result, List<Integer> rows, int n) {
        if (rows.size() == n) {
            result.add(drawChessBoard(rows));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!inValid(rows, colIndex)) {
                continue;
            }

            rows.add(colIndex);
            resolve(result, rows, n);
            rows.remove(rows.size() - 1);
        }
    }

    private  boolean inValid(List<Integer> rows, int colIndex) {
        int row = rows.size();
        for (int rowIndex = 0; rowIndex < rows.size(); rowIndex++) {
            if (rows.get(rowIndex) == colIndex) {
                return false;
            }

            if (rowIndex + rows.get(rowIndex) == row + colIndex) {
                return false;
            }

            if (rowIndex - rows.get(rowIndex) == row - colIndex) {
                return false;
            }
        }
        return true;
    }

    private List<String> drawChessBoard(List<Integer> rows) {
        if (rows == null || rows.size() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < rows.size(); j++) {
                sb.append(rows.get(i) == j ? "Q" : ".");
            }
            result.add(sb.toString());
        }
        return result;
    }



}
