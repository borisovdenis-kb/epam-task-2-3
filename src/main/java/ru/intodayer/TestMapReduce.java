package ru.intodayer;


public class TestMapReduce {
    private void testMap() {
        MapInterface<Integer, String> addString = new MapInterface<Integer, String>() {
            @Override
            public String map(Integer element) {
                return String.valueOf(element) + "#";
            }
        };
        FilteredLinkedList<Integer> list = new FilteredLinkedList<>(x -> false);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        TestUtils.assertArraysEquals(new String[]{"1#", "2#", "3#", "4#", "5#"}, list.map(addString));
    }

    private void testReduce() {
        ReduceInterface<Integer> sum = new ReduceInterface<Integer>() {
            @Override
            public Integer reduce(Integer x, Integer y) {
                return x + y;
            }
        };
        FilteredLinkedList<Integer> list = new FilteredLinkedList<>(x -> false);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        TestUtils.assertEquals(15, list.reduce(sum));
    }

    public void runTests() {
        testMap();
        testReduce();
        System.out.println("All MapReduce tests are passed.");
    }
}
