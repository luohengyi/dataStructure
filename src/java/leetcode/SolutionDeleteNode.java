package leetcode;

/**
 * 删除链表中的元素
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/7
 * Time: 2:28 下午
 */

public class SolutionDeleteNode {


    public ListNode deleteNode(ListNode head, int val) {

        // 处理如果头节点就是 需要删除的val,单独处理，如果想省略，应该使用虚拟头节点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        ListNode prev = head;
        while (prev.next !=null){
            //删除节点
            if (prev.next.val == val){
                ListNode deleteNode = prev.next;
                prev.next = deleteNode.next;
                deleteNode.next=null;
            }else {
                //指针向下移动
                prev =prev.next;
            }

        }
        return head;
    }
}
