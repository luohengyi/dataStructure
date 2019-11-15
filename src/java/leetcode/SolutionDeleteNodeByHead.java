package leetcode;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/15
 * Time: 10:06 上午
 * 使用虚拟头节点删除元素
 */
public class SolutionDeleteNodeByHead {

    public ListNode deleteNode(ListNode head, int val) {
        //虚拟头节点不会被访问，值无所谓
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next=head;

        ListNode prev = dummyHead.next;
        while (prev.next != null) {
            //删除节点
            if (prev.next.val == val) {
                ListNode deleteNode = prev.next;
                prev.next = deleteNode.next;
                deleteNode.next = null;
            } else {
                //指针向下移动
                prev = prev.next;
            }

        }
        return dummyHead.next;
    }

}
