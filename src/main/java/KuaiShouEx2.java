
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

        List<String> result = new KuaiShouEx2().getRecommendedList(picAndVideoList, 2);
        for (String string : result) {
            System.out.println(string);
        }
    }

    private List<String> getRecommendedList(List<String> picAndVideoList, int i) {
        if (picAndVideoList == null || picAndVideoList.size() == 0) {
            return Collections.emptyList();
        }

        List<String> result = new ArrayList<>();
        Queue<String> videoQueue = new LinkedList<>();
        Queue<String> picQueue = new LinkedList<>();
        int index = 0;
        boolean firstPic = false;
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

        int currentSize = result.size();
        while (!picQueue.isEmpty() && !videoQueue.isEmpty()) {
            if (currentSize >= i) {
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

        if (!picQueue.isEmpty() && currentSize >= i) {
            result.add(picQueue.poll());
        }

        return result;
    }

    private boolean isVideo(String s) {
        if (s.indexOf("v") != -1) {
            return true;
        } else {
            return false;
        }
    }
}
