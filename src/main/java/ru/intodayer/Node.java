package ru.intodayer;


public class Node {
    private String data;
    public Node next;
    public Node prev;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return data;
    }
}