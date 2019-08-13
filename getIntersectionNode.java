# LinkedList
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //计算两个链表的长度，并求差值
        ListNode l1 = headA;
        ListNode l2 = headB;
        int lenA = 0;
        int lenB = 0;
        for(ListNode cur = l1 ; cur != null ; cur = cur.next){
            lenA++;
        }
        for(ListNode cur = l2 ; cur != null ; cur = cur.next){
            lenB++;
        }
        ListNode longer = l1;
        ListNode shorter = l2;
        int diff = lenA - lenB;
        //调整两个链表的长度及差值
        if(lenA < lenB){
            longer = l2;
            shorter = l1;
            diff = lenB - lenA;
        }
         //判空
        if(longer == null || shorter == null){
            return null;
        }
        //让长的先走两链表之差步
        for(int i = 0; i < diff ; i++){
            longer = longer.next;
        }
        //再同时向后遍历，不相同就一直往后遍历，如果有结点相同就跳出循环
        while(longer != shorter){
            longer = longer.next;
            shorter = shorter.next;  
        }
        //返回此结点
        return longer;
    }
