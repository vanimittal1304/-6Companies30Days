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


class Solution {
    public
        vector<int> largestDivisibleSubset(vector<int> & nums) {
            int n = nums.size();
            vector<int> ans;
            if(n==0)
                return ans;
            
            sort(nums.begin(), nums.end());
            int max = 1;
            vector<int> dp(n+1,1);
            for(int i=1;i<n;++i){
                for(int j = 0; j<i;++j){
                    if(nums[i]%nums[j]==0 && 1+dp[j]>dp[i]){
                        dp[i] = 1+dp[j];
                        if(max<dp[i])
                            max = dp[i];
                    }
                }
            }
            // now push th LIS
            int prev = -1;
            for( int i = n-1; i>=0; i--){
                if(dp[i] == max && (prev%nums[i] == 0 || prev == -1)){
                    ans.push_back(nums[i]);
                    max -= 1;
                    prev = nums[i];
                }
            }
            return ans;
        }
        
};