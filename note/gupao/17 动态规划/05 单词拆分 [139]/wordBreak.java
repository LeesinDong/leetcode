class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // wordDict里面可以重复，为了减少计算，这里用set去重，其实不用sete也行
        Set<String> dict = new HashSet<>();
        for (String word: wordDict) {
            dict.add(word);
        }

        boolean[] canSegment = new boolean[s.length() + 1];
        // 因为需要下面的continue的时候，退到第0个，这个时候可以往下了
        // 第零个没有意义，默认给true，否则，后面无法继续
        canSegment[0] = true;
        // 获取最长单词
        int largetlengthWord = getLargest(dict);

        // 从第一个字母开始往后 ，因为遍历并设置值的是canSegment,canSegment[0]已经设置好了 <= s.length() 因为s.length() + 1
        // for (int i = 1; i <= s.length(); i++) {
        for (int i = 1; i < canSegment.length; i++) {
            // ******************************* <= largetlengthWord 因为这里是遍历的最长的长度，长度最大就是 = largetlengthWord
            // ******************************* j <= i 因为下面计算canSegment[i - j] i - j 可能成为负数 j = i，最多是0，可以接受
            for (int j = 0; j <= largetlengthWord && j <= i; j++) {
                // 从后往前，前面的都不是true，后面在怎么分割也没有意义
                // leetcode   i = 4  j = 0 1 2 3 都continue，因为默认false， j = 4 canSegmen[0] = true 所以不continue，到了下面
                // 即leet 从t 开始往前的
                if (!canSegment[i - j]) {
                    continue;
                }

                // dict里面包括了，前面可以截取的串，到目前的地方的，设置canSegement[4]为true
                if (dict.contains(s.substring(i - j, i))) {
                    canSegment[i] = true;
                }
            }
        }

        return canSegment[s.length()];
    }

    /**
     * 获取最长的单词
     * @param dict
     * @return
     */
    public int getLargest(Set<String> dict) {
        int max = 0;
        for (String word: dict) {
            max = Math.max(max, word.length());
        }
        return max;
    }
}


//               l e e t c o d e
//cansegment// 1 0 0 0 1       1
    //index//  0 1 2 3 4 5 6 7 8