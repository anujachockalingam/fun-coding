package HackerRank.LinkedList;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class mergePoint {
    //https://www.youtube.com/watch?v=yuMEpwt-YB4

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the findMergeNode function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode curr1 = head1;
        SinglyLinkedListNode curr2 = head2;

        //same length thn common will match in position when you keep gng fwd

        while (curr1 != curr2) {

            curr1 = getNext(curr1, head2);
            curr2 = getNext(curr2, head1);
        }

        return curr1.data;

    }

    static SinglyLinkedListNode getNext(SinglyLinkedListNode curr, SinglyLinkedListNode head) {
        if (curr == null) {
            curr = head;
        } else {
            curr = curr.next;
        }
        return curr;
    }
}
