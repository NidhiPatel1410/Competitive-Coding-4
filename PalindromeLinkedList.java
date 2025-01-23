// In this problem, we can do one thing is that put all the elements of linkedlist in array, and then use two pointers, one at start and
// one at end. Check if equal, increment start pointer and decrement end pointer. All values match then it is a palindrome. But problem
// in this approach is that, it takes up extra (array) space. 
// And it is a singly linked list so we cannot directly have pointer at end node, we just have next pointers in single direction.
// So, we can find the mid of the linked list using slow and fast pointers, then reverse the linked list from mid to end and then keep 
// two pointers, one at head and one at the start of reversed LL, then compare if equal or not.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        while (slow != null) {
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        ListNode left = head;
        ListNode right = prev;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;

    }
}