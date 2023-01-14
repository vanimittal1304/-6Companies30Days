import java.util.ArrayList;
import java.util.Arrays;

// Q- Largest Divisible Subset.
// eg: {1, 4, 2, 6, 7}

// Goal: Find largest subset where every pair of element are divisible
//   ([a,b] -> a%b == 0
//         or
//             b%a == 0)

// So, Div subsets (1, 2, 4), (1, 2, 6), (1,7)
//                     |
//                     |
//         In this all pairs are
//   valid such as (1,2), (2,4), (1,4)
//      with lngth = 3.
//  Now as we need to return largest length, but here we have 2 

//  So for approach we will not be using recursion becoz this will take exponntial time 
// we will be using 2 pointers on sorted array for less time
// 1. sorted
// 2. Apply dp
// 3. find subset

// if(dp[i]%dp[j] == 0 and 1+dp[j]>dp[i])
//     dp[i] = 1+dp[j];
//     if(max<dp[i])
//         max = dp[i];

class LargestDivisibleSubset {
    public List<Integer> LargestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return new ArrayList();

        // step 1: sort
        Arrays.sort(nums);

        // step 2: generating dp
        int[] count = new int[n];

        Arrays.fill(count, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0)
                    count[i] = Math.max(count[i], count[j] + 1);
            }
        }
        // step 3
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            maxIndex = count[i] > count[maxIndex] ? i : maxIndex;
        }
        // step 4
        List<Integer> result = new ArrayList();
        int temp = nums[maxIndex];
        int currentCount = count[maxIndex];
        for (int i = maxIndex; i >= 0; i--) {
            if (temp % nums[i] == 0 && currentCount == count[i]) {
                result.add(nums[i]);
                temp = nums[i];
                currentCount--;
            }
        }
        return result;
    }

}