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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;int a =0;
        while(temp!=null){
            a++;
            temp = temp.next;
        }
        int r = a-n;
        if(r==0){return head.next;}
        ListNode temp2 = head;
        for (int i =0; i<a-1;i++){
            if(i+1==r){
                temp2.next=temp2.next.next;

            }temp2=temp2.next;

        }return head;

    }
}