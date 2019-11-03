class ListNode{
    public int data;
    public ListNode next;

    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class MyLinkedList {
    public ListNode head;

    public MyLinkedList(){
        this.head = null;
    }

    //链表头插法
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    //链表尾插法
    public void addTail(int data){
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

    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    //判断链表是否包含值为key的结点
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

    //找到下标index - 1位置的结点
    private ListNode searchIndex(int index){
        ListNode cur = this.head;
        int count = 0;
        while(count < index - 1){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //在下标index位置插入结点值
    public boolean addIndex(int index,int data){
        if(index < 0 || index > getLength()){
            System.out.println("下标错误");
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        //找到index - 1 位置的元素
        ListNode cur = searchIndex(data);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    //找到元素key的前驱结点并返回
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

    //删除第一次出现且值key的结点
    public void remove(int key){
        if(this.head == null){
            return;
        }
        if(this.head.data == key){
            this.head = this.head.next;
            return;
        }
        ListNode prev = searchPrev(key);
        if(prev == null){
            return;
        }
        ListNode del = prev.next;
        prev.next = del.next;
    }

    //删除链表中所有值为key的结点
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
                prev = prev.next;
                cur = cur.next;
            }
        }
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

    //反转链表
    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    //单链表的中间节点：双引用法
    public ListNode middleNode(ListNode head){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //找到链表倒数第K个结点，
    //思路：双引用法，先让fast走K - 1步，再让slow和fast同时往后走，
    // 当fast.next == null时，slow所在结点就是倒数第K个结点，可以画图看一下
    public ListNode FindKthToTail(ListNode head,int k){
        if(this.head == null || k <= 0){
            return null;
        }
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(k - 1 > 0){
            if(fast.next != null){
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

    //链表分割
    public ListNode partition(int x){
        return null;
    }

    //删除链表重复结点
    public ListNode deleteDuplication(){
        ListNode node = new ListNode(-1);
        ListNode cur = this.head;
        ListNode tmp = node;
        while(cur != null){
            if(cur.next != null && cur.data == cur.next.data){
                while(cur.next != null && cur.data == cur.next.data){
                    cur = cur.next;
                }//退出循环，cur要多走一步
                cur = cur.next;
            }else{
                //当前节点 不等于下一个节点的时候
                tmp.next = cur;
                cur = cur.next;
                tmp = tmp.next;
            }
        }
        tmp.next = cur;//tmp.next = null;
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
        //反转链表的的后半部分
        ListNode current = slow;
        ListNode prev = null;
        while(current != null){
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        //定义两个结点记录头，和尾，开始从两端比较
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

    //判断链表是否有环
    public boolean hasCycle(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(slow != null && fast != null){
            if(fast.next == null){
                return false;
            }
            slow =slow.next;
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
        while(fast != slow && fast != null && slow != null){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

}
