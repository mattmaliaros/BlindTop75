class Solution{
    public List<List<Integer>> levelOrder(TreeNode root){
    //Create our result
        List<List<Integer>> result = new ArrayList<>();
    // Check if root is null, if it is, we don't need to do anything
        if(root == null) return result;
        // Create a queue for Level Order Traversals AKA BFS
        Queue<TreeNode> queue = new LinkedList<>();
        //Insert root into queue
        queue.add(root);
        // While elements are remaining in the queue:
        while(!queue.isEmpty()) {
            //Create a level List to store nodes per level (will recreate at end of while loop)
            List<Integer> level = new ArrayList<>();
            //Create and initiate the size based off current size of queue (will recreate at end of while loop)
            int size = queue.size();
            //For loop that does all elements per level
            for(int i = 0; i < size; i++){
                //Pop off current node off queue
                TreeNode current = queue.poll();
                //Add to level list
                level.add(current.val);
                //If we have a left, add left to queue
                if(current.left != null) {
                    queue.add(current.left);
                } 
                //If we have a right, add right to queue
                 if(current.right != null) {
                    queue.add(current.right);
                } 
            }
            // Add the nodes (by level) to the list as its own list.  
            result.add(level);
        }
        //Finally return the list of lists <Integer>
    return result;
}
}