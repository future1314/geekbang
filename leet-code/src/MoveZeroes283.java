public class MoveZeroes283 {

    // 283. 移动零 https://leetcode-cn.com/problems/move-zeroes/

    public void moveZeroes(int[] nums) {
        int position = 0;
        for (int num : nums) {
            if (num != 0) nums[position++] = num;
        }
        while (position < nums.length) {
            nums[position++] = 0;
        }
    }
}
