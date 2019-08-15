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
}
