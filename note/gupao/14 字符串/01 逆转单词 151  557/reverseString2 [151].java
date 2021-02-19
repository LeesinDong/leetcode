class Solution {
    public String reverseWords(String s) {
           // write your code here
        if (s == null || s.trim().length() == 0) {
            return "";
        }

        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            // 会有"    "这种
            // 输入："a good   example"
            // 输出："example good a"
            // if(words[i].trim().equals("")) { 不需要trim()
            if(words[i].equals("")) {
                continue;
            }

            sb.append(words[i] + " ");
        }

        return sb.toString().trim();
    }
}