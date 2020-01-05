public class ContainerWithMostWater11 {
    // 11. 盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/

    /*
    解法
    1. 左右两端的宽度最大
    2. 高度越大，盛水越多
    3. 当宽度一样时，舍弃低的，寻找更高的
     */
    public int maxArea(int[] height) {
        int maxWater = 0;
        for (int i = 0, j = height.length - 1; i < j;) {
            int water = (j - i) * Math.min(height[i], height[j]);
            maxWater = Math.max(water, maxWater);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxWater;
    }
}
