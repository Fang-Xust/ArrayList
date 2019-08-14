# LinkedList
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    public ListNode detectCycle(ListNode head) {
        //思路：快慢指针法
        ListNode slow = head;
        ListNode fast = head;
        while(slow != null && fast != null){
            if(fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            //如果快慢指针相遇，就跳出循环
            if(slow == fast){
                break;
            }
            //如果快、慢指针中，任意一个为空，就说明链表无环，返回null
            if(slow == null || fast == null){
                return null;
            }
        }
        //找到相遇点后，定义一个指向链表开头的指针pHead，让pHead和slow慢指针同时走，
        //则它们肯定会在入环点相遇，返回入环点
        ListNode pHead = head;
        while(pHead != slow && slow != null && pHead != null){
            pHead = pHead.next;
            slow = slow.next;
        }
        return pHead;
    }
