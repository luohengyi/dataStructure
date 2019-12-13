package main.set;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/12/11
 * Time: 1:47 下午
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
