package leetcode;

/**
 * 删除链表中的元素
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/7
 * Time: 2:28 下午
 */

public class SolutionDeleteNode {

    public static ListNode recursiveDelete1(ListNode head, int val) {
        recursiveDelete(head, val);
        return head;
    }


    public static void recursiveDelete(ListNode head, int val) {
        if (null == head.next) {
            return;
        }
        ListNode prev = head;
        //删除节点
        if (prev.next.val == val) {
            ListNode deleteNode = prev.next;
            prev.next = deleteNode.next;
            deleteNode.next = null;
        } else {
            //指针向下移动
            prev = prev.next;
        }
        recursiveDelete(prev, val);
    }

    public static ListNode recursiveDelete2(ListNode head, int val) {
        if (null == head.next) {
            return null;
        }
        ListNode res = recursiveDelete2(head.next, val);
        if (head.val == val)
            //返回下级元素，从而删除当前元素
            return res;
        else {
            //head.next携带的是原来没有删除val元素的链表，替换为 res 已经删除val元素的链表
            head.next = res;
            return head;
        }
    }

    public static ListNode recursiveDelete3(ListNode head, int val) {
        if (null == head) {
            return null;
        }
        head.next = recursiveDelete2(head.next, val);
        return head.val == val ? head.next : head;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode next1 = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        listNode.next = next1;
        next1.next = next2;
        next2.next = next3;

        System.out.println(listNode);
        System.out.println(recursiveDelete2(listNode, 3));
    }

    public ListNode deleteNode(ListNode head, int val) {

        // 处理如果头节点就是 需要删除的val,单独处理，如果想省略，应该使用虚拟头节点
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        ListNode prev = head;
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
        return head;
    }
}
