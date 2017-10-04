package ru.intodayer;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;


class LinkedListTest {
    private final Predicate<String> conditionStr = (x) -> x.equals("<epam>");
    private final Predicate<Integer> conditionInt = (x) -> x.equals(5);

    private void checkLinks(LinkedList<?> linkedList) {
        /* check of next links */
        try {
            for (Node<?> x = linkedList.getFirst(); x != null; x = x.next) ;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        /* check of prev links */
        try {
            for (Node<?> x = linkedList.getLast(); x != null; x = x.prev) ;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Test
    void clear() {
        LinkedList<String> linkedList = new LinkedList<>(conditionStr);
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        linkedList.addFirst("D");
        linkedList.clear();
        assertEquals(null, linkedList.getFirst());
        assertEquals(null, linkedList.getLast());
    }

    @Test
    void testDifferentTypes() {
        /* test #1: with String */
        LinkedList<String> stringList = new LinkedList<>(conditionStr);
        stringList.addFirst("A");
        stringList.addLast("B");
        stringList.addBefore("B", "C");
        assertEquals("A", stringList.getFirst().getData());

        stringList.deleteFirst();
        stringList.deleteLast();
        assertEquals("C", stringList.delete("C").getData());
        assertEquals(null, stringList.getFirst());
        assertEquals(null, stringList.getLast());

        /* test #2: with Integer */
        LinkedList<Integer> integerList = new LinkedList<Integer>(conditionInt);
        integerList.addFirst(1);
        integerList.addLast(2);
        integerList.addBefore(2, 3);
        assertEquals(new Integer(1), integerList.getFirst().getData());

        integerList.deleteFirst();
        integerList.deleteLast();
        assertEquals(new Integer(3), integerList.delete(3).getData());
        assertEquals(null, integerList.getFirst());
        assertEquals(null, integerList.getLast());
    }

    @Test
    void deleteFirst() {
        LinkedList<String> One = new LinkedList<String>(conditionStr);
        One.addFirst("Frodo");
        One.addFirst("Aragorn");
        One.addFirst("Gandalf");
        One.addFirst("Gimli");
        One.addFirst("Legolas");

        // test #1
        assertEquals("Legolas", One.deleteFirst().getData());
        assertEquals("Gimli", One.getFirst().getData());

        // test #2
        checkLinks(One);

        // test #3
        while (!One.isEmpty()) {
            One.deleteFirst();
        }
        assertEquals(null, One.getFirst());
        assertEquals(null, One.getLast());

        // test4: lack of NullPointerException
        LinkedList<String> Two = new LinkedList<>(conditionStr);
        Two.addFirst("Frodo");
        Two.deleteFirst();
    }

    @Test
    void deleteLast() {
        LinkedList<String> One = new LinkedList<>(conditionStr);
        One.addFirst("Frodo");
        One.addFirst("Aragorn");
        One.addFirst("Gandalf");
        One.addFirst("Gimli");
        One.addFirst("Legolas");

        // test #1
        assertEquals("Legolas", One.deleteLast().getData());
        assertEquals("Gimli", One.getLast().getData());

        // test #2
        checkLinks(One);

        // test #3
        while (!One.isEmpty()) {
            One.deleteLast();
        }
        assertEquals(null, One.getFirst());
        assertEquals(null, One.getLast());

        // test4: lack of NullPointerException
        LinkedList<String> Two = new LinkedList<>(conditionStr);
        Two.addFirst("Frodo");
        Two.deleteLast();
    }

    @Test
    void delete() {
        LinkedList<String> linkedList = new LinkedList<>(conditionStr);
        linkedList.addFirst("Thor");
        linkedList.addFirst("Hulk");
        linkedList.addFirst("Iron Man");
        linkedList.addFirst("Spider-Man");

        // test #1: delete from the "middle"
        assertEquals("Hulk", linkedList.delete("Hulk").getData());

        // test #2: checking of next/prev links
        checkLinks(linkedList);

        // test #3: delete while list is not empty
        while (!linkedList.isEmpty()) {
            linkedList.delete(linkedList.getFirst().getData());
        }
        assertEquals(null, linkedList.getFirst());
        assertEquals(null, linkedList.getLast());
    }

    @Test
    void addFirst() {
        LinkedList<String> listOne = new LinkedList<>(conditionStr);
        listOne.addFirst("Thor");
        listOne.addFirst("Hulk");
        listOne.addFirst("Iron Man");
        listOne.addFirst("Spider-Man");
        assertEquals("Spider-man", listOne.getFirst().getData());
    }

    @Test
    void addBefore() {
        LinkedList<String> linkedList = new LinkedList<>(conditionStr);
        linkedList.addFirst("Thor");

        // test #1: with 1 node [Thor]
        linkedList.addBefore("Thor", "Hulk");
        assertEquals("Hulk", linkedList.getFirst().getData());

        linkedList.clear();

        // test #2: adds the same element as already existed
        linkedList.addBefore("Tanos", "Tanos");
        linkedList.addBefore("Tanos", "Tanos");
        assertEquals("Tanos", linkedList.getFirst().getData());
        checkLinks(linkedList);
    }

}