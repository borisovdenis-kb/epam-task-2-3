package ru.intodayer;


public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    public LinkedList() {
    }

    public boolean isEmpty() {
        return first == null;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (first == null) {
            last = newNode;
            first = newNode;
        } else {
            first.prev = newNode;
            newNode.next = first;
            newNode.prev = null;
            first = newNode;
            size++;
        }
    }

    public void addLast(String data) {
        Node newNode = new Node(data);
        if (last == null) {
            last = newNode;
            first = newNode;
        }
        last.next = newNode;
        newNode.prev = last;
        newNode.next = null;
        last = newNode;
        size++;
    }
    
    public void addBefore(String key, String data) {
        Node newNode = new Node(data);
        Node current = first;
        while (current != null && !current.getData().equals(key)) {
            current = current.next;
        }
        if (current == null) {
            addLast(data);
        } else if (current.prev == null) {
            addFirst(data);
        } else {
            current.prev.next = newNode;
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    public Node deleteFirst() {
        Node tmp = first;
        if (last == first) {
            last = null;
            first = null;
            return tmp;
        }
        first = first.next;
        first.prev = null;
        size--;
        return tmp;
    }

    public Node deleteLast() {
        Node tmp = last;
        if (last == first) {
            last = null;
            first = null;
            return tmp;
        }
        last = last.prev;
        last.next = null;
        size--;
        return tmp;
    }

    public Node delete(String key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.getData().equals(key)) {
                if (x == first) {
                    return deleteFirst();
                } else if (x == last) {
                    return deleteLast();
                } else {
                    x.prev.next = x.next;
                    x.next.prev = x.prev;
                }
                size--;
                return x;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
    }

    public String[] toArray() {
        String array[] = new String[size];
        int i = 0;
        for (Node x = first; x != null; x = x.next) {
            array[i++] = x.getData();
        }
        return array;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder stringBuilder = new StringBuilder("null<--");
        for (Node x = first; x != null; x = x.next) {
            stringBuilder.append("[" + x.getData() + "]");
            if (x.next == null) {
                stringBuilder.append("-->null");
            } else {
                stringBuilder.append("<-->");
            }
        }
        return stringBuilder.toString();
    }
}