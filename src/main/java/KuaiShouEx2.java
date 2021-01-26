import java.util.*;

public class KuaiShouEx2 {
    public static void main(String[] arrayList) {
        ArrayList<String> list = new ArrayList<>();
        list.add("v_0");
        list.add("v_1");
        list.add("v_2");
        list.add("p_3");
        list.add("p_4");
        list.add("p_5");
        list.add("v_6");
        list.add("p_7");
        list.add("v_8");
        list.add("v_9");

        List recommendList = getRecommendList(list, 2);
        recommendList.forEach(i -> System.out.println(i.toString()));

    }

    private static List<String> getRecommendList(ArrayList<String> picAndPicList, int interval) {
        if(picAndPicList.isEmpty() || interval == 0){
            return Collections.emptyList();
        }

        Boolean isFirstPic = false;
        // 找到第一个图片
        int currentIndex = 0;
        List<String> result = new ArrayList<>();
        while (!isFirstPic) {
            if (isVideo(picAndPicList.get(currentIndex))) {
                result.add(picAndPicList.get(currentIndex));
                currentIndex++;
            } else {
                isFirstPic = true;
            }
        }

        // 放入queue
        Queue<String> videoQueue = new LinkedList<>();
        Queue<String> picQueue = new LinkedList<>();
        for (int i = currentIndex; i < picAndPicList.size(); i++) {
            if (isVideo(picAndPicList.get(currentIndex))) {
                videoQueue.add(picAndPicList.get(currentIndex));
            } else {
                picQueue.add(picAndPicList.get(currentIndex));
            }
            currentIndex++;
        }

        // 从第一个图片往后有间隔的插
        while (!videoQueue.isEmpty() && !picQueue.isEmpty()) {
            if (currentIndex >= interval) {
                result.add(picQueue.poll());
                currentIndex = 0;
            } else {
                result.add(videoQueue.poll());
                currentIndex++;
            }
        }

        // 只有其中一方
        while (!videoQueue.isEmpty()) {
            result.add(videoQueue.poll());
        }
        while (currentIndex >=interval && !picQueue.isEmpty()) {
            result.add(picQueue.poll());
        }

        return result;
    }

    private static boolean isVideo(String value) {
        if (value.contains("v")) {
            return true;
        } else {
            return false;
        }
    }
}
