# LinkedList

class Solution {
    //链表的中间结点
    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        int len = 0;
        for(;head != null;head = head.next){//求链表的长度
            len++;
        }
        int mid = len / 2;
        for(int i = 1;i <= mid;i++){//将链表从前往后遍历，一直到中间元素
            node = node.next;
        }
        return node;//最后返回node
    }
    //删除链表中的结点（使用替换思想）
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
        //思路:把下一个节点的值赋给当前节点，然后将当前节点指向下下个节点,替换思想
    }
}


