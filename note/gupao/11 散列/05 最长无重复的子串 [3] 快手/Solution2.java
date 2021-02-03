public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */

    // 和面试官确认，是否所有字符串都是ask码 即256位
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
       	return 0;
       }

       int i = 0;
       int j = 0;
       int ans = 0;
       int[] map = new int[256];
       for (i = 0; i < s.length(); i++) {
       	while (j < s.length() && map[s.charAt(j)] == 0) {
       		map[s.charAt(j)] = 1;
       		ans = Math.max(ans, j - i + 1);
       		j++;
       	}
       	map[s.charAt(i)] = 0;
       } 
       return ans;
    }
}