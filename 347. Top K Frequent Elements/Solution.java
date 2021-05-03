static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
		//Create a new HashMap for storing value of arr(i) as key, and the count as value
        Map<Integer, Integer> hash = new HashMap<>();
		//Create a new HashMap to store the count of elements in arr as key, and the list of elements as values
        Map<Integer, List<Integer>> freq = new HashMap<>();
		//Create a max variable to find the maximum count of a specific element
        int max = Integer.MIN_VALUE;
        
		
		//Loop through the array and put the values in first hash (see above)
        for(int i = 0; i < arr.size(); i++){
            hash.put(arr.get(i), hash.getOrDefault(arr.get(i), 0) + 1);
            max = Math.max(max, hash.get(arr.get(i)));
        }
        
		//Loop through the HashMap and only create a new list if we don't have a frequency yet for this "count". (see above)
        for(Integer key : hash.keySet()){
            freq.computeIfAbsent(hash.get(key), value -> new ArrayList<>())
            .add(key);
        }
        
		//Create our final result list
        ArrayList<Integer> result = new ArrayList<>();
    
        
		//We do this while we have more elements left.  K is the number of elements to be returned.
        while(0 < k){
			//Create a temp List and grab the highest counts.  
			//If there are multiple of the same count, this will grab all of them.
            List<Integer> temp = freq.getOrDefault(max, new ArrayList<>());
			//Now loop until our temp list has no more elements OR k == 0
			//Add these to the result
            for(int i = 0; i < temp.size() && 0 < k; i++){
                result.add(temp.get(i));
				//Decrement K since we added an element
                k--;
            }
			//If we need more elements, do the next largest count
            max--;
        }
        
        return result;
        
    }