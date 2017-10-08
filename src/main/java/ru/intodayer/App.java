package ru.intodayer;


import java.util.*;
import java.util.function.Predicate;

public class App {
    public static void showUserInterface() {
        System.out.print(
            "Now you are testing custom LinkedList.\n" +
            "Available operations:\n" +
            "1 - add first\n"    + "2 - add last\n" +
            "3 - add before\n"   + "4 - delete first\n" +
            "5 - delete last\n"  + "6 - delete\n" +
            "7 - clear\n"        + "8 - iterator\n" +
            "9 - map\n"          + "stop - break a cycle\n\n" +
            "Choose operation: "
        );
    }

    public static void main(String args[]) {
        Predicate<Integer> condition = (x) -> {
            Integer[] array = {1, 5, 9};
            List<Integer> notAllowed = Arrays.asList(array);
            return notAllowed.contains(x);
        };
        MapInterface<Integer, String> toString = new MapInterface<Integer, String>() {
            @Override
            public String map(Integer element) {
                return String.valueOf(element) + "#";
            }
        };

        LinkedList<Integer> linkedList = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        while (true) {
            showUserInterface();

            String decision = in.next();
            if (decision.equals("stop")) break;

            switch (decision) {
                case "1":
                    System.out.print(": ");
                    linkedList.addFirst(in.nextInt());
                    break;
                case "2":
                    System.out.print(": ");
                    linkedList.addLast(in.nextInt());
                    break;
                case "3":
                    System.out.print(": ");
                    Integer key = in.nextInt();
                    System.out.print(": ");
                    Integer data = in.nextInt();
                    linkedList.addBefore(key, data);
                    break;
                case "4":
                    linkedList.deleteFirst();
                    break;
                case "5":
                    linkedList.deleteLast();
                    break;
                case "6":
                    System.out.print(": ");
                    linkedList.delete(in.nextInt());
                    break;
                case "7":
                    linkedList.clear();
                case "8":
                    Iterator<Integer> itr = linkedList.iterator();
                    while (itr.hasNext()) {
                        System.out.println(itr.next());
                    }
                    break;
                case "9":
                    LinkedList<String> mappedList = linkedList.map(toString);
                    System.out.println("Mapped list: " + mappedList);
                    break;
                default:
                    break;
            }
            System.out.println();
            System.out.println(linkedList);
            System.out.println();
        }
    }
}
