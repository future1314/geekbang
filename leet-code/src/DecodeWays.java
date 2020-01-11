public class DecodeWays {
    // 91. 解码方法 https://leetcode-cn.com/problems/decode-ways/

    /*
    参考
    https://leetcode-cn.com/problems/decode-ways/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-3/
    https://leetcode-cn.com/problems/decode-ways/solution/dong-tai-gui-hua-tu-jie-by-nfgc/

    解法
    计算公式：解码方法的总数[当前位置] = 解码方法的总数[当前位置 - 1] + 解码方法的总数[当前位置]
    char[当前位置] == 0：该位置不计数
    char[当前位置 - 1]char[当前位置] 在 [1, 26]范围内：使用计算公式
    char[当前位置 - 1]char[当前位置] 不在 [1, 26]范围内：非法组合，不计数
     */
    public int numDecodings(String s) {
        int len = s.length();
        int first = 1;
        int second = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < len;i++) {
            int temp = second;
            if (s.charAt(i) == '0')
                second = 0;
            if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) < '7'))
                second += first;
            first = temp;
        }
        return second;
    }

    public static void main(String[] args) {
        DecodeWays d = new DecodeWays();
        System.out.println(d.numDecodings("0"));;
    }

    // 演化过程
    /*public int numDecodings(String s) {
        int m = s.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        for (int i = 1; i <= m; ++i) {
            if (s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];
            if (i > 1 && ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7')))
                dp[i] += dp[i - 2];
        }
        return dp[m];
    }*/

    /*public int numDecodings(String s) {
        int m = s.length();
        int[] dp = new int[m + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= m; ++i) {
            if (s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];
            if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))
                dp[i] += dp[i - 2];
        }
        return dp[m];
    }*/
}
