package gupao;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
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
		// k = 4
		// v_0
		// v_1
		// v_2
		// v_6
		// p_3
		// v_8
		// v_9

		// k = 2
		// v_0
		// v_1
		// v_2
		// p_3
		// v_6
		// v_8
		// p_4
		// v_9
		List<String> result = new KuaiShouEx2().getRecommendedList(picAndVideoList, 4);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	public List<String> getRecommendedList(List<String> picAndVideo, int maxInterval) {
		List<String> result = new ArrayList<>();
		if (picAndVideo == null || picAndVideo.size() == 0) {
			return result;
		}
		Queue<String> videoQueue = new LinkedList<>();
		Queue<String> picQueue = new LinkedList<>();
		boolean firstPic = false;
		int index = 0;
		int picAndVideoSize = picAndVideo.size();
		// 1 找到第一个图片，但是不插入
		while (!firstPic && index < picAndVideoSize) {
			if (isVideo(picAndVideo.get(index))) {
				result.add(index, picAndVideo.get(index));
				index++;
			} else {
				firstPic = true;
			}
		}

		// 2 从第一个图片开始，往后就开始有限制的插
		// 放到放到queue中
		while (index < picAndVideoSize) {
			if (isVideo(picAndVideo.get(index))) {
				videoQueue.add(picAndVideo.get(index));
			} else {
				picQueue.add(picAndVideo.get(index));
			}
			index++;
		}
		// 超过视频片段往里面插
		// **********************result.size()
		int currentSize = result.size();//这里是为了插入第一张图片，如果之前result里面的已经超过了间隔的话
		// **********************!
		while(!videoQueue.isEmpty() && !picQueue.isEmpty()) {
			if (currentSize >= maxInterval) {
				result.add(picQueue.poll());
				currentSize = 0;//间隔计数清零
			} else {
				result.add(videoQueue.poll());
				// ***************************别忘了
				currentSize++;
			}
		}

		// 3 最后 （下面的while 和 if 不可能同时出现）
		// 只有视频了，直接插
		while(!videoQueue.isEmpty()) {
			result.add(videoQueue.poll());
		}

		// 只有图片了，并且到达该插图片的临界点，插图片
		if(currentSize >= maxInterval && !picQueue.isEmpty()) {
			result.add(picQueue.poll());
		}
		return result;
		
	}
	
	public boolean isVideo(String clip) {
		if(clip.indexOf("v") != -1) {
			return true;
		}
		return false;
	}

}
