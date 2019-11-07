package main.queue;

/**
 * 循环队列
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/30
 * Time: 4:29 下午
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    /**
     * 队首，队尾,大小
     */
    private int front, tail, size;

    /**
     * 容积会大1 因为 tail ==front 可以表示 队列为空，也能表示队列满了，所以容积+1
     *
     * @param capacity 容积
     */
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }

    /**
     * 在创建时容积+1了所以此处获取容积应减1
     *
     * @return int 容积大小
     */
    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        //判断容积是否足够
        if ((tail + 1) % data.length == front) {
            //由于正在的容积于长度存在1的差距所以此处使用 getCapacity() 方法获取容积
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //出队
    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E req = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return req;
    }

    //查看队首元素
    @Override
    public E getFont() {
        if (isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        return data[front];
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            //将原来的数组从队首元素开始，依次从0下标开始放入新的数组从
            //所以 下标0 的元素，应该是 0+front队首的位置（因为队首可能不在下标0的位置），由此推断出 下标i 元素是原来数组的 i+front 下标位置的元素
            //这样来看，如果原来的 队首不在下标0的位置 使用 i+front 的公式将获取不到 0到front 之间的元素 \n
            //而且 i+front 下标将会超出原来的数组的长度 \n
            // 这时使用 (i+front)%size 取余数获取0到front 之间的下标元素，而 front 到 data.length 之间的元素取余 \n
            //下标永远小于data.length 所以 (i+front)%size = (i+front) 从而正常的获取到元素
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Queue: ");
        stringBuffer.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            stringBuffer.append(data[i]);
            if ((i + 1) % data.length != tail)
                stringBuffer.append(",");

        }
        stringBuffer.append("]");

        return stringBuffer.toString();
    }
}
