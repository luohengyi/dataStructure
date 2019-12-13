package main.set;

import main.tree.bst.Bst;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/12/11
 * Time: 1:54 下午
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{

    private Bst<E> bst=new Bst<>();

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
    bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
