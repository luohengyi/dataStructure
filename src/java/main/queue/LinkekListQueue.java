package main.queue;

import main.chain.LinkList;

/**
 * 双向连标
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/4
 * Time: 4:35 下午
 */
public class LinkekListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //入队操作
    @Override
    public void enqueue(E e) {
        if (null == tail) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("isEmpty");
        Node reNode = head;
        head = head.next;
        //从断点中断开 reNode;
        reNode.next = null;
        //如果链表中只有一个元素，head和tail指向统一个元素，当移除head后，tail也应该指向null
        if (null == head)
            tail = null;
        size--;
        return reNode.e;
    }

    @Override
    public E getFont() {
        if (isEmpty())
            throw new IllegalArgumentException("isEmpty");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        res.append("queue font ");
        for (Node cur = head.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }
        res.append("NUll");
        return res.toString();
    }
}
