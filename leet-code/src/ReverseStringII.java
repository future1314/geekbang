import java.lang.reflect.Method;

public class ReverseStringII {
    // 541. 反转字符串 II https://leetcode-cn.com/problems/reverse-string-ii/

    /**
     * 0            k           2k          3k
     * |-----------|-----------|-----------|---
     * +--reverse--+           +--reverse--+
     */
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while (i < n) {
            int j = Math.min(i + k - 1, n - 1);
            reverse(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }

    private void reverse(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static void target(int i) {
        // 空方法
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("ReverseStringII");
        Method method = klass.getMethod("target", int.class);
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            method.invoke(null, 128);
        }
    }
}
