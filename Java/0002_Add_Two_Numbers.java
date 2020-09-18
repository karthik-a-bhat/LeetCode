//https://leetcode.com/problems/add-two-numbers/

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode head = null;
        ListNode temp = null;
        
        int carry = 0;
        
        while(l1!=null || l2!=null){
            
            int l1val = (l1!=null) ? l1.val : 0;
            int l2val = (l2!=null) ? l2.val : 0;
            
            carry = l1val + l2val + carry;
            
            if(head==null){
                
                head = new ListNode(carry%10);
                temp=head;
            }
            else{
                ListNode curr = new ListNode(carry%10);
                temp.next=curr;
                temp=curr;
            }
            
            if(l1!=null)l1=l1.next;
            if(l2!=null)l2=l2.next;
            carry=carry/10;
        }
        if(carry>0){
            temp.next=new ListNode(carry);
        }
        
        return head;
    }
}
