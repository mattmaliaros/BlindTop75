class Solution {
	//Working Solution but may need to revisit for time/space complexity optimization
    public int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> slate = new HashMap<>();  //Using Sting because HashMap doesn't store primitives?  Needs research
        int max = 0;
        int count = 0;
        
        for(int i = 0; i < s.length(); i++){
            if(slate.containsKey(Character.toString(s.charAt(i)))){  
                Integer value = slate.get(Character.toString(s.charAt(i))); //Grab the duplicate's value(index of String), so we can restart the loop.  It grabs the duplicate's index then increments at the end of this iteration giving us correct index. 
                                       
                max = Math.max(count, max); //Only change max if count > max
                slate.clear();  //Wipes HashMap
                i = value; //See above
                count = 0;   //Clear count
                
            }
            else{
                slate.put(Character.toString(s.charAt(i)), i); //Key is the value at String index, Value is current iteration
                count++;  //No duplicate found, increment count
                
            }
            
        }
        if(count > max){ // One last check to handle the end of the String
            max = count;
        }
        return max;
    }
}