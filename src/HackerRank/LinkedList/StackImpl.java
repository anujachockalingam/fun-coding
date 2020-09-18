package HackerRank.LinkedList;

/**
 * @author c59785a
 * Created on 2020-09-14 20:27
 **/

class Node {
    int data;
    Node next;

    Node(int data){
        this.data= data;
        this.next = null;
    }
}

public class StackImpl {
    Node head;


    void push(int data) {

    Node newNode = new Node(data);
    newNode.next =head;
    head = newNode;
    }

    int pop() {
        Node remNode = head;
        head = head.next;
        return remNode.data;
    }
}

