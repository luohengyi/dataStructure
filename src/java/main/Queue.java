package main;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/30
 * Time: 3:54 下午
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFont();


}
