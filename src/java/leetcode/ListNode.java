package leetcode;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/7
 * Time: 2:28 下午
 */
public class ListNode {
    Integer val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next==null){
            return val+"";
        }
        return val+"->"+next.toString();
    }
}