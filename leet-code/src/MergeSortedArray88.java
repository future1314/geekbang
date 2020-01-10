/**
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 推荐解法：https://leetcode.com/problems/merge-sorted-array/discuss/29522/This-is-my-AC-code-may-help-you
 * 解答视频：https://www.bilibili.com/video/av16314956?from=search&seid=9718674552323135289
 */
public class MergeSortedArray88 {

    // 解法1：合并两个数组到List；排序；输出新数组。（太Low）时间复杂度：O(3m + 3n)；空间复杂度：O(2n + 2m)

    // 解法2：
    //   复制nums1中的m个元素到新数组后，nums1的空间可以随意使用
    //   按"合并两个有序链表"的思路，顺序对比2个数组的元素，每次取出小于对方的元素，填充到mums1
    //   填充剩下的非空数组到nums1
    // 时间复杂度：O(n) 空间复杂度：O(m)

    public void merge(char[] nums1, char m, char[] nums2, char n) {

    }

}
