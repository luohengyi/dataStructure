package main;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/29
 * Time: 10:49 下午
 */
public class ArrayStack<E> implements Stack<E> {
    Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
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

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("Stack: ");
        stringBuffer.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuffer.append(array.get(i));
            if (i != array.getSize() - 1)
                stringBuffer.append(",");

        }
        stringBuffer.append("] top");

        return stringBuffer.toString();
    }
}
