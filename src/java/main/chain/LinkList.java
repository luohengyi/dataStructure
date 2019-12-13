package main.chain;

/**
 * 单向连标
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/2
 * Time: 5:10 下午
 */
public class LinkList<E> {

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

    //    private Node head;
    //虚拟头节点为了解决在链表中间位置插入元素时，传入下标为0时，每次都要做特殊处理，从而需要判断的文同
    private Node dummyHead;
    private int size;

    public LinkList() {
        this.dummyHead = new Node(null, null);
        this.size = 0;
    }

    //获取元素个数

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index error index<0 || index>size");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //将上一个元素指向E，将E的下一个元素指向，上一个元素的next
        //Node node = new Node(e);
        //node.next = prev.next;
        //prev.next = node;
        //简化写法，
        prev.next = new Node(e, prev.next);
        size++;
    }

    //在链表头部插入元素E
    public void addFirst(E e) {
        add(0, e);
    }

    //在尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //获取元素
    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index error index<0 || index>size");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    // 获取链表的最后一个元素
    public E getFirst() {
        return get(0);
    }

    //获取最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //修改元素
    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index error index<0 || index>size");
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    //判断是否拥有某个元素
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("index error index<0 || index>size");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //让要删除的索引的上一个元素的next指向需要删除的元素的next；
        //需要删除的元素的next = null 解除引用
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size);
    }

    public void removeElement(E e) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.e.equals(e)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next=null;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }
        res.append("NUll");
        return res.toString();
    }
}
