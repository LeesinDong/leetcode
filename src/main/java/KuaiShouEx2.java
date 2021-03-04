
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.time.chrono.IsoEra;
import java.util.*;

public class KuaiShouEx2 {
    public static void main(String[] args) {
        List<String> picAndVideoList = new ArrayList<>();
        picAndVideoList.add("v_0");
        picAndVideoList.add("v_1");
        picAndVideoList.add("v_2");
        picAndVideoList.add("p_3");
        picAndVideoList.add("p_4");
        picAndVideoList.add("p_5");
        picAndVideoList.add("v_6");
        picAndVideoList.add("p_7");
        picAndVideoList.add("v_8");
        picAndVideoList.add("v_9");
        // v_0
        // v_1
        // v_2
        // v_6
        // p_3
        // v_8
        // v_9

        List<String> result = getRecommendedList(picAndVideoList, 2);
        for (String word : result) {
            System.out.println(word);
        }
    }

    private static List<String> getRecommendedList(List<String> picAndVideoList, int k) {
        List<String> result = new ArrayList<>();
        if (picAndVideoList == null || picAndVideoList.size() == 0) {
            return result;
        }

        boolean firstPic = false;
        Queue<String> picQueue = new LinkedList<>();
        Queue<String> videoQueue = new LinkedList<>();
        int index = 0;
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
                videoQueue.offer(picAndVideoList.get(index));
            } else {
                picQueue.offer(picAndVideoList.get(index));
            }
            index++;
        }

        int currentIndex = result.size();
        while (!picQueue.isEmpty() && !videoQueue.isEmpty()) {
            if (currentIndex >= k) {
                result.add(picQueue.poll());
                currentIndex = 0;
            } else {
                result.add(videoQueue.poll());
                currentIndex++;
            }
        }

        while (!videoQueue.isEmpty()) {
            result.add(videoQueue.poll());
        }

        if (!picQueue.isEmpty() && currentIndex >= k) {
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