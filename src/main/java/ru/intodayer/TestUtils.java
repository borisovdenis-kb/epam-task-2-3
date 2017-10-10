package ru.intodayer;


public class TestUtils {
    public static <T> void assertArraysEquals(T[] expected, CustomList<T> actual) {
        int index = 0;
        for (T x : (FilteredLinkedList<T>) actual) {
            if (expected == null) {
                if (x != null)
                    throw new TestFailedException(
                            TestFailedException.getMessage(null, x)
                    );
                return;
            }
            if (!x.equals(expected[index]))
                throw new TestFailedException(
                        TestFailedException.getMessage(expected[index], x)
                );
            index++;
        }
    }

    public static <T> void assertEquals(T expected, T actual) {
        if (!expected.equals(actual))
            throw new TestFailedException(
                    TestFailedException.getMessage(expected, actual));
    }
}
