/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head; // get current for iterations
        ListNode next = null;           
        ListNode prev = null;          //set both to null to start
        while(currentNode!= null) {  // until we are far right past any existing nodes (currentNode == null)
            next = currentNode.next;    //set up next "currentNode"
            currentNode.next = prev;   //nexts <- prevs
            prev = currentNode;         //previous is our last step before iterating
            currentNode = next;         //iterate -- do next node
            
        }
        head = prev;            //currentNode is now null, we can now go back to last existing Node and change to "new" head
        return head;  // can also just return prev
    }
}