# LinkedList
//链表分割
//编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
//注意：分割以后保持原来的数据顺序不变。
//思路：
//定义两个新链表，分别存放比x小的元素以及大于等于x的元素，分情况讨论，最后将两个链表连接起来。
//第一次在牛客网写这个代码，还是出了不少问题的，最后还是要好好想，才能写出来
public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode small = null;//定义两个新链表，分别存放比x小的元素以及大于等于x的元素
        ListNode smallLast = null;//记录两个链表的最后一个元素
        ListNode big = null;
        ListNode bigLast = null;
        ListNode cur = pHead;
        while(cur != null){//遍历链表
            if(cur.val < x){//如果小于x
                if(small == null){//如果small链表中没有结点直接把当前结点插进去
                    small = cur;
                }else{//如果small链表中有结点，则找到最后一个结点的next，把当前结点插进去
                    smallLast.next = cur;
                }
                smallLast = cur;//记录最后一个元素
            }else{
                if(big == null){
                    big = cur;
                }else{
                    bigLast.next = cur;
                }
                bigLast = cur;
            }
            cur = cur.next;//继续向后遍历
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
}

