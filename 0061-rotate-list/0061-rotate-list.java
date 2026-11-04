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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        int size=1;
        ListNode tail=head;
        while(tail.next != null){
            tail=tail.next;
            size++;
        }

        k=k%size;
        if(k == 0) return head;


        tail.next=head;
        int pos=size-k;

        ListNode newTail=head;
        while(pos != 1){
            newTail=newTail.next;
            pos--;
        }

        ListNode newHead=newTail.next;
        newTail.next=null;
        return newHead;
    }
}