package test;

public class ZuixiaoGaodu {
    // 假设一棵二叉树的结点个数为50，则它的最小高度是
    // https://blog.csdn.net/qq_16811963/article/details/52207479

    public static void main(String[] args) {
        int length = 50;
        int[] vals = new int[length];
        for (int i = 0; i < length; i++) {
            vals[i] = i;
        }
        System.out.println(buildMinimalBST(vals));
    }

    public static int buildMinimalBST(int[] vals) {
        // write code here
        int length = vals.length;
        int count = 0;
        while (length != 1) {
            length = length >> 1;
            count++;
        }
        return ++count;
    }
}
