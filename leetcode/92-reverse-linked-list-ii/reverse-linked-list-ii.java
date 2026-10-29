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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode prev = null,curr=head,next,justB=null,justA=null,rtail=null,rhead =null;

        int p =1;
        while(curr != null){
              
              if(p >= left && p <= right){
                       if(rtail == null) rtail = curr;
                       rhead = curr;
                       next = curr.next;
                       curr.next = prev;
                       prev = curr;
                       curr = next;
                       p++;

              }else{

                if(p == left -1) justB = curr;
                if(p == right+1) justA = curr;
                curr = curr.next;
                p++;

              }
             
     
        }
        if(justB != null) justB.next = rhead;
        rtail.next = justA;

        return left == 1 ? rhead : head;
        
    }
}