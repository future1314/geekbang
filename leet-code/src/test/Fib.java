package test;

public class Fib {

    // https://blog.csdn.net/autfish/article/details/52370830
    public static void main(String[] args) {
        int val = 2;
        System.out.println(fib((val)));
    }

    public static int fib(int n) {
        if(n == 0) return 0;
        if(n < 3) return 1;
        int fib = 0;
        int fibOne = 1;
        int fibTwo = 1;
        for(int i = 2; i < n; i++) {
            fib = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fib;
        }
        return fib;
    }
}
