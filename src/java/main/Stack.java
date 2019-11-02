package main;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/29
 * Time: 10:48 下午
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
