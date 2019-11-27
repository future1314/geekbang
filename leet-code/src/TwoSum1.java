import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        int[] answer = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if(map.containsKey(value)){
                answer[0] = map.get(value);
                answer[1] = i;
                return answer;
            }

            map.put(nums[i], i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] answer = twoSum(nums, target);
        System.out.println(Arrays.toString(answer));
    }
}
