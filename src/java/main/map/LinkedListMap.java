package main.map;

import main.chain.LinkList;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/12/16
 * Time: 2:24 下午
 * 使用链表实现的映射
 */
public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    //虚拟头节点为了解决在链表中间位置插入元素时，传入下标为0时，每次都要做特殊处理，从而需要判断的文同
    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (null == node) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead.next;
        while (null != prev.next) {
            if (prev.next.key.equals(key)) {
                break;
            }
            prev = prev.next;
        }
        if (null != prev.next) {
            Node del = prev.next;
            prev.next = del.next;
            del.next=null;
            return del.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return null != getNode(key);
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (null == node) {
            throw new IllegalArgumentException(key + "key doesn't exit");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (null != cur) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
}
