class Solution {
    public int rob(int[] nums) {
        
        // Handle where we have a null/empty array -- No need to do work
        if(nums.length == 0 || nums == null){
            return 0;
        }
        
        // Just return the one and only element
        if(nums.length == 1){
            
            return nums[0];
        }
		// Return the greater of the only two elements
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
		
		// Create a table to keep previous values for a quick lookup
        int dp[] = new int[nums.length];
		
		// We know the first two values (see above)
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
		// We are going to iterate from 2 to the end of the array, since we have already done our first two values
		// Each iteration, we set the maximum value of dp[i-2] (2 iterations ago) plus our current value
		// OR our previous iteration.  This fully captures the idea of skipping a house (to not set the alarm off)
		
        for(int i = 2; i < nums.length; i++){
            dp[i] =  Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
		// Finally return the last element in our DP table, which is our answer
        return dp[nums.length -1];
    }
}