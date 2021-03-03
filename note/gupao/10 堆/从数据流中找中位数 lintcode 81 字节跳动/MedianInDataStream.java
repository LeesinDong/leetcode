public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        int count = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(count, new Comparator<Integer>(){
            public int compare(Integer num1, Integer num2) {
                return num2 - num1;
            }
        });
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(count);
        int[] answer = new int[count];
        // 中间值
        int number = nums[0];
        // ******************第0个提前放进去，为什么提前放进去？因为总要先有一个number，下面的number在最小面才answer[i] = number进行赋值
        answer[0] = number;

        // ******************第0个提前放进去，这里从1开始，因为 假如第一个4，number4，这个时候不应该再把4放到两个堆中，否则，相当于初始nums凭空多了一个nums[0]
        // 这里从第一个开始，answer[0] 已经有值了
        for (int i = 1; i < count; i++) {
            // 1 放入堆
            if (nums[i] > number) {
                // 大的放小顶堆
                minHeap.add(nums[i]);
            } else {
                // 小的放大顶堆
                maxHeap.add(nums[i]);
            }

            // 2 移动值
            // 绝对值 > 1 的时候，左右移动即可
            if (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    // *********************先保存number，因为number后面会被覆盖
                    maxHeap.add(number);
                    number = minHeap.poll();
                } else {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            } else {
                // 奇数的时候，用靠左边的算
                // && maxHeap.peek() < number可以没有，一样通过，因为放的时候本来就是  maxHeap.peek() < number
                // if (maxHeap.size() - minHeap.size() == 1 && maxHeap.peek() < number) {
                if (maxHeap.size() - minHeap.size() == 1 ) {
                    minHeap.add(number);
                    number = maxHeap.poll();
                }
            }

            // 3 放入结果
            // 将number，即中间值，放入answer
            answer[i] = number;
        }
        return answer;
    }
    
}

maxHeap   number   minHeap
