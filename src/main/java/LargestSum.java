
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestSum {
    /**
     * Get the largest possible sum that can be obtained from a pair of values in the list. A number can't be added
     * to itself, unless there are duplicates.
     *
     * @param nums a list of ints.
     * @return the largest possible sum of separate numbers from nums.
     */
    public int bigSum(List<Integer> nums){
        if (nums == null || nums.size() < 2) return 0;
        
        Map<Integer, Integer> freq = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        if (freq.get(max) >= 2) {
            return max + max;
        } else {
            return max + secondMax;
        }
    }
}