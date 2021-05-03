 static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        
        //Create a hashmap to count the frequency of elements
        Map<Integer,Integer> countMap = new HashMap();
        for(int num : arr) {
			//Key: Num Value, Value: Current Count
			//Default will be count = 1 otherwise get the current value and add 1
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        //Create a minHeap using a PriorityQueue which calls a comparator for sort.
		//The comparator will setup our Heap to have the min element at the top
        Queue<Integer> minHeap = new PriorityQueue<Integer>(
            (n1, n2) -> countMap.get(n1) - countMap.get(n2)
            );
            //For every int in the keyset, add to the minHeap.  (will insert in priority of smallest)
        for(int n : countMap.keySet()) {
            minHeap.add(n);
			//We want to remove the elements we don't need.  Until our size == k, remove elements.
			//Then we return whatever is left.
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        //As an ArrayList return our result.
		//new keyword using type Integer passing in minHeap 
        return new ArrayList<Integer>(minHeap);
    }
