class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Hash table to insert values while also checking to see if we have our sum
        //Sum will be current element plus any (1) of the elements currently in the hash table
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        for(int i = 0; i < nums.length; i ++) {
            //create an int to store the target - current iteration value
            int comp = target - nums[i];
            if(hash.containsKey(comp)) {
                //if the key is found, we have our 2 values
                return new int[] {hash.get(comp), i };
            }
            //Else just insert into the hash table
            
                hash.put(nums[i], i);
            
        }
        //Ask interviewer if we should return {0,0}, {-1, -1} or just throw an exception
        throw new IllegalArgumentException("No two sum solution");
}
}
