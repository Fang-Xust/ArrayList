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
}
