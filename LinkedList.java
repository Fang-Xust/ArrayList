# LinkedList
import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    public String toString(){
        return String.format("ListNode(%d)",val);
    }
}
public class LinkedList {
    //头插
    private static ListNode pushFront(ListNode head, int val){
        ListNode node = new ListNode(val);
        node.next = head;
        return node;
    }
    //尾插
    private static ListNode pushBack(ListNode head, int val){
        ListNode node = new ListNode(val);
        if(head == null) {
            return node;
        }else {
            ListNode last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
            return head;
        }
    }
     //头删
    private static ListNode popFront(ListNode head){
        if(head == null){
            System.err.println("链表为空，无法删除");
            return null;
        }
        return head.next;
    }
    //尾删
    private static ListNode popBack(ListNode head){
        if(head == null){
            System.err.println("链表为空，无法删除");
            return null;
        }else{
            ListNode lastSecond = head;
            while(lastSecond.next.next != null){
                lastSecond = lastSecond.next;
            }
            lastSecond.next = null;
            return head;
        }
    }
    //在指定结点后面插入结点
    private static void pushAfter(ListNode pos, int val){
        ListNode node = new ListNode(val);
        node.next = pos.next;
        pos.next = node;
    }
    //删除指定结点后面的结点
    private static void popAfter(ListNode pos){
        pos.next = pos.next.next;
    }

    private static void printLinkedList(ListNode head){
        System.out.println("打印链表：");
        for (ListNode cur = head; cur != null; cur = cur.next) {
            System.out.print(cur + "-->");
        }
        System.out.println("null");
    }
    //移除链表指定元素
    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = null;
        ListNode cur = head;
        if(cur == null){//要判断链表是否为空，不然可能会报空指针异常
            return null;
        }
        while(cur != null){//这里循环写成这样，保证能遍历到最后一个结点
            if(cur.val == val){
                if(cur == head){//判断第一个结点是否是要删除的结点
                    head = cur.next;//如果是，则删除
                }else{//如果不是第一个结点，就说明前面有结点不是要删除的结点，
                    //下面的 prev = cre;就给prev赋值了，所以这里就不会报空指针异常了
                    prev.next= cur.next;
                }
            }else{
                prev = cur;
            }
            cur = cur.next;//让cur往后移继续遍历链表
        }
        return head;
    }
    //反转链表
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
    //找出链表的中间结点
    public static ListNode middleNode(ListNode head){
        ListNode node = head;
        int len = 0;
        for(;head != null;head = head.next){
            len++;
        }
        int mid = len / 2;
        for(int i = 0;i < mid;i++){
            node = node.next;
        }
        return node;
    }
    //找到链表倒数第k个结点
    public static ListNode FindKthToTail(ListNode head,int k){
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
    //合并两个有序链表
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null){
            cur.next = l2;
        }else if(l2 == null){
            cur.next = l1;
        }
        //上面的if语句可以写成cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
    //链表分割：编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前。
    public static ListNode partition(ListNode head, int x){
        ListNode small = null;
        ListNode smallLast = null;
        ListNode big = null;
        ListNode bigLast = null;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < x){
                if(small == null){
                    small = cur;
                }else{
                    smallLast.next = cur;
                }
                //更新最后一个结点为cur
                smallLast = cur;
            }else{
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur = cur.next;
        }
        if(small == null){
            return big;
        }else{
            smallLast.next = big;
            if(bigLast != null) {
                bigLast.next = null;
            }
            return small;
        }
    }
    //链表的回文结构
    public static boolean chkPalindrome(ListNode head){
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
    //求链表长度
    public static int getLength(ListNode head){
        int len = 0;
        for(ListNode cur = head; cur != null; cur = cur.next){
            len++;
        }
        return len;
    }
    //相交链表判断
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //计算两个链表的长度，并求差值
        ListNode l1 = headA;
        ListNode l2 = headB;
        int lenA = getLength(l1);
        int lenB = getLength(l2);
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
}
