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

        // way 1 using hashMap
        Map<ListNode,ListNode> mp = new HashMap<>();
        ListNode temp = head;
        int cnt = 0;
        while(temp != null){
            if(mp.containsKey(temp)) return mp.get(temp);
            mp.put(temp,temp);
           
            temp= temp.next;
        }
        return null;
        
    }
}