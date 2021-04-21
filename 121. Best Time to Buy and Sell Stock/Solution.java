public class Solution {
    public int maxProfit(int prices[]) {
        // Create final result as maxProfit
        int maxProfit = 0;
        
        //Two for loops -- This is not the optimal solution, this is a O(n^2) solution
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                
                // Create a profit variable every iteration of the inner loop.
                // The code below is essentially a Math.max function
                // If we find a profit greater than the maxProfit, reassign the maxProfit.
                int profit = prices[j] - prices[i];
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }
        
        // Return the maximum 
        return maxProfit;
    }
}
