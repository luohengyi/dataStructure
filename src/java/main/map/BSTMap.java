package main.map;

import main.tree.bst.Bst;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/12/18
 * Time: 8:55 上午
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;


    public BSTMap() {
        size = 0;
        root = null;
    }

    public Node getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0 健相同
            node.value = value;
        return node;
    }

    /**
     * 获取 key 所在的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;
        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if (key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    @Override
    public boolean contains(K key) {
        return null != getNode(root, key);
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (null == node)
            throw new IllegalArgumentException(key + " doesn't exits");
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    //返回最小的节点
    private Node minimu(Node node) {
        if (null == node.left)
            return node;
        return minimu(node.left);
    }

    private Node removeMin(Node node) {
        if (null == node.left) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }


    /**
     * 删除元素中的任意元素
     *
     * @param key 需要删除的元素
     */
    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (null != node) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (null == node)
            return null;
        if (key.compareTo(node.key) == 0) {

            //待删除的节点左子树为空
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                return rightNode;
            }
            //待删除的节点右节点为空
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = node;
                return leftNode;
            }
            //待删除的节点左右都不为空,找到后继节点顶替该节点。后继节点为大于该节点最接近的一个节点
            //后继节点为右节点的最小节点
            Node successor = minimu(node.right);
            //后继节点的右节点是->待删除的节点的右节点删除最小节点后的根节点
            //就是 待删除的节点的右节点删除最小值后的那个树
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            size--;
            return successor;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
        } else {
            node.left = remove(node.left, key);
        }
        return node;
    }
}
