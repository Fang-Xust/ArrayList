# LinkedList

//反转一个单链表
//思路：所谓的单链表反转，就是把每个结点的指针域由原来的指向下一个节点变为指向其前一个节点。
//但由于单链表没有指向前一个结点的指针域，因此我们需要增加一个指向前一个结点的结点prev，
//用于存储每一个结点的前一个结点。此外，还需要定义一个保存当前结点的结点cur，以及下一个结点next用来接应。
//定义好这三个结点后，遍历单链表，将当前结点的指针域指向前一个节点，
//之后将定义三个结点往后移动，直至遍历到最后一个节点停止。

class Solution {
    public ListNode reverseList(ListNode head) {
		    ListNode prev = null;
		    ListNode cur = head;
		    ListNode next = null;
		    while(cur != null){
		  	    next = cur.next;
		  	    cur.next = prev;
		  	    prev = cur;
	  		    cur = next;
		    }
		    return prev;
	  }
}
