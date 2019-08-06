//移除链表元素：删除链表中等于给定值 val 的所有节点。
class Solution {
    public ListNode removeElements(ListNode head, int val) {
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
}
