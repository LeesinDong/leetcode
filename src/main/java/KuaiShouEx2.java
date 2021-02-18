import com.sun.org.apache.bcel.internal.generic.F2I;
import com.sun.xml.internal.ws.util.ReadAllStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KuaiShouEx2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("v0");
        list.add("v1");
        list.add("v2");
        list.add("p3");
        list.add("p4");
        list.add("p5");
        list.add("v6");
        list.add("p7");
        list.add("v8");
        list.add("v9");

        List<String> result = getRecommendedList(list, 4);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static List<String> getRecommendedList(List<String> picAndVideoList, int interval) {
        if (picAndVideoList == null || picAndVideoList.size() == 0) {
            return null;
        }

        boolean firstPic = false;
        int index = 0;
        Queue<String> videoQueue = new LinkedList<>();
        Queue<String> picQueue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        while (!firstPic && index < picAndVideoList.size()) {
            if (isVideo(picAndVideoList.get(index))) {
                result.add(picAndVideoList.get(index));
                index++;
            } else {
                firstPic = true;
            }
        }

        while (index < picAndVideoList.size()) {
            if (isVideo(picAndVideoList.get(index))) {
                videoQueue.add(picAndVideoList.get(index));
            } else {
                picQueue.add(picAndVideoList.get(index));
            }
            index++;
        }

        int currentSize = result.size();
        while (!videoQueue.isEmpty() && !picQueue.isEmpty()) {
            if (currentSize >= interval) {
                result.add(picQueue.poll());
                currentSize = 0;
            } else {
                result.add(videoQueue.poll());
                currentSize++;
            }
        }

        while (!videoQueue.isEmpty()) {
            result.add(videoQueue.poll());
        }

        while (!picQueue.isEmpty() && currentSize >= interval) {
            result.add(picQueue.poll());
        }

        return result;
    }

    private static boolean isVideo(String s) {
        if (s.indexOf("v") != -1) {
            return true;
        } else {
            return false;
        }
    }
}