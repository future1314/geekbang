public class MoveZeroes283 {

    // 283. 移动零 https://leetcode-cn.com/problems/move-zeroes/

    // 将非0元素移动到左边
    // 将剩余空间填充为0
    public void moveZeroes(int[] nums) {
        int position = 0;
        for (int num : nums) {
            if (num != 0) nums[position++] = num;
        }
        while (position < nums.length) {
            nums[position++] = 0;
        }
    }

    /*
    这里参考了快速排序的思想，快速排序首先要确定一个待分割的元素做中间点x，然后把所有小于等于x的元素放到x的左边，大于x的元素放到其右边。
这里我们可以用0当做这个中间点，把不等于0(注意题目没说不能有负数)的放到中间点的左边，等于0的放到其右边。
这的中间点就是0本身，所以实现起来比快速排序简单很多，我们使用两个指针i和j，只要nums[i]!=0，我们就交换nums[i]和nums[j]

作者：wang_ni_ma
链接：https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
来源：力扣（LeetCode）
     */
    public void moveZeroes1(int[] nums) {
        int firstZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[firstZeroIndex];
                nums[firstZeroIndex++] = temp;
            }
        }
    }
}
