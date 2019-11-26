package main.tree.bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/20
 * Time: 10:56 上午
 */
public class Bst<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public Bst() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    //添加入口
    public void add(E e) {
        root = addMy(root, e);
    }

    /**
     * 查看是否包含某个元素
     *
     * @param e 元素
     * @returnv boolean
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    public void preOrder() {
        preOrder(root);
    }

    //前序便利
    private void preOrder(Node node) {
        if (null == node)
            return;
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序便利
    private void inOrder(Node node) {
        if (null == node)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后期序便利
    private void postOrder(Node node) {
        if (null == node)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 使用栈便利树
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            System.out.println(pop.e);
            if (null != pop.left)
                stack.push(pop.left);
            if (null != pop.right)
                stack.push(pop.right);
        }
    }


    public List<E> preOrderList() {
        return preOrderList(root);
    }

    private List<E> preOrderList(Node node) {
        if (null == node)
            return null;
        ArrayList<E> objects = new ArrayList<>();
        List<E> left = preOrderList(node.left);
        if (null != left) {
            objects.addAll(left);
        }
        objects.add(node.e);
        List<E> right = preOrderList(node.right);
        if (null != right) {
            objects.addAll(right);
        }
        return objects;
    }


    private boolean contains(Node node, E e) {
        if (null == node) {
            return false;
        } else if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //我自己的
    private boolean containsMy(Node node, E e) {
        if (null == node) {
            return false;
        } else if (e.compareTo(node.e) == 0) {
            return true;
        }
        return contains(node.left, e) || contains(node.right, e);
    }

    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            return;
        }

        if (e.compareTo(node.e) < 0)
            add(node.left, e);
        else
            add(node.right, e);
    }

    private Node addMy(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = addMy(node.left, e);
        else
            node.right = addMy(node.right, e);
        return node;
    }

}
