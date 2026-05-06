/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        
        int len =  size(head);
        if(len <= 1) return head;
        k = k % len;

        while(k--){
            head = rotate(head);
        }
        return head;
    }
    ListNode* rotate(ListNode* head){
        ListNode* oldH = head;
        ListNode* last = NULL;
        ListNode* curr = head;

        while(curr->next != NULL){
               last = curr;
               curr = curr->next;
        }
        head = curr;
        curr->next = oldH;
        last->next = NULL;
        return head;

    }
    int size(ListNode* head){
        ListNode* temp = head;
        int cnt = 0;
        while(temp != NULL){
            cnt++;
            temp = temp->next;
        }
        return cnt;
    }
};