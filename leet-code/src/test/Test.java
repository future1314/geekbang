package test;

public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,8, 10, 12, 14, 16, 18,20, 22};
        search(arr, 16);
    }

    /*
    left, right = 0, len(array) - 1
while left <= right:
      mid = (left + right) / 2
      if array[mid] == target:
            # find the target!!
            break or return result
      elif array[mid] < target:
            left = mid + 1
      else:
            right = mid - 1

            1 2 3
            n = 3

            n - i

     先序 EFHIGJK

     */
    private static int search(int[] array, int target) {
      int left = 0, right =  array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println((mid + 1));
            if (array[mid] == target)
                return mid;
            else if (array[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return -1;
    }
}
