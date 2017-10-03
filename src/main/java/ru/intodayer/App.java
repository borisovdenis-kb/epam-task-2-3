package ru.intodayer;


import java.util.Scanner;

public class App {
    public static void main(String args[]) {
        LinkedList linkedList = new LinkedList();
        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.print("1-add first, 2-add last, 3-add before, 4-delete first, 5-delete last, 6-delete: ");
            switch (in.nextInt()) {
            case 1:
                System.out.print(": ");
                linkedList.addFirst(in.next());
                break;
            case 2:
                System.out.print(": ");
                linkedList.addLast(in.next());
                break;
            case 3:
                System.out.print(": ");
                String key = in.next();
                System.out.print(": ");
                String data = in.next();
                linkedList.addBefore(key, data);
                break;
            case 4:
                linkedList.deleteFirst();
                break;
            case 5:
                linkedList.deleteLast();
                break;
            case 6:
                System.out.print(": ");
                linkedList.delete(in.next());
                break;
            }
            System.out.println(linkedList);
        }
    }
}
