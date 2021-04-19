class Solution {
    public int climbStairs(int n) {
        // This is a tabulation solve.  We are only keeping 3 entries in the table and updating them when necessary.
        // Setting the first two values before checking our base cases.  This way, we can also solve for 3, 4, 5... n, etc.
        
        
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