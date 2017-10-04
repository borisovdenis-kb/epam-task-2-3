package ru.intodayer;


import java.util.Iterator;
import java.util.Scanner;

public class App {
    public static void main(String args[]) {
        LinkedList<Integer> linkedList = new LinkedList<Integer>((x) -> (x > 5));
        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.print("1-add first, 2-add last, 3-add before, 4-delete first, " +
                            "5-delete last, 6-delete, 7-clear: ");

            int decision = in.nextInt();
            if (decision == 100500) break;

            switch (decision) {
            case 1:
                System.out.print(": ");
                linkedList.addFirst(in.nextInt());
                break;
            case 2:
                System.out.print(": ");
                linkedList.addLast(in.nextInt());
                break;
            case 3:
                System.out.print(": ");
                Integer key = in.nextInt();
                System.out.print(": ");
                Integer data = in.nextInt();
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
                linkedList.delete(in.nextInt());
                break;
            case 7:
                linkedList.clear();
            }
            System.out.println(linkedList);
        }

        Iterator<Integer> itr = linkedList.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
