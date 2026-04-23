import java.util.*;

public class Solution {

    // 1
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (hashMap.containsKey(other)) {
                return new int[]{hashMap.get(other), i};
            }
            hashMap.put(nums[i], i);
        }
        return new int[]{};
    }

    // 121
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        int sell = 1;
        while (sell < prices.length) {
            if (prices[buy] > prices[sell]) {
                buy = sell;
                sell = buy + 1;
            } else {
                int profit = prices[sell] - prices[buy];
                maxProfit = Math.max(maxProfit, profit);
                sell++;
            }
        }
        return maxProfit;
    }

    // 217
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // 53
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;
        for (int num : nums) {
            if (currentSum < 0) {
                currentSum = 0;
            }
            currentSum += num;
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // 153
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (nums[l] <= nums[r]) {
                return nums[l];
            }
            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return -1;
    }

    // 33
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + ((r - l) / 2);
            if (nums[m] == target) {
                return m;
            }
            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
