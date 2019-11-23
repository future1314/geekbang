import java.util.Arrays;

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
 */
public class MergeSortedArray88 {

    // 解法1：合并两个数组到List；排序；输出新数组。（太Low）时间复杂度：O(3m + 3n)；空间复杂度：O(2n + 2m)

    // 解法2：
    //   复制nums1中的m个元素到新数组后，nums1的空间可以随意使用
    //   按"合并两个有序链表"的思路，顺序对比2个数组的元素，每次取出小于对方的元素，填充到mums1
    //   填充剩下的非空数组到nums1
    // 时间复杂度：O(n) 空间复杂度：O(m)

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1 == null || nums2 == null || n == 0){
            return;
        }

        if(m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int[] nums = Arrays.copyOf(nums1, m);
        int i = 0;
        int i1 = 0;
        int i2 = 0;
        boolean isEmpty1 = false;
        boolean isEmpty2 = false;
        while (!isEmpty1 && !isEmpty2){
            int num1 = nums[i1];
            int num2 = nums2[i2];

            if(num1 < num2){
                nums1[i] = num1;
                i1++;
                if(m == 0 || i1 == m){
                    isEmpty1 = true;
                }
            }else {
                nums1[i] = num2;
                i2++;
                if(n == 0 || i2 == n){
                    isEmpty2 = true;
                }
            }
            i++;
        }

        int[] lastNums;
        int lastIndex;
        int lastCount;
        if(isEmpty1){
            lastNums = nums2;
            lastIndex = i2;
            lastCount =  n;
        }else {
            lastNums = nums;
            lastIndex = i1;
            lastCount = m;
        }

        for (; lastIndex < lastCount; lastIndex++) {
            nums1[i] = lastNums[lastIndex];
            i++;
        }
    }

}
