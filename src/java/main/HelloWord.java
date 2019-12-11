package main;

import main.tree.bst.Bst;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/28
 * Time: 3:20 下午
 */
public class HelloWord {
    public static void main(String[] args) throws IOException {
//        Array<Integer> array = new Array<>();
//        for (int i = 0; i < 20; i++) {
//            array.add(i,i);
//        }
//        System.out.println(array);
//        for (int i = 15; i >0; i--) {
//            array.remove(i);
//        }
//        new ArrayList<>();
//        System.out.println(array);
//
//        Stack<Integer> arrayStack = new LinkedListStack<>();
//
//        arrayStack.push(4);
//        arrayStack.push(9);
//        arrayStack.push(2);
//        System.out.println(arrayStack);
//        arrayStack.pop();
//        System.out.println(arrayStack);

//        Queue<Integer> queue = new LinkekListQueue<>();
//
//        for (int i = 0; i < 20; i++) {
//            queue.enqueue(i);
//            System.out.println(queue);
//            if (i % 3 == 2) {
//                queue.dequeue();
//                System.out.println(queue);
//            }
//
//        }
//        LinkList<Integer> linkList  = new LinkList<>();
//        for (int i = 0; i < 10; i++) {
//            linkList.addFirst(i);
//            System.out.println(linkList);
//        }
//        linkList.add(0,66);
//        System.out.println(linkList);
//        linkList.remove(0);
//        System.out.println(linkList);

        Random r = new Random();
        Bst<Integer> bst = new Bst<>();
        for (int i = 0; i < 10; i++) {
            bst.add(r.nextInt(100));
        }
        List<Integer> integers = bst.preOrderList();
        System.out.println(bst.preOrderList());
        for (int i = 0; i < 10; i++) {
            int i1 = r.nextInt(integers.size());
            bst.remove(integers.get(i1));
            System.out.println(integers.get(i1));
            System.out.println(bst.preOrderList());
            integers=bst.preOrderList();
        }


    }


}
