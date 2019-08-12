# LinkedList
//题目来源：牛客网（NowCoder）
//输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode node = head;
        int len = 0;
        for (; head != null; head = head.next) {
            len++;
        }
        int ret = len - k;
        if(k > len){
            return null;
        }
        for(int i = 0; i < ret; i++){
            node = node.next;
        }
        return node;
    }
