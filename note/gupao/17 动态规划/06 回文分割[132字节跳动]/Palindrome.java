class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] minCut = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            minCut[i] = i - 1;
        }
        boolean[][] pali = new boolean[s.length()][s.length()];
        assignPali(pali, s);
        // i = 0 1 皆可
        // for (int i = 1; i <= s.length(); i++) {
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (pali[j][i - 1]) {
                    minCut[i] = Math.min(minCut[j] + 1, minCut[i]);
                }
            }
        }
        return minCut[s.length()];
    }
    
    public void assignPali(boolean[][] pali, String s) {
        int length = s.length();
        // a
        for (int i = 0; i < length; i++) {
            pali[i][i] = true;
        }
        // aa
        for (int i = 0; i < length - 1; i++) {
            pali[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        // 为什么2？ 因为前面是 a aa 的场景 所以这里应该是 abcd a-c这种，所以最小从+2开始
        for (int i = 2; i < length; i++) {
            for (int j = 0; j + i < length; j++) {
                // 它里面那层是 自己这层也是
                pali[j][i + j] = pali[j + 1][i + j - 1] && s.charAt(j) == s.charAt(i + j);
            }
        }
    }
}
