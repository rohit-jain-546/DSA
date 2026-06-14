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
    public int pairSum(ListNode head) {
      ListNode tail = head;int c=0;
     int ans =0;
      while(tail!=null){tail=tail.next;c++;}
      int [] ar = new int [c];
      for(int i  =0;i<c;i++){
        ar[i]=head.val;
        head=head.next;
      }int a =(c/2)-1;
      for(int i = (c/2);i<c;i++){
        ans = Math.max(ans,ar[i]+ar[a--]);

      }return ans;
}}