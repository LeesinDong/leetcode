class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // 最少砍几刀的数组
        int[] minCut = new int[s.length() + 1];
        // 默认 i长度 需要i - 1刀
        for (int i = 0; i <= s.length(); i++) {
            minCut[i] = i - 1;
        }

        // 横纵坐标是 字符串的开始结束坐标
        boolean[][] pali = new boolean[s.length()][s.length()];
        assignPali(pali, s);

        // i = 0 1 皆可，最好1，因为从j开始  i - 1，如果是0 结果 -1， j 到 -1 有什么意义？
        // for (int i = 1; i <= s.length(); i++) {
        // 1 到length()，因为minCut就这样
        // for (int i = 1; i <= s.length(); i++) {
        for (int i = 0; i <= s.length(); i++) {
            // j < i 不是 <= 因为i可以到s.length() 但是pali[j] 是不可以的。会数组越界
            for (int j = 0; j < i; j++) {
                // 如果 j到i -1 是回文，i是主调，还是从i开始往前推的，往前是根据j
                // i - 1，因为pali从0开始，j没有 -1 ，因为j是为了往前拓展的。pali[i - 1] 相当于mincut[i]
                if (pali[j][i - 1]) {
                    // i地方长度的最少刀 是j的刀数 + 1，因为j到i -1一刀也不需要因为是回文。
                    minCut[i] = Math.min(minCut[j] + 1, minCut[i]);
                }
            }
        }
        return minCut[s.length()];
    }

    /**
     * 设置是否是回文
     * @param pali
     * @param s
     */
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
        // 为什么2？ 因为前面是 a aa 的场景 所以这里应该是 abcd a-c这种，所以最小从+2开始 j + 2 即 j是a， + 2 a 到c
        // *************************2开始，1上面已经解决了
        for (int i = 2; i < length; i++) {
            for (int j = 0; j + i < length; j++) {
                //              里面那层是会问            &&  里面那层外面 的 两头也是相等的字符串
                pali[j][j + i] = pali[j + 1][i + j - 1] && s.charAt(j) == s.charAt(i + j);
            }
        }
    }
}
