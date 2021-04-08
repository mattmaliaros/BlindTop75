class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> newHash = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            if(newHash.containsKey(nums[i])){
                return true;
            }
            else{
            newHash.put(nums[i], 1);
            }
        }
        return false;
    }
}