package ru.intodayer;

import java.util.Iterator;

public class LinkedListIterator implements Iterator<Object> {
    private LinkedList linkedList;
    private Node current;

    public LinkedListIterator(LinkedList linkedList) {
        this.linkedList = linkedList;
        this.current = linkedList.getFirst();
    }

//    @Override
    public boolean hasNext() {
        return !(current.next == null);
    }

    public Node next() {
        Node tmp = current;
        current = current.next;
        return tmp;
    }

    public void remove() {
        linkedList.delete(current.getData());
    }
}
