public class Solution {
public int search(int[] arr, int target) {
	
	//Two pointers at start and end
    int start = 0;
    int end = arr.length - 1;
	
	// We are essentially breaking the array up into smaller arrays at each while
	// This will work until we have 1 element left
    while (start <= end) {
		//The best approach to find our mid element (A binary search strategy)
		//Doing start + (end - start) / 2 is a better alternative to (start + end) / 2
		//This is to avoid an overflow error
        int mid = start + (end - start) / 2;
		//Check if mid element is our target, and if so, we have successfully found the target -- return the index of mid.
        if (arr[mid] == target) return mid;
        
		//This check is important because if our element at start is greater than mid, we will have to handle an "unsorted" array
        if (arr[start] <= arr[mid]) {
			//Find the target in the range:  if in first half then cut the array by removing elements after mid
            if (target >= arr[start] && target < arr[mid]) {
                end = mid - 1;
            }
			//Otherwise cut the array by removing elements before mid.
			else {
                start = mid + 1;
            }
        } else {
			//A more complicated case because our start > mid element.  First we check if the target is in the range of the right side (elements after mid).
            if (target > arr[mid] && target <= arr[end]) {
                start = mid + 1;
            } 
			//The ugliest option: Example: Find 5 - [5,1,3] Our start is greater than mid and our target is greater than end
			//Cut the array elements to use the left side (elements before mid).
			else {
                end = mid - 1;
            }
        }
    }
	//Target was never found
    return -1;
}
}

