public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null)  {
            return 0;
        }
        Queue<String> queue = new LinkedList<String>();
        dict.add(end);
        queue.offer(start);
        int step = 1;
        Set<String> set = new HashSet<>();
        set.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            while (size > 0) {
                String poll = queue.poll();
                List<String> nexts = getNext(poll, dict);
                for (String next : nexts) {
                    if (set.contains(next)) {
                        continue;
                    }

                    if (next.equals(end)) {
                        return step;
                    }

                    queue.offer(next);
                    set.add(next);
                    size--;
                }
            }
        }
        return -1;
    }

    public List<String> getNext(String poll, Set<String> dict) {
        List<String> nexts = new ArrayList<>();
        for (int i = 0; i < poll.length(); i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                String s = getWords(poll, i, j);
                if (dict.contains(s)) {
                    nexts.add(s);
                }
            }
        }
        return nexts;
    }

    public String getWords(String poll, int i, char j) {
        char[] word = poll.toCharArray();
        word[i] = j;
        return word.toString();
    }
}