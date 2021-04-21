public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Create result matching method return
        List<Integer> result= new ArrayList<>();
        // Check if we have anything to do
        if(matrix.length == 0 || matrix[0].length == 0) return result;
        
        //Initialize our variables from their starting points.
        //Left is left side (index 0), right is the end of the row (index of the end of the row)
        //Top is top side (index 0), bottom is the end of the column(index of the end of the column)
        int top = 0, int left = 0, int bottom = matrix.length-1, int right = matrix[0].length-1;
        
        //Important note: This loop runs forever unless we break from it.  
        // If any of the conditions after the for loops are true, we have our final result.
        
        while(true){
            // Start left until end of row (on first iteration), adding each value to the result
            // After each iteration of left to right, we want to increment top every time 
            // because we have handled the top row.
            for(int i = left; i <= right; i++) result.add(matrix[top][i]);
            top++;
            // If top > bottom here, then we have reached the end of our spiral
            if(top > bottom) break;
            // Start top until end of column (on first iteration), adding each value to the result
            // After each iteration of top to bottom, we want to decrement right every time 
            // because we have handled the right column.
            for(int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            // If left > right here, then we have reached the end of our spiral
            if(left > right) break;
            // Start right until beginning of row (on first iteration), adding each value to the result
            // After each iteration of right to left, we want to decrement bottom every time 
            // because we have handled the bottom row.
            for(int i = right; i >= left; i--) result.add(matrix[bottom][i]);
            bottom--;
            // If top > bottom here, then we have reached the end of our spiral
            if(top > bottom) break;
            // Start bottom until beginning of column (on first iteration), adding each value to the result
            // After each iteration of bottom to top, we want to increment left every time 
            // because we have handled the left column.
            for(int i = bottom; i >= top; i--) result.add(matrix[i][left]);
            left++;
            // If left > right here, then we have reached the end of our spiral
            if(left > right) break;
        }
        
        return result;
    }
    
}