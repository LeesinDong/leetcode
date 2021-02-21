public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }
        int steps = 1;
        // 这条路需要有最后一个
        dict.add(end);
        Queue<String> queue = new LinkedList<>();
        // 路径中已经有了的不行，不然这条路一直重复下去，没有尽头了
        Set<String> duplicate = new HashSet<>();
        queue.offer(start);
        duplicate.add(start);

        while (!queue.isEmpty()) {
            // 一对多，直线延伸，所以一行一行poll
            int size = queue.size();
            // step在这里++，因为queue中是一个单词下一步的很多种可能，但是只有一种可能是最后的路，所以这里++
            steps++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                List<String> nextWords = getNext(word, dict);
                for (String next: nextWords) {
                    if (duplicate.contains(next)) {
                        continue;
                    }

                    if (next.equals(end)) {
                        return steps;
                    }

                    duplicate.add(next);
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    /**
     * 获取所有所给数组中 当前单词变化一个得到的单词
     * @param word
     * @param dict
     * @return
     */
    public List<String> getNext(String word, Set<String> dict) {
        List<String> next = new ArrayList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            for (int j = 0; j < word.length(); j++) {
                String potentialNext = changedWord(word, i, j);
                if (dict.contains(potentialNext)) {
                    next.add(potentialNext);
                }
            }
        }
        return next;
    }

    /**
     * 字符串第i位修改为 char c得到的结果
     * @param word
     * @param c
     * @param i
     * @return
     */
    public String changedWord(String word, char c, int i) {
        char[] words = word.toCharArray();
        words[i] = c;
        return new String(words);
    }
    
}