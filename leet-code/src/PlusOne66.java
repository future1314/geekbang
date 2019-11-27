/**
 * https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne66 {

    static public int[] plusOne(int[] digits) {
        int length = digits.length;

        for (int i = length - 1; i > -1; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }
}
