class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(Objects.equals(c, '{' )|| Objects.equals(c, '[') || Objects.equals(c, '(')){
                stack.push(c);
            }

            if (Objects.equals(c, '}') && (stack.isEmpty() || (!Objects.equals(stack.pop(), '{')))) {
                return false;
            }

            if (Objects.equals(c, ']') && (stack.isEmpty() || (!Objects.equals(stack.pop(), '[')))) {
                return false;
            }

            if (Objects.equals(c, ')') && (stack.isEmpty() || (!Objects.equals(stack.pop(), '(')))) {
                return false;
            }

            // if(c =="{" || c == "[" || c == "("){
            //     stack.push(c);
            // }
            //
            // if (c == "}" && (stack.isEmpty() || stack.pop != "{")) {
            //     return false;
            // }
            //
            // if (c == "]" && (stack.isEmpty() || stack.pop != "[")) {
            //     return false;
            // }
            //
            // if (c == ")" && (stack.isEmpty() || stack.pop !="(")) {
            //     return false;
            // }
        }

        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
