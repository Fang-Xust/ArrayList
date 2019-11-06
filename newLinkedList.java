import java.util.List;

class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {
    public ListNode head;
    public LinkedList(){
        this.head = null;
    }
    public void addFirst(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
        }
        ListNode cur = this.head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
    }
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while(cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }
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
    private ListNode searchIndex(int index){
        int count = 0;
        ListNode cur = this.head;
        while(count < index - 1){
            cur = cur.next;
            count++;
        }
        return cur;
    }
    public boolean addIndex(int index,int data){
        if(index < 0 || index > getLength()){
            System.out.println("下标错误");
            return false;
        }
        if(index == 0){
            addFirst(data);
            return true;
        }
        ListNode cur = searchIndex(index);
        ListNode node = new ListNode(data);
        node.next = cur.next;
        cur.next = node;
        return true;
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
    public ListNode reverseList(){
        ListNode prev = null;
        ListNode cur =this.head;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    public ListNode middleNode(ListNode head){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode FindKthToTail(ListNode head,int k){
        if(this.head == null || k <= 0){
            return null;
        }
        ListNode slow = this.head;
        ListNode fast = this.head;
        while(k - 1 > 0){
            if(fast.next !=null){
                fast = fast.next;
                k--;
            }else{
                return null;
            }
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
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
}
