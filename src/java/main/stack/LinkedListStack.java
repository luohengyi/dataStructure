package main.stack;

import main.chain.LinkList;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/3
 * Time: 10:55 下午
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkList<E> linkList;

    public LinkedListStack() {
        this.linkList = new LinkList<>();
    }


    @Override
    public int getSize() {
        return linkList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkList.addFirst(e);
    }

    @Override
    public E pop() {
         return linkList.removeFirst();
    }

    @Override
    public E peek() {
        return linkList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(linkList);
        return  res.toString();
    }
}
