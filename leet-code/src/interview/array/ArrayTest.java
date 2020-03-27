package interview.array;

import java.util.Arrays;

public class ArrayTest {
    // 三维数组如何变一维。遍历层数要少

    public static void main(String[] args) {
        int[][][] array = new int[3][3][3];
        traversal(array);
        int[][][] arrayCopy = Arrays.copyOf(array, array.length);
        System.out.println("----------------------------------------------------------------");
        traversalPrint(arrayCopy);
    }

    private static void traversal(int[][][] array) {
        int count = 0;
        for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {
            int[][] first = array[firstIndex];
            for (int secondIndex = 0; secondIndex < first.length; secondIndex++) {
                int[] third = first[secondIndex];
                for (int thirdIndex = 0; thirdIndex < third.length; thirdIndex++) {
                    third[thirdIndex] = count++;
                    int val = third[thirdIndex];
                    System.out.println(val);
                }
            }
        }
        System.out.println("总数 = " + count);
    }

    private static void traversalPrint(int[][][] array) {
        int count = 0;
        for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {
            int[][] first = array[firstIndex];
            for (int secondIndex = 0; secondIndex < first.length; secondIndex++) {
                int[] third = first[secondIndex];
                for (int thirdIndex = 0; thirdIndex < third.length; thirdIndex++) {
                    int val = third[thirdIndex];
                    System.out.println(val);
                    count++;
                }
            }
        }
        System.out.println("总数 = " + count);
    }
}
