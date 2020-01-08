package main.map;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/12/16
 * Time: 2:15 下午
 */
public interface Map<K,V> {
    void add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key,V newValue);
    int getSize();
    boolean isEmpty();
}
