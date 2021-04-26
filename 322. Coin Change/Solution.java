// This is the top down approach -- meaning we start from 11(see example) and subtract until we get to 0
// First we start with 1 (since 1 is the first coin in the coins array)
// Once 1 fails, we iterate in the array to 2
// Once 2 fails, we iterate in the array to 5
public class Solution {
public int coinChange(int[] coins, int amount) {
    //If the amount is less than 1 then we have no work to do.
    if(amount<1) return 0;
    // Helper function call using an array size of our amount
    return helper(coins, amount, new int[amount]);
}

private int helper(int[] coins, int rem, int[] count) { // rem: remaining coins after the last step; count[rem]: minimum number of coins to sum up to rem
    if(rem<0) return -1; // Invalid, we want 0 or higher. 
    if(rem==0) return 0; // 0 is what we want.  The first time we hit 0 is not our final answer.  We want the MINIMUM.
    if(count[rem-1] != 0) return count[rem-1]; // This is so that we don't repeat our work.  Think of Fibonacci.
    //Create a min variable to find the min coins
    int min = Integer.MAX_VALUE;
    
    //Iterate through all coins, see at the very top
    for(int coin : coins) {
        // We return either -1, 0 or a value we have already done work for.
        int res = helper(coins, rem-coin, count);
        // Only resetting the min if we get a "good" result
        if(res>=0)
            min  = Math.min(1+res, min);
    }
    //If the value wasn't updated, then there is no solution to this particular step.
    //However, if we do have a value, we can store it to prevent re-doing our work
    count[rem-1] = (min==Integer.MAX_VALUE) ? -1 : min;
    //And finally return what we have
    return count[rem-1];
}
}