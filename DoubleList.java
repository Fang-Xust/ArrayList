import java.util.List;

class ListNode{
    public int data;
    public ListNode prev;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
    }
}
public class DoubleList {
    public ListNode head;
    public ListNode last;
    public DoubleList(){
        this.head = null;
        this.last = null;
    }
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
               node.next = this.head;
               this.head.prev = node;
               this.head = node;
        }
    }
    public void addLast(int data){
        ListNode node = new ListNode(data);
        if(this.head == null){
            this.head = node;
            this.last = node;
        }else{
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
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
    private ListNode searchIndex(int index){
        int count = 0;
        ListNode cur = this.head;
        while(count < index){
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
        if(index == getLength()){
            addLast(data);
            return true;
        }
        ListNode cur = searchIndex(index);
        if(cur == null){
            return false;
        }
        ListNode node = new ListNode(data);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
        return true;
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
    //删除第一次出现关键字为key的节点
    public int remove(int key){
        int oldData = -1;//存储要删除的数字
        ListNode cur = this.head;
        while(cur != null){
            if(cur.data == key){
                oldData = cur.data;
                //头
                if(cur == this.head){
                    this.head = this.head.next;
                    this.head.prev = null;
                    return oldData;
                }else{
                    cur.prev.next = cur.next;
                    if(cur.next != null){
                        cur.next.prev = cur.prev;
                    }else{//尾
                        this.last = cur.prev;
                    }
                    return oldData;
                }
            }
            cur = cur.next;
        }
        return -1;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {//尾
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
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

    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        doubleList.addFirst(1);
        doubleList.addFirst(1);
        doubleList.addFirst(2);
        doubleList.addFirst(3);
        doubleList.addFirst(3);
        doubleList.addFirst(4);
        doubleList.addIndex(0,99);
        doubleList.addFirst(5);
        doubleList.addFirst(5);
        //5 99 4 3 2 1
        doubleList.addIndex(2,199);
        System.out.println(doubleList.remove(4));
        doubleList.display();
        doubleList.removeAllKey(1);
        doubleList.display();
    }
}
