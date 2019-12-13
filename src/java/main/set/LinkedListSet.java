package main.set;

import main.chain.LinkList;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/12/11
 * Time: 4:07 下午
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkList<E> linkList = new LinkList<>();
    @Override
    public void add(E e) {
        if (!linkList.contains(e))
            linkList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkList.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkList.contains(e);
    }

    @Override
    public int getSize() {
        return linkList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }
}
