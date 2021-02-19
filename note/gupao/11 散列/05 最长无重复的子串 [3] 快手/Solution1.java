public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        Set<Character> set = new HashSet<>();
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            // 总结：只要没有重复的，就一直往里面加，一旦有了重复的，就从前面开始删

            // [1 2 3 3 4] right到第二个3有重复的时候，i 进化到 2，right不变，还有重复跳过while，接着往后i进化到3
            // 还有重复，i进化到第二个3。
            // 从第一个字母开始 放入set，right指针往后没有重复就max增加
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - i);
            }
            set.remove(s.charAt(i));
        }
        return max;
    }
}