package main.tree.bst;

import java.util.*;

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
//        if (root==null){
//            root = new Node(e);
//            size++;
//        }else
//            add(root, e);
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
     * 使用栈便利树，深度便利依照某个节点一直访问到最下面的节点
     * 先进先出的原因
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

    /**
     * 层序便利，一层一层的便利
     * 先进后出的原因
     */
    public void levelOrder() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll.e);
            if (null != poll.left)
                queue.add(poll.left);
            if (null != poll.right)
                queue.add(poll.right);
        }
    }

    /**
     * 删除最小元素
     *
     * @return
     */
    public E removeMin() {
        E e = minimu(root).e;
        root = removeMin(root);
        return e;
    }

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
     * 删除最大元素
     *
     * @return
     */
    public E removeMax() {
        E e = maxmu(root).e;
        root = removeMax(root);
        return e;
    }

    private Node maxmu(Node node) {
        if (null == node.right)
            return node;
        return minimu(node.right);
    }

    private Node removeMax(Node node) {
        if (null == node.right) {
            Node right = node.left;
            node.left = null;
            size--;
            return right;
        }
        node.right = removeMin(node.right);
        return node;
    }

    /**
     * 删除元素中的任意元素
     *
     * @param e 需要删除的元素
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (null == node)
            return null;
        if (e.compareTo(node.e) == 0) {

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
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
        } else {
            node.left = remove(node.left, e);
        }
        return node;
    }


    /**
     * 二叉树排序
     *
     * @return List
     */
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

    /**
     * 查询某个元素是否存在
     *
     * @param node node
     * @param e    e
     * @return boolean
     */
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

    /**
     * 查询某个元素是否存在
     *
     * @param node node
     * @param e    e
     * @return boolean
     */
    private boolean containsMy(Node node, E e) {
        if (null == node) {
            return false;
        } else if (e.compareTo(node.e) == 0) {
            return true;
        }
        return containsMy(node.left, e) || containsMy(node.right, e);
    }

    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
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
        if (e.compareTo(node.e) == 0)
            return null;
        if (e.compareTo(node.e) < 0)
            node.left = addMy(node.left, e);
        else
            node.right = addMy(node.right, e);
        return node;
    }

}
