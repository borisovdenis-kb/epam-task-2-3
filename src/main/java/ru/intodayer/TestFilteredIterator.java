package ru.intodayer;

import java.util.function.Predicate;
import java.util.Arrays;
import java.util.List;


public class TestFilteredIterator {
    private <T> Predicate<T> getPredicate(T... exclusion) {
        Predicate<T> filter = (x) -> {
            List<T> notAllowed = Arrays.asList(exclusion);
            return notAllowed.contains(x);
        };
        return filter;
    }

    private void testCase1() {
        Predicate<String> filter = getPredicate("Haskel", "PHP", "Fortran");
        CustomList<String> list = new FilteredLinkedList<>(filter);
        list.addLast("Fortran");
        list.addLast("Java");
        list.addLast("C++");
        list.addLast("Haskel");
        list.addLast("Python");
        list.addLast("PHP");
        TestUtils.assertArraysEquals(new String[] {"Java", "C++", "Python"}, list);
    }

    private void testCase2() {
        Predicate<Integer> filter = getPredicate(1, 5, 100);
        CustomList<Integer> list = new FilteredLinkedList<>(filter);
        list.addLast(1);
        list.addLast(5);
        list.addLast(100);
        list.addLast(5);
        list.addLast(1);
        TestUtils.assertArraysEquals(null, list);
    }

    public void runTests() {
        testCase1();
        testCase2();
        System.out.println("All FilteredIterator tests are passed.");
    }
}
