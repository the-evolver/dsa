/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;

         
         ListNode fptr = head.next.next;
         ListNode sptr = head.next;
         while(sptr != fptr){
               if(fptr == null || fptr.next == null) return null;
               sptr = sptr.next;
               fptr = fptr.next.next;
         }
        
        sptr = head;
        while(sptr != fptr){
            sptr = sptr.next;fptr=fptr.next;
        }
        return sptr;
    }
}