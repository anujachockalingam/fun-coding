package HackerRank.Stack;

import java.util.Stack;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueImpl {
    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack

            stackNewestOnTop.push(value);


        }

        public T peek() {
            updateOld();
            if (stackOldestOnTop.isEmpty()) {
                return null;
            } else {
                return stackNewestOnTop.peek();
            }
        }

        public T dequeue() {
            updateOld();
            if (stackOldestOnTop.isEmpty()) {
                return null;
            } else {
                return stackOldestOnTop.pop();
            }
        }

        public void updateOld() {
            if (stackOldestOnTop.isEmpty())
                while (!stackNewestOnTop.isEmpty()) {
                    stackOldestOnTop.push(stackNewestOnTop.pop());
                }
        }


        //-------------


        public void enqueue2(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek2() {
            prepOld();
            return stackOldestOnTop.peek();
        }

        public T dequeue2() {

            prepOld();
            return stackOldestOnTop.pop();

        }

        public void prepOld(){
            if (stackOldestOnTop.isEmpty())
                while(!stackNewestOnTop.isEmpty())
                    stackOldestOnTop.push(stackNewestOnTop.pop());
        }

    }



    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}