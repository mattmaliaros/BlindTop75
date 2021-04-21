class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create HashMap to set the Key to the value in the array and the Value to the index in the array
        HashMap<Integer, Integer> newHash = new HashMap<>();
        
        //Loop through the array pushing the data to the HashMap (see above)
        for(int i = 0; i < nums.length; i++){
            // If we already have the Key (value in array) then we have found a duplicate.  Return true.
            if(newHash.containsKey(nums[i])){
                return true;
            }
            //If not, then we just add to the HashMap.
            else{
            newHash.put(nums[i], 1);
            }
        }
        // No duplicate was ever found, so we can return false.
        return false;
    }
}
