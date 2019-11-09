import java.util.List;

class ListNode{
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
class MySingleList {
    public ListNode head;

    public MySingleList(){
        this.head = null;
    }

    //头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            head = node;
        }else {
            node.next = head;
            head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        ListNode node = new ListNode(data);
        ListNode cur = this.head;
        if(this.head == null){
            head = node;
        }else{
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    /**
     * 找到index-1的位置
     * @param index
     * @return
     */
    private ListNode searchIndex(int index) {
        ListNode cur = this.head;
        //cur -> index-1
        int count = 0;
        while(count < index - 1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index,int data){
        if(index <  0 || index > getLength()) {
            System.out.println("index不合法！");
            return false;
        }
        if(index == 0) {
            addFirst(data);
            return true;
        }
        //找到indext - 1 的位置
        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    private ListNode searchPrev(int key){
        ListNode cur = this.head;
        while(cur.next != null){
            if(cur.next.data == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head == null){
            return;
        }
        if(this.head.data == key){
            this.head = this.head.next;
        }
        ListNode prev = searchPrev(key);
        if(prev == null){
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(this.head.data == key){
            head = head.next;
        }
        ListNode prev = this.head;
        ListNode cur = prev.next;
        while(cur != null){
            if(prev.next.data == key){
                prev.next = cur.next;
                cur = cur.next;
            }
            if(prev.next.data != key){
                prev = cur;
                cur = cur.next;
            }
        }
    }
    //得到单链表的长度
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public void display(){
        ListNode cur = this.head;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void display2(ListNode newHead){
        ListNode cur = newHead;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //防止内存泄漏
    public void clear(){
        this.head = null;
        //单链表中置空，下面的也可以，这个也可以,双向链表中用上面的暴力法不行
//        //一个一个置为空
//        while(this.head != null){
//            ListNode cur = this.head.next;
//            this.head.next = null;
//            this.head = cur;
//        }
    }
    //反转链表
    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode curNext = null;
        while(cur != null){
            curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    //单链表的中间节点
    public ListNode middleNode(ListNode head) {
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //链表的倒数第K个结点
    public ListNode FindKthToTail(ListNode head,int k){
        if(this.head == null || k <= 0){
            return null;
        }
        ListNode fast = this.head;
        ListNode slow = this.head;
        while(k - 1 > 0){
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode partition(ListNode pHead, int x){
        ListNode small = null;//定义两个新链表，分别存放比x小的元素以及大于等于x的元素
        ListNode smallLast = null;//记录两个链表的最后一个元素
        ListNode big = null;
        ListNode bigLast = null;
        ListNode cur = pHead;
        while(cur != null){//遍历链表
            if(cur.data < x){//如果小于x
                if(small == null){//如果small链表为空，直接把cur放进去
                    small = cur;
                }else{//如果small链表不为空，把cur放在small链表最后
                    smallLast.next = cur;
                }
                smallLast = cur;//更新小链表最后一个元素
            }else{//同理如果大于x
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;//更新大链表最后一个元素
            }
            cur = cur.next;//继续往后遍历
        }
        if(small == null){
            return big;
        }else{
            smallLast.next = big;//连接两个链表作为最终结果并返回
            if(bigLast != null){
                bigLast.next = null;
            }
            return small;
        }
    }
    //删除链表重复结点
    public ListNode deleteDuplication(){
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while(cur != null){
            if(cur.next != null && cur.data == cur.next.data){
                while (cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }
                cur = cur.next;
            }else{
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next = null;
        return node.next;
    }
    //链表的回文结构
    public boolean chkPalindrome(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode cur = slow;
        ListNode prev = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur =next;
        }
        ListNode pHead = this.head;
        ListNode last = prev;
        boolean flag = true;
        while(last != null){
            if(pHead.data != last.data){
                flag = false;
                break;
            }
            pHead = pHead.next;
            last = last.next;
        }
        return flag;
    }
    //链表是否带环
    public boolean hasCycle(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(slow != null && fast != null){
            if(fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    //找到带环链表的入环点
    public ListNode detectCycle(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(slow != null && fast != null){
            if(fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
            if(slow == null || fast == null){
                return null;
            }
        }
        fast = this.head;
        while(slow != fast && slow != null && fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    //合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode node = new ListNode(-1);
        ListNode tmp = node;
        while(l1 != null && l2 != null){
            if(l1.data < l2.data){
                tmp.next = l1;
                l1 = l1.next;
                tmp = tmp.next;
            }else{
                tmp.next = l2;
                l2 = l2.next;
                tmp = tmp.next;
            }
        }
        if(l1 == null){
            tmp.next = l2;
        }
        if(l2 == null){
            tmp.next = l1;
        }
        return node.next;
    }
}
