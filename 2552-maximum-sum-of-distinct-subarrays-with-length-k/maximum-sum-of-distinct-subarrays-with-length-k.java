import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();
        long sum = 0, maxSum = 0;
        int left = 0;

        for(int right = 0; right < nums.length; right++){

            // remove duplicates
            while(set.contains(nums[right])){
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            set.add(nums[right]);
            sum += nums[right];

            // maintain window size k
            if(right - left + 1 > k){
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            // valid window
            if(right - left + 1 == k){
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}