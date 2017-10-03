package ru.intodayer;

import org.junit.jupiter.api.Test;
import ru.intodayer.LinkedList;
import static org.junit.jupiter.api.Assertions.*;


class LinkedListTest {
    private void checkLinks(LinkedList linkedList) {
        /* check of next links */
        try {
            for (Node x = linkedList.getFirst(); x != null; x = x.next) ;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }

        /* check of prev links */
        try {
            for (Node x = linkedList.getLast(); x != null; x = x.prev) ;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }

    @Test
    void clear() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("A");
        linkedList.addFirst("B");
        linkedList.addFirst("C");
        linkedList.addFirst("D");
        linkedList.clear();
        assertEquals(linkedList.getFirst(), null);
        assertEquals(linkedList.getLast(), null);
    }
    @Test
    void toArray() {
        String expected[] = {"Butch", "Mia", "Jules", "Vincent"};
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("Vincent");
        linkedList.addFirst("Jules");
        linkedList.addFirst("Mia");
        linkedList.addFirst("Butch");
        assertArrayEquals(expected, linkedList.toArray());
    }

    @Test
    void deleteFirst() {
        LinkedList One = new LinkedList();
        One.addFirst("Frodo");
        One.addFirst("Aragorn");
        One.addFirst("Gandalf");
        One.addFirst("Gimli");
        One.addFirst("Legolas");

        /* test1 */
        assertEquals("Legolas", One.deleteFirst().getData());
        assertEquals("Gimli", One.getFirst().getData());

        /* test2 */
        checkLinks(One);

        /* test3 */
        while (!One.isEmpty()) {
            One.deleteFirst();
        }
        assertEquals(null, One.getFirst());
        assertEquals(null, One.getLast());

        /* test4: lack of NullPointerException */
        LinkedList Two = new LinkedList();
        Two.addFirst("Frodo");
        Two.deleteFirst();
    }

    @Test
    void deleteLast() {
        LinkedList One = new LinkedList();
        One.addFirst("Frodo");
        One.addFirst("Aragorn");
        One.addFirst("Gandalf");
        One.addFirst("Gimli");
        One.addFirst("Legolas");

        /* test1 */
        assertEquals("Legolas", One.deleteLast().getData());
        assertEquals("Gimli", One.getLast().getData());

        /* test2 */
        checkLinks(One);

        /* test3 */
        while (!One.isEmpty()) {
            One.deleteLast();
        }
        assertEquals(One.getFirst(), null);
        assertEquals(One.getLast(), null);

        /* test4: lack of NullPointerException */
        LinkedList Two = new LinkedList();
        Two.addFirst("Frodo");
        Two.deleteLast();
    }

    @Test
    void delete() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("Thor");
        linkedList.addFirst("Hulk");
        linkedList.addFirst("Iron Man");
        linkedList.addFirst("Spider-Man");

        /* test1 */
        assertEquals("Hulk", linkedList.delete("Hulk").getData());
    }

    @Test
    void addFirst() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("Thor");
        linkedList.addFirst("Hulk");
        linkedList.addFirst("Iron Man");
        linkedList.addFirst("Spider-Man");

        /* test1 */
        assertEquals("Spider-man", linkedList.getFirst().getData());

        /* test2: checking of next/prev links */
        checkLinks(linkedList);
    }

    @Test
    void addBefore() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("Thor");
        linkedList.addFirst("Hulk");
        linkedList.addFirst("Iron Man");

        linkedList.addBefore("Iron Man","Spider-Man");
    }

}