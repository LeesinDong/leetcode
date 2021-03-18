public class Cast {
    public static void main(String[] args) {
        String result = getResult(1234);
        System.out.println(result);
    }

    private static String getResult(int number) {
        String[] chinese = { "零", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
        String[] unit = { "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千" };
        char[] chars = Integer.toString(number).toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            // 为什么一定是这样？
            // chars[i] 里面是 char不是int，是char
            int num = Integer.parseInt(String.valueOf(chars[i]));
            if (i != 0) {
                sb.append(unit[chars.length - i - 1]).append(chinese[num]);
            } else {
                sb.append(chinese[num]);
            }
        }
        return sb.toString();
    }
}
