package main;

import main.queue.LinkekListQueue;
import main.queue.Queue;
import main.stack.LinkedListStack;
import main.stack.Stack;
import main.tree.bst.Bst;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
            bst.add(i);
        }
//        System.out.println(bst.preOrderList());
        bst.preOrderNR();
    }


}
