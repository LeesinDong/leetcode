class Solution {
public int trap(int[] height) {
    	if(height == null || height.length == 0) {
            return 0;
        }
        int length = height.length;
        int left = 0;
        int right = length - 1;
        // 左右最高的高度
        // *****************高度不是0
        int leftHeight = height[left];
        int rightHeight = height[right];
        int sum = 0;
        while (left < right) {
            // 左边小，不管中间有没有，右边一定被挡住，算左边的存水即可，反之亦然
            // ********************if
            if (leftHeight < rightHeight) {
                // ************************1 比较的是leftHeight leftHeight才会最大 2 left + 1（永远是当前的高度和下一个比较而不是当前的）
                if (leftHeight > height[left + 1]) {
                    // *********************leftHeight -
                    sum += leftHeight - height[left + 1];
                } else {
                    leftHeight = height[left + 1];
                }
                left++;
            } else {
                if (rightHeight > height[right - 1]) {
                    sum += rightHeight - height[right - 1];
                } else {
                    rightHeight = height[right - 1];
                }
                right--;
            }
        }
        return sum;
    }
}