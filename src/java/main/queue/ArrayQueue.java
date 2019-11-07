package main.queue;

import main.array.Array;
import main.queue.Queue;

/**
 * 数组队列
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/30
 * Time: 3:56 下午
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 添加元素，尾部
     * @param e 元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 拿出元素,头部
     * @return
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 查看队首的原属
     * @return E
     */
    @Override
    public E getFont() {
        return array.getFirst();
    }

    /**
     * 获取队列容积
     * @return int
     */
    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Queue: ");
        stringBuffer.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuffer.append(array.get(i));
            if (i != array.getSize() - 1)
                stringBuffer.append(",");

        }
        stringBuffer.append("]");

        return stringBuffer.toString();
    }
}
