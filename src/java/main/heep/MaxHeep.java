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

    /**
     * 维护最大堆的结构，使上级的节点永远大于下级的节点
     *
     * @param k 需要维护的节点下标
     */
    private void siftUp(int k) {
        //如果 当前值大于父亲节点的值，那么继续上浮操作
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            //交换值，向上浮动
            data.swap(k, parent(k));
        }
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("isEmpty");
        return data.get(0);
    }

    /**
     * 取出最大元素
     *
     * @return E
     */
    public E extractMax() {
        E ret = findMax();
        //首末元素交换
        data.swap(0, data.getSize() - 1);
        //删除末尾元素
        data.removeLast();

        siftDown(0);

        return ret;
    }

    private void siftDown(int k) {
        //左孩子的下标 大于等于 实际长度证明 到达了树的最底层 则不在循环
        while (leftChild(k) < data.getSize()) {

            // j 左节点 下标
            int j = leftChild(k);
            //右节点不为空 并且 右节点大约左节点
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                // j 等于 右节点下标
                j = rightChild(k);
            }
            //经过if判断后 此时data[j] 是 leftChild 和 rightChild中的最大值

            // 如果 父节点 大于 下级中国的最大值 跳出循环
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            // 和 下级中最大的节点交换值
            data.swap(k, j);
            // k下沉至后，新的下标
            k = j;
        }
    }
}
