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

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode before = dummy;
        for(int i = 1 ; i < left ; i++){
               before = before.next;
        }

        ListNode curr = before.next;
        for(int i = 1 ; i <= right - left ; i++){

                 ListNode move = curr.next;
                 curr.next = move.next;
                 move.next = before.next;
                 before.next = move;
        }
        return dummy.next;
        
    }
}