public class RemoveDuplicatesFromSortedArray26 {

    public int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int num : nums){
            if (num > nums[i - 1]){
                nums[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int i = 34 % 33;
        System.out.println("" + i);
    }
}
