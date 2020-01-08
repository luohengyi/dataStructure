package main.array;


/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/28
 * Time: 10:48 下午
 */
public class Array<E> {
    private E[] data;
    private int size;

    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed. Array index < 0 || index > size");

        //扩容
        if (size == data.length)
            resize(2 * data.length);

        //所有从，要插入的下标开始，往后的元素开始全部向后挪一位。给对应的下标位置挪空
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E get(int index) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed. Array index < 0 || index > size");
        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst(){
        return get(0);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed. Array index < 0 || index > size");
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("add failed. Array index < 0 || index > size");
        E ret = data[index];
        for (int i = index + 1; i < size; i++)
            data[i - 1] = data[i];
        size--;
        data[size] = null;
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);

    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    /**
     * 交换2个下标的元素
     * @param i 下标
     * @param j 下标
     */
    public void swap(int i ,int j){
        if (i<0 || i>=size || j<0 || j>=0)
            throw new IllegalArgumentException(" error index is Illege ");
        E e = data[i];
        data[i] = data[j];
        data[j] = e;
    }
    @Override
    public String toString() {
        String back = String.format("Array: size=%d , capacity = %d", size, data.length) +
                "\n[";
        for (int i = 0; i < size; i++) {
            back += data[i];
            if (i != size - 1)
                back += ", ";
        }
        back += "]";
        return back;

    }
}
