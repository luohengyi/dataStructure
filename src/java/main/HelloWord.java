package main;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/10/28
 * Time: 3:20 下午
 */
public class HelloWord {
    public static void main(String[] args) {
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
//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//
//        arrayStack.push(4);
//        arrayStack.push(9);
//        arrayStack.push(2);
//        System.out.println(arrayStack);
//        arrayStack.pop();
//        System.out.println(arrayStack);

        Queue<Integer> queue = new LoopQueue<>();

        for (int i = 1; i < 20; i++) {
            queue.enqueue(i);
            if (i%3==0){
                System.out.println(queue.dequeue());
                System.out.println(queue);
            }
        }
        System.out.println(queue);


    }


}
