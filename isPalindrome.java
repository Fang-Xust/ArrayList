# LinkedList
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //回文链表
class Solution {
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //反转后半部分链表，比如 1 -> 2 -> 1 -> null   反转后为  1 -> null <- 2 <- 1
        ListNode prev = reverseList(slow);
        //定义两个结点记录头，和尾，开始从两端比较
        ListNode pHead = head;
        ListNode tail = prev;
        boolean flag = true;
        while(tail != null){
            if(pHead.val != tail.val){
                flag = false;
                break;
            }
            pHead = pHead.next;
            tail = tail.next;
        }
        //比较完以后还原原来的链表结构，因为比较的过程改变了原有链表
        reverseList(prev);
        //返回结果
        return flag;
    }
}
