//Alternate Solution using One pass O(n) time complexity

public class Solution {
    public int maxProfit(int prices[]) {
        //Create a minimum and a max profit variable
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        //Iterate through the array (only once)
        for (int i = 0; i < prices.length; i++) {
            // Find the smallest value of the array, is the current element is not the minimum, then check if we have a new max profit.
            if (prices[i] < minprice)
                minprice = prices[i];
            // Change maxProfit if our current element - minimum is greater than our current maxProfit
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        //Return the max
        return maxprofit;
    }
}
