class Solution {
    public int climbStairs(int n) {
        // This is a tabulation solve.  EDIT: We are calculating all entries in the table by hardcoding the first two values and then calculating each value after.
        // Setting the first two values before checking our base cases.  This way, we can also solve for 3, 4, 5... n, etc.
        // We will have a full table of n entries where table[n] is always going to be equal to table[n-1] + table[n-2] -- See line 16.
        
        int[] table = new int[n+1];
        table[1] = 1; 
        table[2] = 2;
        if(n == 1) return table[1];
                   
        if(n == 2) return table[2];
        
        
        for(int i = 3; i <= n; i++){
            table[i] = table[i-1] + table[i-2];
        }
        return table[n];
    }
}
