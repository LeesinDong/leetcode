class Solution {
    public String reverseWords(String s) {
        if (s == null || s.trim().length() == 0) {
            return "";
        }

        String[] words = s.split(" "); //s.trim()不加也能通过
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < words.length; ++i) {
            answer.append(String.valueOf(' ') + reverseString(words[i]));
        }
        return answer.toString().trim();
    }
    
    public String reverseString(String s) {
        String ans = "";
        // 反转就是 i从大大小
        for (int i = s.length() - 1; i>= 0; i--) {
            ans += String.valueOf(s.charAt(i));
        }
        return ans;
    }
}