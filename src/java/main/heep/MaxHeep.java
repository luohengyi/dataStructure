package main.heep;

import main.array.Array;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2020/1/8
 * Time: 10:20 上午
 * 最大堆
 */
public class MaxHeep<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeep(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeep() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 返回二叉树的数组表示中，一个索引所便是的父节点的索引
     *
     * @param index 索引
     * @return int 父亲节点的索引
     */
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent ");
        return (index - 1) / 2;
    }

    /**
     * 返回二叉树的数组表示中，一个索引所表示的节点的左孩子的索引
     *
     * @param index 索引
     * @return int 父亲节点的索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回二叉树的数组表示中，一个索引所表示的节点的右孩子的索引
     *
     * @param index 索引
     * @return int 父亲节点的索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }


    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        //如果 当前值大于父亲节点的值，那么继续上浮操作
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {

        }

    }

}
